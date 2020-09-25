package leetcode.array;

/**
 * @author: huhao
 * @time: 2020/9/25 21:13
 * @desc: https://leetcode.com/problems/corporate-flight-bookings/
 */
public class M1109_CorporateFlightBookings {

    /**
     * 暴力解法
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] seats = new int[n];

        for (int[] booking : bookings) {
            int numOfSeats = booking[2];
            for (int i = booking[0]; i <= booking[1] && i <= n; i ++) {
                seats[i-1] += numOfSeats;
            }
        }
        return seats;
    }

    /**
     * 前缀和
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] seats = new int[n];
        for(int[] b : bookings){
            seats[b[0] - 1] += b[2];
            if(b[1] < n) {
                seats[b[1]] -= b[2];
            }
        }
        for(int i = 1; i < n; i++){
            seats[i] += seats[i - 1];
        }
        return seats;
    }

    public static void main(String[] args) {
        int[][] bookings = new int[][]{{1,2,10}, {2,3,20}, {2,5,25}};
        new M1109_CorporateFlightBookings().corpFlightBookings2(bookings, 5);
    }

}
