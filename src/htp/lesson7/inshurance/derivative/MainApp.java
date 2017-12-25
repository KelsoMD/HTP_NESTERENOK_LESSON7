package htp.lesson7.inshurance.derivative;

public class MainApp {

	public static void main(String[] args) {
		InshuranceCo brs = new InshuranceCo();
		brs.addNewClient();
		for (int i = 0; i < 4; i++) {
			brs.newCarCase(brs.getClients()[0]);
		}
		brs.inshuranceHistoryVehicle(brs.getClients()[0]);
	}
}
