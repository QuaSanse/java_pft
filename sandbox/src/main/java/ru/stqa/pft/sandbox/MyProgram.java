package ru.stqa.pft.sandbox;

public class MyProgram {
	
	public static void main (String[] ards) {

		hello ("world");
		hello ("user");
		hello ("Dima");
	}

	public static void hello (String h) {
		System.out.println("Hello," + h + "!");
	}

}
