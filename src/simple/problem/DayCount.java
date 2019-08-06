package simple.problem;

/**
 * 输入某年某月某日，判断这一天是这一年的第几天？
 * <p>
 * 程序分析：以3月5日为例，应该先把前两个月的加起来，然后再加上5天即本年的第几天。
 * 特殊情况，闰年且输入月份大于3时需考虑多加一天。
 *
 * @author Pushy
 * @since 2018/12/28 11:39
 */
public class DayCount {

    public static int solution(int year, int month, int day) {
        int[] monthDays = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};  // 每月的天数
        int res = 0;

        /* 判断是不是闰年，如果是闰年的话，2月是29天，则需要加上一天 */
        if (year % 4 == 0) {
            res++;
        }
        for (int i = 0; i < month; i++) { // 加上之前月份的天数
            res += monthDays[i];
        }
        res += day;  // 加上这个月的天数

        return res;
    }

    public static void main(String[] args) {
        int year = 2008;
        int month = 11;
        int day = 28;

        int result = DayCount.solution(year, month, day);
        System.out.println(result);
    }

}