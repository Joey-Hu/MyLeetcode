package acmWinter;

import java.util.*;

/**
 * @author: huhao
 * @time: 2021/9/7 11:27
 * @desc: 约瑟夫环问题：leetcode 剑指offer 62
 */
public class p1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        // 处理第一个字符串
        for (Character ch : str1.toCharArray()) {
            if (ch != '#') {
                stack1.push(ch);
            }else {
                if (!stack1.empty()) {
                    stack1.pop();
                }
            }
        }
        // 处理第二个字符串
        for (Character ch : str2.toCharArray()) {
            if (ch != '#') {
                stack2.push(ch);
            }else {
                if (!stack2.empty()) {
                    stack2.pop();
                }
            }
        }

        StringBuilder sb1 = new StringBuilder();
        while (!stack1.empty()) {
            sb1.insert(0, stack1.pop());
        }

        StringBuilder sb2 = new StringBuilder();
        while (!stack2.empty()) {
            sb2.insert(0, stack2.pop());
        }


        if (sb1.toString().equals(sb2.toString())) {
            System.out.println(sb1.toString());
        }else {
            System.out.println(sb1.toString());
            System.out.println(sb2.toString());
        }
    }
}
