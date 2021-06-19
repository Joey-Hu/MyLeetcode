package leetcode;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/12/17 20:08
 * @desc:
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 1000; i ++) {
            if (isValid(i)) {
                System.out.println(i);
            }

        }
    }

    private static boolean isValid(int num) {
        while (num > 0) {
            int med = num % 10;
            if (med == 5) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }
}


