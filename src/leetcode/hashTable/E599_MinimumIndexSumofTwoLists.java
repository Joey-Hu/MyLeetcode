package leetcode.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/10/20 15:40
 * @desc: https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */
public class E599_MinimumIndexSumofTwoLists {

    /**
     * hashMap
     * 用两个 hashMap 分别记录每个 list 的餐馆名称和下标，然后找到两个 map 之间相同的 key，用 minIndexSum 记录最小值，如果有
     * 两个 key 的下标之和小于 minIndexSum，清空list res; 如果相等, list.add(key)
     * 时间 O(M + N)
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> restaurant1 = new HashMap<>();
        Map<String, Integer> restaurant2 = new HashMap<>();
        List<String> list = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            restaurant1.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            restaurant2.put(list2[i], i);
        }


        for (String restaurant : restaurant1.keySet()) {
            if (restaurant2.containsKey(restaurant)) {
                int indexSum = restaurant1.get(restaurant) + restaurant2.get(restaurant);
                if (indexSum <= minIndexSum) {
                    if (indexSum < minIndexSum) {
                        list.clear();
                        minIndexSum = indexSum;
                    }
                    list.add(restaurant);
                }
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
