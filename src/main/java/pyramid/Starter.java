package pyramid;

/**
 * @author Emelyanov (01.03.2017)
 */

public class Starter {

  public static void main(String[] args)  {
    Integer row = Integer.valueOf(args[0]);
    Integer pos = Integer.valueOf(args[1]);
    Pyramid pyramid = new Pyramid();
    pyramid.printWeight(row, pos);
    pyramid.printWeight(row, pos);
    pyramid.printWeight(row, pos);
  }

}
