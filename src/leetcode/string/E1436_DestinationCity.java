package leetcode.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: huhao
 * @time: 2020/9/28 13:45
 * @desc: https://leetcode.com/problems/destination-city/
 */
public class E1436_DestinationCity {
    /**
     * 利用set属性，先添加所有的目的节点，然后删除起始节点，没有对应删除的就是最终目的地
     * @param paths
     * @return
     */
    public String destCity(List<List<String>> paths) {
        Set<String> places = new HashSet<>();
        for (List<String> path : paths) {
            places.add(path.get(1));
        }
        for (List<String> path : paths) {
            places.remove(path.get(0));
        }
        return places.iterator().next();
    }
}
