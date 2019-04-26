package site.pushy.algorithms.leetcode.problemset._331_Verify_Preorder_Serialization_of_a_Binary_Tree;

/**
 * @author Pushy
 * @since 2019/4/7 10:58
 */
public class Solution {

    public boolean isValidSerialization(String preorder) {
        // Todo isValidSerialization
        String[] strings = preorder.split(",");
        for (int i = 0; i < strings.length; i++) {
            String val = strings[i];

            System.out.println(val);
        }
        return true;
    }

    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";

        Solution solution = new Solution();
        boolean res = solution.isValidSerialization(preorder);
        System.out.println("res：" + res);
    }

}