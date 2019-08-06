package skill.bfs_dfs;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/1 13:59
 */
public class GraphSearch {

    /**
     * 图的广度优先搜索
     * @param graph
     * @param root  指定的图根节点
     */
    public static Map<String, String> BFS(Map<String, List<String>> graph, String root) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();  // 记录每个结点的直接父结点

        queue.offer(root);
        visited.add(root);
        parent.put(root, null);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            List<String> nodes = graph.get(vertex);

            for (String node : nodes) {
                if (!visited.contains(node)) {
                    queue.offer(node);
                    visited.add(node);
                    parent.put(node, vertex);
                }
            }
            System.out.print(vertex + " ");
        }
        System.out.println();
        return parent;
    }

    /**
     * 图的深度优先遍历
     * @param graph
     * @param root 指定的根结点
     */
    public static void DFS(Map<String, List<String>> graph, String root) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        stack.push(root);
        visited.add(root);

        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            List<String> nodes = graph.get(vertex);

            for (String node : nodes) {
                if (!visited.contains(node)) {
                    stack.push(node);
                    visited.add(node);
                }
            }
            System.out.print(vertex + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "C", "D"));
        graph.put("C", Arrays.asList("A", "B", "D", "E"));
        graph.put("D", Arrays.asList("B", "C", "E", "F"));
        graph.put("E", Arrays.asList("C", "D"));
        graph.put("F", Arrays.asList("B"));

        Map<String, String> parent = BFS(graph, "A");

        StringBuilder sb = new StringBuilder();
        String start = "E";
        while (start != null) {
            sb.append(start);
            start = parent.get(start);
            if (start != null) sb.append("->");
        }
        System.out.println("从E到A的最短路径为：" + sb.toString());

        System.out.println("DFS遍历结果：");
        DFS(graph, "A");
    }

}
