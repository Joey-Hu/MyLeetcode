package leetcode.array;

/**
 * @author: huhao
 * @time: 2020/12/3 10:53
 * @desc: https://leetcode.com/problems/day-of-the-week/
 */
public class E1185_DayoftheWeek {

    /**
     * Zeller Formular 计算给定一天是星期几
     * https://www.cnblogs.com/greyqz/p/9780805.html
     * @param day
     * @param month
     * @param year
     * @return
     */
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if (month < 3) {
            month += 12;
            year -= 1;
        }

        int c = year / 100;
        year = year % 100;
        int w = (c / 4 - 2 * c + year + year / 4 + 13 * (month + 1) / 5 + day - 1) % 7;
        return days[(w+7) % 7];
    }
}
