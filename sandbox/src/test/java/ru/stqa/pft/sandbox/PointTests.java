package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void testDistanceN1 () {
    Point p1 = new Point(2, 4);
    Point p2 = new Point(6, 8);
    assert p1.distance(p2) == 5.656854249492381;
  }

  /*@Test
  public void testDistanceN2 () {
    Point p1 = new Point(2, 4);
    Point p2 = new Point(6, 8);
    assert p1.distance(p2) == 5;
  }*/

  @Test
  public void testDistanceN3 () {
    Point P1 = new Point(2, 4);
    Point P2 = new Point(6, 8);
    Assert.assertEquals(P1.distance(P2), 5.656854249492381);
  }

  /*@Test
  public void testDistanceN4 () {
    Point P1 = new Point(2, 4);
    Point P2 = new Point(6, 8);
    Assert.assertEquals(P1.distance(P2), 5);
  }*/

}
