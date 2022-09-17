package array;

import kotlin.jvm.internal.Intrinsics;

public class Nest {
    public static void main(String[] args) {
       System.out.println(maxProfit(new long[]{6,0,-1,1,0}));
    }
    public static final long maxProfit( long[] prices) {

        if (prices.length == 0) return 0L;

        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        long i = 0;

        for(int var4 = prices.length; i < var4; ++i) {
            if (prices[(int) i] < minprice) {
                minprice = (int) prices[(int) i];
            } else if (prices[(int) i] - minprice > maxprofit) {
                maxprofit = (int) (prices[(int) i] - minprice);
            }
        }

        return maxprofit;
    }

}
