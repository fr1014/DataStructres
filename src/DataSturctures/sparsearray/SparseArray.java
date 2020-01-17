package DataSturctures.sparsearray;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        //1.创建二维数组11*11
        //2. 0表示没有棋子 1表示黑子 2表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //遍历二维数组中每一个一维数组
        System.out.println("原始二维数组");
        for (int[] cells : chessArr1) {
            //遍历一维数组中每一个元素
            for (int data : cells) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //二维数组转稀疏数组
        //1.遍历原始的二维数组，得出非0的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2.创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        //遍历数组将二维数组中非0的值存入稀疏数组
        int count = 0;          //用于记录是第几个非0的数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println("稀疏数组");
        for (int[] cells : sparseArray) {
            for (int data : cells) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
