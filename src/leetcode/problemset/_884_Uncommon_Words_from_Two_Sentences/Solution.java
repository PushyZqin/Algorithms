package site.pushy.algorithms.leetcode.problemset._884_Uncommon_Words_from_Two_Sentences;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/25 9:26
 */
public class Solution {

    public String[] uncommonFromSentences(String A, String B) {
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");

        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < wordsA.length; i++) {
            mapA.put(wordsA[i], mapA.getOrDefault(wordsA[i], 0) + 1);
        }

        for (int i = 0; i < wordsB.length; i++) {
            mapB.put(wordsB[i], mapB.getOrDefault(wordsB[i], 0) + 1);
        }

        int i = 0, j = 0;
        while (i < wordsA.length || j < wordsB.length) {
            if (i < wordsA.length) {
                if (!mapB.containsKey(wordsA[i]) && mapA.get(wordsA[i]) == 1) {
                    res.add(wordsA[i]);
                }
                i++;
            }
            if (j < wordsB.length) {
                if (!mapA.containsKey(wordsB[j]) && mapB.get(wordsB[j]) == 1) {
                    res.add(wordsB[j]);
                }
                j++;
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public String[] uncommonFromSentences2(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word : A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word : B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> res = new ArrayList<>();
        for (String word : count.keySet()) {
            if (count.get(word) == 1) res.add(word);
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] res = solution.uncommonFromSentences2("gw pk xy", "gw aje zqd");
        System.out.println("res：" + Arrays.toString(res));
    }

}