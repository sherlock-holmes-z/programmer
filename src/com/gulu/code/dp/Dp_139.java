package com.gulu.code.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 * <p>
 * 完全背包，求排列数；先遍历背包，再遍历物品
 *
 * @author chocolate
 * 2024/11/1 16:12
 */
public class Dp_139 {
    public static void main(String[] args) {
//        String s = "leetcode";
//        List<String> wordDict = Arrays.asList("leet", "code");
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                if (word.length() > i) {
                    continue;
                }
                if (dp[i - word.length()] == 1 && s.startsWith(word, i - word.length())) {
                    dp[i] = 1;
                }
            }
        }
        return dp[s.length()] == 1;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                int dictLength = wordDict.get(j).length();
                if (dictLength > i) {
                    continue;
                }
                String substring = s.substring(i - dictLength, i);
                if (substring.equals(wordDict.get(j)) && dp[i - dictLength] == 1) {
                    dp[i] = 1;
                }
            }
        }
        return dp[s.length()] == 1;
    }

}
