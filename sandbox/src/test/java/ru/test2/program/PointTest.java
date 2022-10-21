package ru.test2.program;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  @Test
  public void testDistance() {
    Point p = new Point(1, 2, 2, 4);
    Assert.assertEquals(p.distance(), 2.2);
  }

  @Test
  public void testDistance2() {
    Point p = new Point(1, 2, 2, 4);
    Assert.assertEquals(p.distance(), 2.4);
  }

  @Test
  public void testDistance3() {
    Point p = new Point(1, 2, 2, 4);
    Assert.assertEquals(p.distance(), 2.23606797749979);
  }

}