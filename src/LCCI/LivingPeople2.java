package LCCI;

import java.time.Year;

/**
 * @author: huhao
 * @time: 2020/8/21 21:42
 * @desc: https://leetcode-cn.com/problems/living-people-lcci/
 */
public class LivingPeople2 {
    /**
     * 数组保存每年新增人数
     * @param birth
     * @param death
     * @return
     */
    public int maxAliveYear(int[] birth, int[] death) {

        int maxLivingYear = 1900;
        int[] change = new int[102];
        int curLiving = 0;
        int maxLiving = 0;

        for (int i=0; i<birth.length; i++) {
            change[birth[i]-1900]++;
            change[death[i]-1899]--;
        }
        for (int year = 1; year<101; year++) {
            curLiving += change[year];
            if(curLiving>maxLiving) {
                maxLivingYear = year + 1900;
                maxLiving = curLiving;
            }
        }
        return maxLivingYear;
    }

    public static void main(String[] args) {
        LivingPeople2 livingPeople = new LivingPeople2();
        int[] birth = new int[]{1972,1908,1915,1957,1960,1948,1912,1903,1949,1977,1900,1957,1934,1929,1913,1902,1903,
                1901};
        int[] death = new int[]{1997,1932,1963,1997,1983,2000,1926,1962,1955,1997,1998,1989,1992,1975,1940,1903,1983,
                1969};
        livingPeople.maxAliveYear(birth, death);
    }
}
