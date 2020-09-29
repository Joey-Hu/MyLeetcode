package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/29 15:40
 * @desc: https://leetcode.com/problems/search-suggestions-system/
 */
public class M1268_SearchSuggestionsSystem {
    /**
     * sort & binary search
     * @param products
     * @param searchWord
     * @return
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> res = new ArrayList<>();

        // 先对字符串数组排序
        Arrays.sort(products);

        for (int i = 1; i <= searchWord.length(); i++) {
            String input = searchWord.substring(0, i);
            int k = Arrays.binarySearch(products, input);
            // 当存在多个产品时以input开头时，找到第一个
            while (k > 0 && input.equals(products[k-1])) {
                k--;
            }
            // 当不存在product是以input开头时
            if (k < 0) {
                k = ~k;
            }

            List<String> suggestion = new ArrayList<>();
            for (int j = k+3; k < products.length && k < j && products[k].startsWith(input); k++) {
                suggestion.add(products[k]);
            }
            res.add(suggestion);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        new M1268_SearchSuggestionsSystem().suggestedProducts(products, searchWord);
    }
}
