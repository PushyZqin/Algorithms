package offer;

/**
 * @author Pushy
 * @since 2019/5/27 11:04
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        int right = str.length() - 1;  // 旧字符串的尾指针
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') spaceNum++;
        }

        int newLength = str.length() + spaceNum * 2;   // 新字符串的长度
        str.setLength(newLength);
        int idx = newLength - 1;  // 新字符串的尾指针

        while (right >= 0 && right < newLength) {
            if (str.charAt(right) == ' ') {
                str.setCharAt(idx--, '0');
                str.setCharAt(idx--, '2');
                str.setCharAt(idx--, '%');
            } else {
                str.setCharAt(idx--, str.charAt(right));
            }
            right--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("we are happy");

        ReplaceSpace sol = new ReplaceSpace();
        String res = sol.replaceSpace(sb);
        System.out.println(res);
    }

}
