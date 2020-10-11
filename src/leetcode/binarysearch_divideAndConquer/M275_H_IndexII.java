package leetcode.binarysearch_divideAndConquer;

import LCCI.Tictactoe;
import com.sun.media.sound.RIFFInvalidDataException;

/**
 * @author: huhao
 * @time: 2020/10/11 19:30
 * @desc: https://leetcode.com/problems/h-index-ii/
 */
public class M275_H_IndexII {

    /***
     * 一般的二分查找，注意终止条件
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {

        if (citations.length == 0) {
            return 0;
        }

        int low = 0;
        int high = citations.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] == citations.length-mid) {
                return citations[mid];
            }else if (citations[mid] < high-low+1) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return citations.length - high - 1;
    }
}
