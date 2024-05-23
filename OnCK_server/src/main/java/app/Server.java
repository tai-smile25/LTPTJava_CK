package app;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import entities.Patient;
import jakarta.persistence.EntityManager;
import service.EntityManagerFactoryUtil;
import service.PatientService;

public class Server {
	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(8888)) {
			System.out.println("Server started on port 8888");
			while(true) {
				Socket clientSocket = server.accept();
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
class ClientHandler implements Runnable{
	private Socket clientSocket;
	private EntityManagerFactoryUtil entityManagerFactoryUtil;
	private EntityManager entityManager;
	private PatientService patientService;
	
	public ClientHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
		this.entityManagerFactoryUtil = new EntityManagerFactoryUtil();
		this.entityManager = entityManagerFactoryUtil.getManager();
		this.patientService = new PatientService(this.entityManager);
	}

	@Override
	public void run() {
		try {
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			
			int choice = 0;
			while(true) {
				choice = in.readInt();
				switch (choice) {
				case 1:
//					String title = in.readUTF();
//					System.out.println("Client requested to search for: " + title);
					List<Patient> patients = patientService.findAll();
					out.writeObject(patients);
					out.flush();
					break;

				default:
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.entityManagerFactoryUtil.closeEnManager();
			this.entityManagerFactoryUtil.closeEnMaFactory();
		}
		
	}
}
