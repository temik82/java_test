package ru.test2.program;

public class MySecondProgram {
  public static void main(String[] args) {

    Point p1 = new Point(1, 2);
    Point p2 = new Point(2, 4);
    

    //дистанция между точками при использовании функции
    System.out.println("расстояния между точками 1" + "(" + p1.x1 + "," + p1.y1 + ")" + " и " + "(" + p2.x2 + "," + p2.y2 + ")" + " = " + distance(p1, p2));
    //дистанция между точками при использовании метода
    System.out.println("расстояния между точками 2" + "(" + p1.x1 + "," + p1.y1 + ")" + " и " + "(" + p2.x2 + "," + p2.y2 + ")" + " = " + p1.distance(p2));

  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p2.x2 - p1.x1) * (p2.x2 - p1.x1) + (p2.y2 - p1.y1) * (p2.y2 - p1.y1));
  }
}
