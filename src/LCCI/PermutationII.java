package LCCI;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/8/16 15:21
 * @desc: https://leetcode-cn.com/problems/permutation-ii-lcci/
 */
public class PermutationII {
    /**
     * 队列
     */
    public String[] permutation(String S) {
        Queue<String> queue = new LinkedList<>();

        for(char ch:S.toCharArray()) {
            if(queue.isEmpty()){
                queue.offer(String.valueOf(ch));
            }else{
                int len = queue.size();
                for(int i=0; i<len; i++){
                    StringBuilder sb = new StringBuilder(queue.poll());
                    for(int j=0; j<sb.length(); j++){
                        StringBuilder sbNew = new StringBuilder(sb);
                        sbNew.insert(j, ch);
                        if (! queue.contains(sbNew.toString())){
                            queue.offer(sbNew.toString());
                        }
                    }
                }
            }
        }
        return queue.toArray(new String[0]);
    }
}
