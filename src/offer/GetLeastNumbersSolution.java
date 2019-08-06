package offer;

import java.util.ArrayList;
import java.util.Arrays;

public class GetLeastNumbersSolution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length) {
            return result;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

}
