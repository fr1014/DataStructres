package algorithm;

public class 螺旋数组的打印 {
    public static void main(String[] args) {
        printSpiralMatrixOutsideToInside(5);
    }

    public static void printSpiralMatrixOutsideToInside(int n) {
        int[][] arr = new int[n][n];
        int beginX = 0;
        int endX = n - 1;
        int beginY = 0;
        int endY = n - 1;
        int val = 1;

        if (n == 0) return;

        while (true) {
            //第一行
            for (int i = beginX; i <= endX; i++) {
                arr[beginY][i] = val++;
            }

            //最后一列
            if (beginY++ > endY) {
                break;
            }

            for (int i = beginY; i <= endY; i++) {
                arr[i][endX] = val++;
            }

            //最后一行
            if (endX-- < beginX) {
                break;
            }
            for (int i = endX; i >= beginX; i--) {
                arr[endY][i] = val++;
            }

            //第一列
            if (endY-- < beginY) {
                break;
            }
            for (int i = endY; i >= beginY; i--) {
                arr[i][beginX] = val++;
            }
            if (beginX++ > endX) {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] >= 10) {
                    System.out.print(arr[i][j] + "  ");
                }else {
                    System.out.print(arr[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
}
