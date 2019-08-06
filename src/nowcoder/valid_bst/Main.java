package nowcoder.valid_bst;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] tree = line.split(",");

            boolean res = solution(tree);
            System.out.println(res ? "True" : "False");
        }
    }

    private static boolean solution(String[] tree) {
        if (tree.length == 0) return true;

        return isValidBSF(tree, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBSF(String[] tree, int idx, int min, int max) {
        if (idx >= tree.length) return true;

        String node = tree[idx];
        if (node.equals("None")) return true;

        int val = Integer.parseInt(node);
        if (val <= min || val >= max) return false;

        int left = 2 * idx + 1, right = 2 * idx + 2;
        return isValidBSF(tree, left, min, val) && isValidBSF(tree, right, val, max);
    }


}