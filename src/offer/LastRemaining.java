package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pushy zheng
 * @since 2019/8/8
 */
public class LastRemaining {

    public int LastRemaining_Solution(int n, int m) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

}
