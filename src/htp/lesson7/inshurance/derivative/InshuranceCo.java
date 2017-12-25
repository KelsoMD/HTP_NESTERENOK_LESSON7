package htp.lesson7.inshurance.derivative;

import htp.lesson7.inshurance.cases.CarCase;
import htp.lesson7.inshurance.cases.Case;

public class InshuranceCo {

	private Client[] clients = new Client[0];
	private Case[] cases = new Case[0];

	public void addClient(Client client) {
		Client[] temp = new Client[clients.length + 1];
		for (int i = 0; i < clients.length; i++) {
			temp[i] = clients[i];
		}
		temp[clients.length] = client;
		clients = temp;
	}

	public void addNewClient() {
		Client client = new Client();
		Client[] temp = new Client[clients.length + 1];
		for (int i = 0; i < clients.length; i++) {
			temp[i] = clients[i];
		}
		temp[clients.length] = client;
		clients = temp;
	}

	public void addCase(Case newCase) {
		Case[] temp = new Case[this.cases.length + 1];
		for (int i = 0; i < this.cases.length; i++) {
			temp[i] = this.cases[i];
		}
		temp[this.cases.length] = newCase;
		this.cases = temp;
		System.out.println("Case added");
	}

	public void newCarCase(Client client) {
		CarCase newCase = new CarCase(client);
		this.addCase(newCase);
	}

	public Client[] getClients() {
		return clients;
	}

	public Case[] getCases() {
		return cases;
	}
	
	
	public void insuranceHistory(Client client) {
		client.clientInfo();
		for (Case inshCase : client.getCases()) {
			inshCase.caseInfo();
		}
	}
	
	public void inshuranceHistoryVehicle(Client client) {
		client.clientInfo();
		for (Case inshCase : client.getCases()) {
			if (inshCase.getName().equals("Vehicle Insurance")) {
				inshCase.caseInfo();
			}
		}
	}
	
	
	
	

}
