package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/5 9:45
 * @desc: https://leetcode-cn.com/problems/bianry-number-to-string-lcci/
 */
public class BianryNumberToString {
    public String printBin(double num) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0.");

        for (int i=1; i<31 && num > 0; i++){
            if (num >= Math.pow(0.5, i)){
                num -= Math.pow(0.5, i);
                stringBuilder.append(1);
            }else {
                stringBuilder.append(0);
            }
        }

        return num == 0 ? stringBuilder.toString() : "ERROR";
    }
}
