package ru.test2.program;

public class Point {
  public double x1;
  public double y1;
  public double x2;
  public double y2;

  public Point(double x, double y) {
    this.x1 = x;
    this.x2 = x;
    this.y1 = y;
    this.y2 = y;

  }





  public double distance(Point p2) {
    return Math.sqrt((p2.x2 - this.x1) * (p2.x2 - this.x1) + (p2.y2 - this.y1) * (p2.y2 - this.y1));
  }

}