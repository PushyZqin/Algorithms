package nowcoder.colorful_brick;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String brick = scanner.nextLine();
            int res = solution(brick.toCharArray());
            System.out.println(res);
        }
    }

    private static int solution(char[] brick) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < brick.length; i++) set.add(brick[i]);

        int colorNum = set.size();

        if (colorNum > 2) return 0;
        return colorNum == 1 ? 1 : 2;
    }

}