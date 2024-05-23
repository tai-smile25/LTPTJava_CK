package app;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import entities.Patient;

public class Client {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			try(Socket socket = new Socket("192.168.227.1", 8888)) {
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				
				int choice = 0;
				System.out.print("Enter your choice: \n"
						+ "Get All\n");
				while(true) {
					choice = sc.nextInt();
					out.writeInt(choice);
					out.flush();
					
					switch (choice) {
					case 1:
//						sc.nextLine();
//						System.out.println("Enter the course title to search: ");
//						String title = sc.nextLine();
//						out.writeUTF(title);
//						out.flush();
						
						List<Patient> patients = (List<Patient>) in.readObject();
						patients.forEach(System.out::println);
						break;

					default:
						break;
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
