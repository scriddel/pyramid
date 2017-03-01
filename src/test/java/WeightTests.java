import org.junit.Assert;
import org.junit.Test;
import pyramid.Pyramid;

/**
 * @author Emelyanov (01.03.2017)
 */

public class WeightTests {

  public static Pyramid pyramid = new Pyramid();

  @Test
  public void test00() {
    Double weidth = pyramid.calcWeight(0, 0);
    Assert.assertEquals(weidth, 0, 0);
  }

  @Test
  public void test10() {
    Double weidth = pyramid.calcWeight(1, 0);
    Assert.assertEquals(weidth, 0.5, 0);
  }

  @Test
  public void test11() {
    Double weidth = pyramid.calcWeight(1, 1);
    Assert.assertEquals(weidth, 0.5, 0);
  }

  @Test
  public void test21() {
    Double weidth = pyramid.calcWeight(2, 1);
    Assert.assertEquals(weidth, 1.5, 0);
  }

  @Test
  public void test22() {
    Double weidth = pyramid.calcWeight(2, 2);
    Assert.assertEquals(weidth, 0.75, 0);
  }

  @Test
  public void test30() {
    Double weidth = pyramid.calcWeight(3, 0);
    Assert.assertEquals(weidth, 0.875, 0);
  }

  @Test
  public void test31() {
    Double weidth = pyramid.calcWeight(3, 2);
    Assert.assertEquals(weidth, 2.125, 0);
  }

  @Test
  public void testGlobal() {
    Double weidth = pyramid.calcWeight(322, 156);
    Assert.assertEquals(weidth, 306.48749781747574, 0);
  }

}
