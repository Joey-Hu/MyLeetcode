package LCCI;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

/**
 * @author: huhao
 * @time: 2020/8/19 22:26
 * @desc: https://leetcode-cn.com/problems/find-closest-lcci/
 */
public class FindClosest {
    /**
     * 双指针
     * 用两个指针一直记录两个单词出现的下标，在一次遍历数组的循环中，不断记录两个下标差值的最小值，返回结果即可。
     * O(N)
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int findClosest(String[] words, String word1, String word2) {

        int index1 = -1;
        int index2 = -1;
        int minDistance = words.length;

        for (int i=0; i<words.length; i++) {
            if (words[i] == word1) {
                index1 = i;
            }
            else if (words[i] == word2) {
                index2 = i;
            }
            if(index1 != -1 && index2 != -1) {
                minDistance = Math.min(Math.abs(index1-index2), minDistance);
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"I","am","a","student","from","a","university","in","a","city"};
        String word1 = "a";
        String word2 = "student";

        FindClosest findClosest = new FindClosest();
        System.out.println(findClosest.findClosest(words, word1, word2));
    }
}
