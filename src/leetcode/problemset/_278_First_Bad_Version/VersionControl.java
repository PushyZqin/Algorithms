package site.pushy.algorithms.leetcode.problemset._278_First_Bad_Version;

/**
 * @author Pushy
 * @since 2019/4/26 9:39
 */
public class VersionControl {

    private static final int target = 4;

    public boolean isBadVersion(int n) {
        return n >= target;
    }

}
