package pyramid;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.*;

/**
 * @author Emelyanov (01.03.2017)
 */

public class Pyramid {

  private static final double BASIC_WEIGHT = 1.0;
  private final Map<String, Double> CACHE = new HashMap<>();

  public Double calcWeight(int row, int pos) {
    Double weight = 0d;

    //basic conditions
    if (row == 0 || pos - 1 > row)
      return weight;

    if (row == 1)
      return BASIC_WEIGHT / 2;

    String key = row + "::" + pos;
    if (pos == 0) {
      weight = CACHE.get(key);
      if (weight == null) {
        weight = (calcWeight(row - 1, 0) + BASIC_WEIGHT) / 2;
        CACHE.put(key, weight);
      }
    }

    if (pos == row) {
      weight = CACHE.get(key);
      if (weight == null) {
        weight = (calcWeight(row - 1, pos - 1) + BASIC_WEIGHT) / 2;
        CACHE.put(key, weight);
      }
    }

    weight = CACHE.get(key);
    if (weight == null) {
      weight = (calcWeight(row - 1, pos - 1) + BASIC_WEIGHT) / 2 + (calcWeight(row - 1, pos) + BASIC_WEIGHT) / 2;
      CACHE.put(key, weight);
    }
    return weight;
  }

  public void printWeight(int row, int pos) {
    Double weight = calcWeight(row, pos);
    out.println(String.format("Weight for element [%d x %d] is %.14f", row, pos, weight));
  }


}
