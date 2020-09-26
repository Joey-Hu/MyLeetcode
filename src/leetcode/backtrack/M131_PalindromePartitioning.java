package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/26 10:14
 * @desc: https://leetcode.com/problems/palindrome-partitioning/
 */
public class M131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        return res;

    }

    private void backtrack(List<List<String>> res, ArrayList<String> tempList, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(tempList));
        }else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s.substring(start, i+1))){
                    tempList.add(s.substring(start, i + 1));
                    backtrack(res, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length()-1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low ++;
            high --;
        }
        return true;
    }
}
