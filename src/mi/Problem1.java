package mi;

/**
 * @author Pushy
 * @since 2018/12/29 22:23
 */
public class Problem1 {

    private static String solution(String line) {
//        String[] strings = line.split(" ");
//        return String.valueOf(Integer.valueOf(strings[0]) + Integer.valueOf(strings[1]));
        String[] strs = line.split(" ");
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        return String.valueOf(a + b);
    }

    public static void main(String[] args) {
        String res = Problem1.solution("4294967294");
        System.out.println(res);
    }

}
