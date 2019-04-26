package site.pushy.algorithms.simple.array;

public class ExistDuplicate {

    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] == nums[j]) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        ExistDuplicate solution = new ExistDuplicate();
        System.out.println(solution.containsDuplicate(array));
    }

}
