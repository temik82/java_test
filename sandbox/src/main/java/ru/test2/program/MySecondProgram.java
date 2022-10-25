package ru.test2.program;

public class MySecondProgram {
  public static void main(String[] args) {

    Point p1 = new Point(1, 2);
    Point p2 = new Point(2, 4);


    //дистанция между точками при использовании функции
    System.out.println("расстояния между точками 1" + "(" + p1.x + "," + p1.y + ")" + " и " + "(" + p2.x + "," + p2.y + ")" + " = " + distance(p1, p2));
    //дистанция между точками при использовании метода
    System.out.println("расстояния между точками 2" + "(" + p1.x + "," + p1.y + ")" + " и " + "(" + p2.x + "," + p2.y + ")" + " = " + p1.distance(p2));

  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
  }
}
