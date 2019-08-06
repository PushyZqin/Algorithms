package simple.problem;

/**
 * 计算单词的个数
 *
 * @author Pushy
 * @since 2018/12/23 21:13
 */
public class WordCount {

    public static int solution(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (String.valueOf(word.charAt(i)).equals(" ")) {
                count++;
            }
        }
        return count + 1;
    }


    public static void main(String[] args) {
        String word = "Hello! Could I have your name?";
        int result = WordCount.solution(word);

        System.out.println(result);
    }

}