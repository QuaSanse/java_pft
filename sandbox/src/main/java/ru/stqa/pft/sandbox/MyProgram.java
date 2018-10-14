package ru.stqa.pft.sandbox;

public class MyProgram {
	
	public static void main (String[] ards) {

		hello ("world");
		hello ("user");
		hello ("Dima");

		double p1 = 2;
		double p2 = 4;
		System.out.println("Расстояние между точками p1 и p2 = " + distance (p1, p2));
	}

	public static void hello (String h) {
		System.out.println("Hello," + h + "!");
	}

	public static double distance(double p1, double p2) {
		return p2 - p1;
	}

}
