package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/21 21:42
 * @desc: https://leetcode-cn.com/problems/living-people-lcci/
 */
public class LivingPeople {
    /**
     * 双重循环
     * 从1900 - 2000遍历，当年份大于等于birth[i]且小于等于death[i]，curMaxLiving加一
     * @param birth
     * @param death
     * @return
     */
    public int maxAliveYear(int[] birth, int[] death) {

        int maxLivingYear = 1900;
        int maxLiving = 0;
        int curMaxLiving = 0;

        for (int year=1900; year<=2000; year++) {
            curMaxLiving = 0;
            for (int i=0; i<birth.length; i++) {
                if(birth[i]<=year && death[i]>=year) {
                    curMaxLiving++;
                }
            }
            if (curMaxLiving > maxLiving){
                maxLiving = curMaxLiving;
                maxLivingYear = year;
            }
        }
        return maxLivingYear;
    }

    public static void main(String[] args) {
        LivingPeople livingPeople = new LivingPeople();
        int[] birth = new int[]{1972,1908,1915,1957,1960,1948,1912,1903,1949,1977,1900,1957,1934,1929,1913,1902,1903,
                1901};
        int[] death = new int[]{1997,1932,1963,1997,1983,2000,1926,1962,1955,1997,1998,1989,1992,1975,1940,1903,1983,
                1969};
        livingPeople.maxAliveYear(birth, death);
    }
}
