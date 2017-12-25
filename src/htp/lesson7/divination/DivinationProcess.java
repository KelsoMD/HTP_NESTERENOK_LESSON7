package htp.lesson7.divination;

import java.util.Scanner;

public class DivinationProcess {
	Scanner sc = new Scanner(System.in);
	String[] variants;
	Flower flower;

	public DivinationProcess() {
		this.getVariants();
		flower = new Flower();
		this.deviantFlowerCreation();
		this.getAnswers();
		System.out.println("Final answer is "+flower.leaves[flower.leaves.length-1]);
	}

	public void getVariants() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of variants");
		int numberOfVariants = sc.nextInt();
		variants = new String[numberOfVariants];
		for (int i = 0; i < variants.length; i++) {
			System.out.println("Enter " + (i+1) + " variant");
			variants[i] = sc.next();
		}
	}

	public void deviantFlowerCreation() {
		int answerCount=0;
		for (int i=0;i<flower.leaves.length;i++) {
			if (answerCount!=variants.length) {
				flower.leaves[i] = variants[answerCount];
				answerCount++;
			}
			if (answerCount == variants.length) {
				answerCount=0;
			}
		}
	}
	
	public void getAnswers() {
		for (int i=0;i<flower.getLeaves().length;i++) {
			System.out.println(flower.leaves[i]);
		}
	}
	
	
}
