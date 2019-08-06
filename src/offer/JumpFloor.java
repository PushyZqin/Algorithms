package offer;

public class JumpFloor {

    public int JumpFloor(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target - 1];
    }

    public static void main(String[] args) {
        JumpFloor s = new JumpFloor();
        System.out.println(s.JumpFloor(3));
    }

}
