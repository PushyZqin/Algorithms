package site.pushy.algorithms.leetcode.explore.queueStack.canVisitAllRooms;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/8 11:21
 */
public class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        visited[0] = true;
        visitNext(rooms, visited, rooms.get(0));

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void visitNext(List<List<Integer>> rooms, boolean[] visited, List<Integer> keys) {
        for (Integer key : keys) {
            if (!visited[key]) {
                visited[key] = true;
                List<Integer> newKeys = rooms.get(key);
                visitNext(rooms, visited, newKeys);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        Solution solution = new Solution();
        boolean res = solution.canVisitAllRooms(rooms);
        System.out.println("res：" + res);
    }

}