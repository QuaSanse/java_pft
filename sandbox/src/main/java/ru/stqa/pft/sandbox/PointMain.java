package ru.stqa.pft.sandbox;

public class PointMain {
  public static void main(String[] args) {
    Point p1 = new Point (2,4);
    Point p2 = new Point(6,8);

    System.out.println ("Расстояние между точками p1 и p2 = " + distance (p1,p2));

  }
  public static double distance(Point p1, Point p2) {
    return Math.sqrt (((p2.x - p1.x)* (p2.x - p1.x)) + ((p2.y - p1.y)*(p2.y - p1.y)));
  }
}
