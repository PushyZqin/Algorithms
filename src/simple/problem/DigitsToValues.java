package simple.problem;

/**
 * 将罗马数字转换为阿拉伯数字
 * <p>
 * 罗马数字的含义：
 * 1. 相同数字连写，代表数字相加，如 III => 3
 * 2. 左边的数比右边小，则是用右边的数减去左边的，如 IV => 4
 * 3. 左边的数比右边大，则是用右边的数加上左边的，如 VI => 6
 *
 * @author Pushy
 * @since 2018/12/25 11:04
 */
public class DigitsToValues {

    private static char digits[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private static char values[] = {1, 5, 10, 50, 100, 500, 1000};

    public static void solution(String s) {

    }

    public static void main(String[] args) {
        DigitsToValues.solution("IV");
    }

}
