package offer;

public class LeftRotateString {

    public String LeftRotateString(String str,int n) {
        if (str == null || str.isEmpty() || n == 0 || n == str.length()) {
            return str;
        }

        int firstStart = 0, firstEnd = n - 1;
        int secondStart = n, secondEnd = str.length() - 1;

        char[] chars = str.toCharArray();
        reverse(chars, firstStart, firstEnd);
        reverse(chars, secondStart, secondEnd);
        reverse(chars, firstStart, secondEnd);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        LeftRotateString s = new LeftRotateString();
        System.out.println(s.LeftRotateString("abcXYZdef", 3));
    }

}
