package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void testDistance () {
    Point p1 = new Point(2, 4);
    Point p2 = new Point(6, 8);

    //double distance = Math.sqrt (((p2.x - p1.x)* (p2.x - p1.x)) + ((p2.y - p1.y)*(p2.y - p1.y)));

    //assert == 5.656854249492381;
  }

}
