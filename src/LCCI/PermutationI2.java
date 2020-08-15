package LCCI;

import java.util.*;

/**
 * @author: huhao
 * @time: 2020/8/13 20:37
 * @desc: https://leetcode-cn.com/problems/permutation-i-lcci/
 */
public class PermutationI2 {

    /**
     * 队列
     * 逐个遍历字符串的每一个字符，比如S="qwe"，首先queue插入"q"；再遍历到w，插入"q"的各个空位，得到"wq"和"qw"，插入到queue中；
     * 再遍历到'e'，插入queue中各个元素的各个空位，得到"ewq"，"weq"，"wqe"，"eqw"，"qew"，"qwe"；以此类推... ...
     * @param S
     * @return
     */
    public String[] permutation(String S) {
        Queue<String> queue = new LinkedList<>();
        for(char ch:S.toCharArray()){
            if(queue.isEmpty()){
                queue.offer(String.valueOf(ch));
            }else{
                // 将遍历到的字符插入queue中各个元素的各个空位
                int len = queue.size();
                for(int i = 0; i < len; ++i){
                    StringBuilder str = new StringBuilder(queue.poll());
                    for(int j = 0; j <= str.length(); ++j){
                        StringBuilder strNew = new StringBuilder(str);
                        strNew.insert(j, ch);
                        // 将获得的新元素插入queue
                        queue.offer(strNew.toString());
                    }
                }
            }
        }
        return queue.toArray(new String[0]);
    }



    public static void main(String[] args) {
        PermutationI2 permutationI2 = new PermutationI2();
        System.out.println(Arrays.toString(permutationI2.permutation("qwe")));
    }


}


