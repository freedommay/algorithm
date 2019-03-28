package offer;

import java.util.ArrayList;
import java.util.List;

public class ProductExcludeItself {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        List<Long> res = new ArrayList<>();
        int size = nums.size();
        if (size == 0) return res;
        List<Long> left  = new ArrayList<>();
        List<Long> right  = new ArrayList<>();
        long productLeft = 1;
        long productRight = 1;

        for (int i = 0; i < size; i++) {
            left.add(productLeft);
            right.add(productRight);
            productLeft *= nums.get(i);
            productRight *= nums.get(size - 1 - i);
        }

        for (int i = 0; i < size; i++) {
            res.add(left.get(i) * right.get(size - i - 1));
        }

        return res;
    }
}
