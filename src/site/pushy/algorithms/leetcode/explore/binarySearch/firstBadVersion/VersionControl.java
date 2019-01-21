package site.pushy.algorithms.leetcode.explore.binarySearch.firstBadVersion;

/**
 * @author Pushy
 * @since 2019/1/19 19:05
 */
public class VersionControl {

    boolean isBadVersion(int version) {
        if (version == 1 || version == 2 || version == 3) {
            return false;
        } else {
            return true;
        }

    }

}
