package offer;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("fizz buzz");
            }
            else if (i % 3 == 0) {
                result.add("fizz");
            }
            else if (i % 5 == 0) {
                result.add("buzz");
            }
            else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
