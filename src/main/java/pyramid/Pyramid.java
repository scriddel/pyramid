package pyramid;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.*;

/**
 * @author Emelyanov (01.03.2017)
 */

public class Pyramid {

  private static final double BASIC_WEIGHT = 1.0;
  private static final Map<String, Double> WEIGHT_CACHE = new HashMap<>();

  public Double calcWeight(int row, int pos) {
    Double weight = 0d;

    //basic conditions
    if (row == 0 || pos - 1 > row)
      return weight;

    if (row == 1)
      return BASIC_WEIGHT / 2;

    String key = row + "::" + pos;
    weight = WEIGHT_CACHE.get(key);

    if (weight == null) {
      if (pos == 0)
          weight = (calcWeight(row - 1, 0) + BASIC_WEIGHT) / 2;
      else if (pos == row)
        weight = (calcWeight(row - 1, pos - 1) + BASIC_WEIGHT) / 2;
      else
        weight = (calcWeight(row - 1, pos - 1) + BASIC_WEIGHT) / 2 + (calcWeight(row - 1, pos) + BASIC_WEIGHT) / 2;
      WEIGHT_CACHE.put(key, weight);
    }
    return weight;
  }

  public void printWeight(int row, int pos) {
    Double weight = calcWeight(row, pos);
    out.println(String.format("Weight for element [%d x %d] is %s", row, pos, weight));
  }


}
