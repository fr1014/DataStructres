package DataSturctures.recursion;

//迷宫问题（使用递归解决）
public class maze {

    public static void main(String[] args) {
        /*
         * 迷宫地图
         * 1 1 1 1 1 1 1
         * 1 0 0 0 0 0 1
         * 1 0 0 0 0 0 1
         * 1 1 1 0 0 0 1
         * 1 0 0 0 0 0 1
         * 1 0 0 0 0 0 1
         * 1 0 0 0 0 0 1
         * 1 1 1 1 1 1 1
         */
        //使用二维数组模拟迷宫地图
        int[][] map = new int[8][7];
        //用1表示迷宫的墙
        //上下的墙置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右的墙置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;

        for (int i = 0;i<8;i++){
            for (int j = 0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        setWay(map,1,1);
        System.out.println("使用递归解决迷宫回溯：");
        for (int i = 0;i<8;i++){
            for (int j = 0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    //使用递归回溯给小球找路
    //1.map表示地图
    //2.i,j表示小球的起始位置
    //3.如果小球能到达map[6][5]位置，则说明找到通路
    //4.规定：当map[i][j]为0表示该点没走过，1表示墙，2表示通路可以走，3表示该路走过且走不通
    //走迷宫时的策略：规定 下->右->上->左 走不通再回溯
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                map [i][j] = 2;
                if (setWay(map,i+1,j)){  //向下走
                    return true;
                }else if (setWay(map,i,j+1)){ //向右走
                    return true;
                }else if (setWay(map,i-1,j)){  //向上走
                    return true;
                }else if (setWay(map,i,j-1)){  //向左走
                    return true;
                }else {
                    //该路走不通
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;  //该点为1，2，3
            }
        }
    }
}
