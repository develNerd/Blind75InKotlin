package bonus;

import java.util.ArrayList;

class VendingItem {
    int column;
    int row;
    int costCents;
    int remainingQuantity;

    VendingItem(long[] arr) {
        this.column = (int)arr[0];
        this.row = (int)arr[1];
        this.costCents = (int)arr[2];
        this.remainingQuantity = (int)arr[3];
    }
}
public class Rema {

    public static void main(String[] args) {
       // System.out.println(solution(new long[]{9,5,12,6,5,4,1}));
    }

    public static long solution(long[][] inventory, long[][] purchaseAttempts) {
        ArrayList<VendingItem> items = new ArrayList();
        for (long[] item : inventory) {
            items.add(new VendingItem(item));
        }

        int columnCount = items.stream().mapToInt(item -> item.row).reduce(0, (acc, item) -> Math.max(acc, item)) + 1;
        int rowCount = items.stream().mapToInt(item -> item.column).reduce(0, (acc, item) -> Math.max(acc, item)) + 1;

        VendingItem[][] grid = new VendingItem[columnCount][rowCount];
        for (VendingItem item : items) {
            grid[item.column][item.row] = item;
        }

        for (long[] purchaseCoordinate : purchaseAttempts) {
            if (purchaseCoordinate.length != 2) {
                continue;
            }

            int purchaseColumn = (int)purchaseCoordinate[0];
            int purchaseRow = (int)purchaseCoordinate[1];
            if (grid.length <= purchaseColumn) {
                continue;
            }

            VendingItem[] column = grid[purchaseColumn];
            if (column == null || column.length <= purchaseRow) {
                continue;
            }

            VendingItem item = column[purchaseRow];
            item.remainingQuantity--;
        }

        int sum = 0;
        for (VendingItem item : items) {
            sum += item.remainingQuantity * item.costCents;
        }

        return sum;
    }

}
