package entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@MappedSuperclass
public abstract class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "person_id")
	protected String id;
	protected String name;
	protected String phone;

	public Person() {
		super();
	}

	public Person(String id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	

}
