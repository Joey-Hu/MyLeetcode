package leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/11/25 16:16
 * @desc: https://leetcode.com/problems/minimum-time-difference/
 */
public class M539_MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        timePoints.add(timePoints.get(0));

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            minDiff = Math.min(minDiff, Math.abs(cal_Diff(timePoints.get(i-1), timePoints.get(i))));
        }
        return minDiff;
    }

    private int cal_Diff(String time1, String time2) {
        String[] split1 = time1.split(":");
        String[] split2 = time2.split(":");
        int HH1 = toInt(split1[0]);
        int MM1 = toInt(split1[1]);
        int HH2 = toInt(split2[0]);
        int MM2 = toInt(split2[1]);
        int res = 0;
        if (HH2 >= HH1 && MM2 >= MM1) {
            res = (HH2 - HH1) * 60 + (MM2 - MM1);
        }else if (HH2 >= HH1 && MM2 < MM1) {
            res = (HH2 - HH1 - 1)* 60 + (MM2 + 60 - MM1);
        }else if (HH2 < HH1 && MM2 >= MM1) {
            res = (HH2 + 24 - HH1) * 60 + (MM2 - MM1);
        }else if ((HH2 < HH1 && MM2 < MM1)){
            res = (HH2 + 24 - HH1 - 1) * 60 + (MM2 + 60 - MM1);
        }
        return res;
    }

    private int toInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res = res * 10 + ch - '0';
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> timePonts = new ArrayList<>();
        timePonts.add("23:59");
        timePonts.add("00:00");
        new M539_MinimumTimeDifference().findMinDifference(timePonts);
    }
}
