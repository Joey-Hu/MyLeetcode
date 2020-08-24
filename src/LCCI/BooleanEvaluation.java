package LCCI;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/8/24 15:26
 * @desc: https://leetcode-cn.com/problems/boolean-evaluation-lcci/
 */
public class BooleanEvaluation {

    Map<String, Integer> map = new HashMap<>();

    /**
     * 将问题划分为子问题，对子问题递归求解
     * 例：s = "1^0|0|1"可分解为
     * 1 ^ 0|0|1
     * 1^0 | 0|1
     * 1^0|0 | 1
     * @param s
     * @param result
     * @return
     */
    public int countEval(String s, int result) {
        if (s.length() == 1){
            if (s.equals(String.valueOf(result))) {
                return 1;
            }else {
                return 0;
            }
        }

        int res = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '1' || s.charAt(i) == '0') {
                continue;
            }
            String left = s.substring(0, i);
            String right = s.substring(i+1);

            if (map.get(left+"0") == null) {
                map.put(left+"0", countEval(left, 0));
            }
            if(map.get(left+"1") == null)
                map.put(left+"1", countEval(left, 1));
            if(map.get(right+"0") == null)
                map.put(right+"0", countEval(right, 0));
            if(map.get(right+"1") == null)
                map.put(right+"1", countEval(right, 1));

            int left_0 = map.get(left+"0");
            int left_1 = map.get(left+"1");
            int right_0 = map.get(right+"0");
            int right_1 = map.get(right+"1");

            if(s.charAt(i) == '&'){
                if(result == 0){
                    res += (left_0 * right_0 + left_0 * right_1 + left_1 * right_0);
                }else{
                    res += (left_1 * right_1);
                }
            }else if(s.charAt(i) == '|'){
                if(result == 0){
                    res += (left_0 * right_0);
                }else{
                    res += (left_1 * right_1 + left_0 * right_1 + left_1 * right_0);
                }
            }else{
                if(result == 0){
                    res += (left_1 * right_1 + left_0 * right_0);
                }else{
                    res += (left_0 * right_1 + left_1 * right_0);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BooleanEvaluation booleanEvaluation = new BooleanEvaluation();
        System.out.println(booleanEvaluation.countEval("1^0|0|1", 0));
    }
}
