package org.iGov.Spring.Hello.customer;

public class Customer {
	
	private String name;
	private String surname;
	private int age;

	public Customer() {

	}

	public Customer(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
