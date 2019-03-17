package offer;

public class ReplaceBlank {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        if (string == null) return 0;
        int spaceNumber = 0;
        for (char c: string) {
            if (c == ' ') {
                spaceNumber++;
            }
        }
        int newLength = length + 2 * spaceNumber;
        int p1 = length - 1;
        int p2 = newLength - 1;
        while (p1 != p2) {
            if (string[p1] != ' ') {
                string[p2] = string[p1];
                p1--;
                p2--;
            } else {
                string[p2--] = '0';
                string[p2--] = '2';
                string[p2--] = '%';
                p1--;
            }
        }
        return newLength;
    }
}
