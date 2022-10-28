package ru.test2.program;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  @Test
  public void testDistance() {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(3, 4);

    Assert.assertEquals(p1.distance(p2), 2.8284271247461903);
  }

  @Test
  public void testDistance2() {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(5, 6);
    Assert.assertEquals(p1.distance(p2), 5.656854249492381);
  }

  @Test
  public void testDistance3() {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(2, 4);
    Assert.assertEquals(p1.distance(p2), 2.23606797749979);
  }

}