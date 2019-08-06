package offer;

import java.util.ArrayList;

public class FindContinuousSequence {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum < 3) return res;

        int start = 1, end = 2;
        int mid = (1 + sum) / 2;
        int curSum = start + end;

        while (start < mid) {
            if (curSum == sum) {
                addResult(start, end);
            }

            while (curSum > sum && start < mid) {
                curSum -= start;
                start++;

                if (curSum == sum)
                    addResult(start, end);
            }
            end++;
            curSum += end;
        }
        return res;
    }

    private void addResult(int start, int end) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        res.add(list);
    }

    public static void main(String[] args) {
        FindContinuousSequence s = new FindContinuousSequence();
        System.out.println(s.FindContinuousSequence(3));
    }

}
