package site.pushy.algorithms.simple;

import java.lang.reflect.Method;

/**
 * @author Pushy
 * @since 2018/12/22 20:11
 */
public class CalculateRunTime {

    public interface Calculation {
        void call();
    }

    public static void run(Class<?> clazz) {
        run(clazz, "solution");
    }

    public static void run(Class<?> clazz, String methodName) {
        try {
            long start = System.nanoTime();

            Object object = clazz.newInstance();
            Method method = clazz.getMethod(methodName);
            method.invoke(object);

            long end = System.nanoTime();
            long time = end - start;
            System.out.println("共花费总时间为：" + time + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void run(Calculation calculation) {
        long start = System.currentTimeMillis();
        calculation.call();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("共花费总时间为：" + time + "ms");
    }

    public static void runByNano(Calculation calculation) {
        long start = System.nanoTime();
        calculation.call();
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("共花费总时间为：" + time + "ns");
    }

}
