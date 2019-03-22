package offer;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumber {
    /**
     * @param nums: n non-negative integer array
     * @return: A string
     */
    public String minNumber(int[] nums) {
        int len = nums.length;
        if (len == 0) return "";
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new numComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }

        String res = sb.toString().replaceFirst("^0*", "");
        if (res.equals("")) {
            res = "0";
        }
        return res;
    }

    private class numComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String ab = a.concat(b);
            String ba = b.concat(a);
            return ab.compareTo(ba);
        }
    }
}
