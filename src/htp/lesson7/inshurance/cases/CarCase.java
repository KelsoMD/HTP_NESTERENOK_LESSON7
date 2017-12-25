package htp.lesson7.inshurance.cases;

import java.util.Scanner;

import htp.lesson7.inshurance.derivative.Client;

public class CarCase extends Case {

	private int carAge;
	private boolean abroad;
	private int expirience;
	private int anotherCases = 0;

	{
		name = "Vehicle Insurance";
		maxLimit = 200000;
		minLimit = 1000;
		coef = new double[6];
		basetarif = 0.04;
	}

	public CarCase(Client client) {
		id = "VI " + idCount;
		this.client = client;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter inshurance sum:");
		this.sum = sc.nextInt();

		System.out.println("Enter vehicle age:");
		carAge = sc.nextInt();
		double tempcoef = 1;
		if (carAge < 7) {
			tempcoef = (double) (carAge * 0.04 + 1);
		}
		if (carAge >= 7) {
			tempcoef = 1.28;
		}
		coef[0] = tempcoef;

		System.out.println("Do client driving abroad? (true/false)");
		String answer = sc.next();
		if (answer.compareToIgnoreCase("true") == 0) {
			abroad = true;
			coef[1] = 1;
		}
		if (answer.compareToIgnoreCase("false") == 0) {
			abroad = false;
			coef[1] = 0.95;
		}

		System.out.println("Enter expirience year:");
		expirience = sc.nextInt();
		if (expirience < 2) {
			coef[2] = 1.1;
		}
		if (expirience >= 2) {
			coef[2] = 1;
		}

		if (client.getAge() <= 25) {
			coef[3] = 1.1;
		}
		if (client.getAge() > 25 && client.getAge() <= 36) {
			coef[3] = 1;
		}
		if (client.getAge() > 37) {
			coef[3] = 0.85;
		}
		for (int i = 0; i < client.getCases().length; i++) {
			if (client.getCases()[i].getName().equals("Appartement Inshurance")) {
				anotherCases++;
				break;
			}
		}
		for (int i = 0; i < client.getCases().length; i++) {
			if (client.getCases()[i].getName().equals("Accident Inshurance")) {
				anotherCases++;
				break;
			}
		}
		switch (anotherCases) {
		case 0:
			coef[4] = 1;
			break;
		case 1:
			coef[4] = 0.98;
			break;
		case 2:
			coef[4] = 0.95;
			break;
		}

		System.out.println("Had accidents last year?");
		String answer2 = sc.next();
		if (answer2.compareToIgnoreCase("true") == 0) {
			client.gotAccident();
			switch (client.getNoAccidentBonus()) {
			case 0:
				coef[5] = 1;
				break;
			case 1:
				coef[5] = 0.9;
				break;
			case 2:
				coef[5] = 0.85;
				break;
			case 3:
				coef[5] = 0.8;
				break;
			}

		}
		if (answer2.compareToIgnoreCase("false") == 0) {
			switch (client.getNoAccidentBonus()) {
			case 0:
				coef[5] = 1;
				break;
			case 1:
				coef[5] = 0.9;
				break;
			case 2:
				coef[5] = 0.85;
				break;
			case 3:
				coef[5] = 0.8;
				break;
			}
			if (client.getNoAccidentBonus() < 3) {
				client.riseBonus();
			}
		}

		double tempprice = sum * basetarif;
		for (int i = 0; i < coef.length; i++) {
			tempprice = tempprice * coef[i];
		}
		price = (int) tempprice;
		idCount = idCount + 1;

		System.out.println("New Vehicle Insurance created");
		System.out.println("Client " + client.getFirstName() + " " + client.getName());
		System.out.println("Inshurance sum is " + this.sum);
		System.out.println("Price is " + this.price);
		this.client.addCase(this);
	}

	@Override
	public void caseInfo() {
		System.out.println("Case: " + this.getName() + " ID: " + this.getId() + " Client ID: " + client.getId());
		System.out.println("Inshuranse sum: " + this.getSum());
		System.out.println("Vehickle age: " + this.getCarAge() + " (" + coef[0] + ") Abroad: " + this.isAbroad() + " ("
				+ coef[1] + ") Expirience: " + this.getExpirience() + " (" + coef[2] + ")");
		System.out.println("Client age: " + client.getAge() + " (" + coef[3] + ") Another cases: "
				+ this.getAnotherCases() + " (" + coef[4] + ")");
		System.out.println("Bonus category: " + "(" + coef[5] + ")");
		System.out.println("Price: " + this.getPrice());
	}

	public String getId() {
		return id;
	}

	public int getCarAge() {
		return carAge;
	}

	public boolean isAbroad() {
		return abroad;
	}

	public int getExpirience() {
		return expirience;
	}

	public int getAnotherCases() {
		return anotherCases;
	}

}
