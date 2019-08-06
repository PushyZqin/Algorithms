package skill;

import java.util.LinkedList;
import java.util.List;

public class Permutation {

    public List<String> solve(String str) {
        List<String> res = new LinkedList<>();
        char[] chars = str.toCharArray();

        permutation(chars, 0, res);

        return res;
    }

    private void permutation(char[] chars, int start, List<String> res) {
        if (chars == null || chars.length == 0) return;

        if (start == chars.length - 1 && !res.contains(new String(chars))) {
            res.add(new String(chars));
        }
        else {
            for (int i = start; i < chars.length; i++) {
                swap(chars, start, i);
                permutation(chars, start + 1, res);
                swap(chars, start, i);
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.solve("abc"));
    }

}
