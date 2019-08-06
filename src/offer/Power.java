package offer;

public class Power {

    /**
     * 需要注意 exponent 有可能为负数的情况
     * 如果 exponent 为负数，则对结果进行求导，首先需要排除掉base=0的输入
     */
    public static double pow(double base, int exponent) {
        if (base == 0.0 && exponent < 0) {
            throw new RuntimeException("The base number is error.");
        }

        int absExponent = Math.abs(exponent);
        double res = 1.0;
        for (int i = 1; i <= absExponent; i++) {
            res *= base;
        }
        if (exponent < 0)
            res = 1.0 / res;
        return res;
    }

    public static double powRec(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        double res = powRec(base, exponent / 2);

        res *= res;
        if (exponent % 2 == 1) {
            res *= base;
        }
        return res;
    }

    public static void main(String[] args) {
        double res = pow(2, -1);
        System.out.println(res);
    }

}