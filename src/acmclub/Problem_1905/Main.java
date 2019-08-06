package acmclub.Problem_1905;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pushy
 * @since 2019/4/27 10:28
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            double a = Double.parseDouble(arr[0]);
            double b = Double.parseDouble(arr[1]);
            double c = Double.parseDouble(arr[2]);

            String res = solution(a, b, c);
            System.out.println(res);
        }
    }

    public static String solution(double a, double b, double c) {
        double s = b * b - (4 * a * c);

        if (a == 0 && b != 0 && c != 0) {  // 一元一次方程，一个根
            double root = -c / b;
            return String.format("%.2f", root);
        }
        else if (a == 0 && b == 0 && c == 0) {  // 无穷解
            return "Unlimited Answers.";
        }
        else if (a == 0 && b == 0 && c != 0) {  // 无根
            return "No ConstructFromInorderAndPostorder.";
        }
        else if (s < 0 && a != 0) {  // △ < 0，无解
            return "No ConstructFromInorderAndPostorder.";
        }
        else if (s == 0 && a != 0) {  // 两个相同的根
            double root = (-b) / (2 * a);
            return String.format("%.2f", root);
        }
        else if (s > 0 && a != 0) {  // 两个不同的根
            StringBuilder sb = new StringBuilder();
            double e = Math.sqrt(s);
            double r1 = (-b - e) / (2 * a);
            double r2 = (-b + e) / (2 * a);

            sb.append(String.format("%.2f", Math.min(r1, r2))).append(" "); // small
            sb.append(String.format("%.2f", Math.max(r1, r2)));             // big
            return sb.toString();
        }
        else {
            return "";
        }
    }

}
