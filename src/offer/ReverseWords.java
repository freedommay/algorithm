package offer;

public class ReverseWords {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        s = s.trim();
        s = reverse(s);
        String[] strs = s.split("\\s+");
        for (int i = 0, len = strs.length; i < len; i++) {
            strs[i] = reverse(strs[i]);
        }
        s = String.join(" ", strs);
        return s;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder().append(s).reverse();
        s = sb.toString();
        return s;
    }
}
