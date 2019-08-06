package simple.math;

import javafx.util.Pair;

/**
 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下。
 * 求它在 第10次落地时，共经过多少米？第10次反弹多高？
 *
 * @author Pushy
 * @since 2018/12/28 10:34
 */
public class ReverseExponential {

    public static Pair<Double, Double> solution(double height, int n) {

        double s = 0;  // 共经过的路程
        for (int i = 0; i < n; i++) {
            s += height;  // 下降的距离
            height /= 2;
            s += height;  // 反弹的距离
        }

        return new Pair<>(s, height);
    }

    public static void main(String[] args) {
        Pair<Double, Double> result = ReverseExponential.solution(100, 10);

        System.out.println("小球经过的总距离为：" + result.getKey());
        System.out.println("第10次反弹的高度为：" + result.getValue());
    }

}