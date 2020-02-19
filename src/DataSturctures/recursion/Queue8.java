package DataSturctures.recursion;

/**
 * 8皇后问题(回溯算法)
 * 要求所有的皇后不能在同一行、列、斜线上
 */
public class Queue8 {

    //表示可放置的皇后数量
    private int max = 8;
    //表示一共有多少种解法
    private static int count = 0;
    /*
     *表示一种解法，eg:array = {0,4,7,5,2,6,1,3};array[0] = 0 表示第一个皇后放置在第一列
     *下标：第几个皇后
     * value: 
     */
    private int[] array = new int[max];

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共%d种解法", count);
    }

    /**
     * @param n 放置第n个皇后
     */
    public void check(int n) {
        if (n == max) {   //n == max 时皇后已经全部放好
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //把当前皇后放在第一列
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    /**
     * 判断放置的皇后是否有冲突
     *
     * @param n 第几个皇后
     * @return true 冲突 ，false 不冲突
     */
    public Boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //array[i] == array[n]表示两个皇后在同一列
            //Math.abs(n - i) == Math.abs(array[n] - array[i]) 表示两个皇后在同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        count++;
        for (int i = 0; i < max; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

