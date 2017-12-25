package htp.lesson7.inshurance.derivative;

import java.util.Scanner;

import htp.lesson7.inshurance.cases.Case;

public class Client {
	
	private String name;
	private String firstName;
	private int id;
	static int idCount =1;
	private String passportId;
	private int age;
	private int noAccidentBonus;
	
	Case[] cases;
	
	public Client() {
		noAccidentBonus = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Client name:");
		this.name = sc.nextLine();
		System.out.println("Enter Client first name:");
		this.firstName = sc.nextLine();
		System.out.println("Enter Client age:");
		this.age = sc.nextInt();
		System.out.println("Enter CLient passport id (MP2554687):");
		this.passportId = sc.next();
		cases = new Case[0];
		id = idCount;
		idCount++;
	}
	
	
	public void addCase(Case newCase) {
		Case[] temp = new Case[cases.length + 1];
		for (int i = 0; i < cases.length; i++) {
			temp[i] = cases[i];
		}
		temp[cases.length] = newCase;
		cases = temp;
		System.out.println("Cass added to client");
	}


	public String getName() {
		return name;
	}


	public String getFirstName() {
		return firstName;
	}


	public int getId() {
		return id;
	}


	public String getPassportId() {
		return passportId;
	}

	public int getAge() {
		return age;
	}
	

	public int getNoAccidentBonus() {
		return noAccidentBonus;
	}
	public void riseBonus() {
		this.noAccidentBonus++;
	}
	public Case[] getCases() {
		return cases;
	}
	 public void gotAccident() {
		 this.noAccidentBonus=0;
	 }
	 
	 public void clientInfo(){
		 System.out.println("ID: "+this.getId()+" Name: "+ this.getName()+" "+this.getFirstName());
		 System.out.println("PassportID: "+ this.getPassportId());
		 System.out.println("Age: "+ this.getAge()+" Bonus for no accidents: "+this.getNoAccidentBonus());
	 }
	
	
	

}
