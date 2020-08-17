package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/17 16:11
 * @desc:
 */
public class SwapNumbers {
    public int[] swapNumbers(int[] numbers) {

        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];

        return numbers;
    }

    public static void main(String[] args) {
        SwapNumbers swapNumbers = new SwapNumbers();
        swapNumbers.swapNumbers(new int[]{1, 2});
    }
}
