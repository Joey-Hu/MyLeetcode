package leetcode.string;

/**
 * @author: huhao
 * @time: 2020/9/28 9:49
 * @desc: https://leetcode.com/problems/defanging-an-ip-address/
 */
public class E1108_DefanginganIPAddress {
    public String defangIPaddr(String address) {
        String res = "";
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                res += "[.]";
            }else {
                res += address.charAt(i);
            }
        }
        return res;
    }
}
