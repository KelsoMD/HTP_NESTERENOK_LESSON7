package htp.lesson7.inshurance.cases;

import htp.lesson7.inshurance.derivative.Client;

public class Case {
	
	static String name;
	int price;
	static int maxLimit;
	static int minLimit;
	int sum;
	double[] coef;
	Client client;
	double basetarif;
	String id;
	static int idCount=1;
	
	public Case() {
		
	}
	
	public static String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	public static int getMaxLimit() {
		return maxLimit;
	}
	public static void setMaxLimit(int maxLimit) {
		Case.maxLimit = maxLimit;
	}
	public static int getMinLimit() {
		return minLimit;
	}
	public static void setMinLimit(int minLimit) {
		Case.minLimit = minLimit;
	}
	public int getSum() {
		return sum;
	}
	public double[] getCoef() {
		return coef;
	}
	public void caseInfo() {
		
	}
	
	
	
}
