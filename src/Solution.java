import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        scanner.close();
        System.out.println(decompression(next));
    }

    public static  String decompression(String str) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while(i < str.length()) {
            if (str.charAt(i) == '[' || str.charAt(i) == '|') {
                stack.push(i);
            }else if (str.charAt(i) == ']') {
                int interval = stack.pop();
                int leftChar = stack.pop();
                int times = 0;
                for (int t = leftChar + 1; t <= interval; t ++) {
                    times = times * 10 + (str.charAt(t) - '0');
                }

                for (int j = 0; j < times; j++) {
                    sb.append(str.substring(interval+1, i));
                }
            } else {
                if (stack.empty()) {
                    sb.append(str.charAt(i));
                }
            }
            i++;
        }
        return sb.toString();
    }
}