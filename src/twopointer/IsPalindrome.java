package twopointer;

public class IsPalindrome {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 0) return true;
        int left = 0, right = len - 1;
        s = s.toLowerCase();
        while (left < right) {
            while (left < len && !isValid(s.charAt(left))) left++;
            if (left == len) return true;
            while (right >= 0 && !isValid(s.charAt(right))) right--;
            if (s.charAt(left) != s.charAt(right)) {
                return left >= right;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
