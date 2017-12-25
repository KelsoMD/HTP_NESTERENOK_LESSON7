package htp.lesson7.divination;

public class Flower {
	String[] leaves;
	
	public Flower() {
		this.generateFlower();
	}
	
	public void generateFlower() {
		leaves = new String[(int)(Math.random()*35+20)];
		for (int i=0;i<leaves.length;i++) {
			leaves[i] = "Answer";
		}
	}

	public String[] getLeaves() {
		return leaves;
	}

	public void setLeaves(String[] leaves) {
		this.leaves = leaves;
	}
	
	
}
