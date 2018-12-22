package site.pushy.algorithms.simple.array;

class RotateArray {

    public void rotate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        RotateArray solution = new RotateArray();
        solution.rotate(array, k);
    }

}