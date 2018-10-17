package ru.stqa.pft.sandbox;

public class MyProgram {
	
	public static void main (String[] ards) {

		hello ("world");
		hello ("user");
		hello ("Dima");


		Point p1 = new Point(2, 4);
		Point p2 = new Point(6, 8);
		double d = Math.sqrt (p2.x - p1.x) + (p2.y - p1.y);
		//p1.x = 2;
		//p1.y = 4;
		//p2.x = 6;
		//p2.y = 8;

			System.out.println("Расстояние между точками p1 и p2 = " + d);
	}

	public static void hello (String h) {

	  System.out.println("Hello," + h + "!");
	}

	public static void distance(Point p1, Point p2) {
	  return;
 	}

}
