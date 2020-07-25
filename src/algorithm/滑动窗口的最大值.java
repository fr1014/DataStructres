package algorithm;

import java.util.ArrayList;
import java.util.List;

public class 滑动窗口的最大值 {

    public static void main(String[] args) {
//        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int[] num = {10, 14, 12, 11};
        ArrayList<Integer> integers = new 滑动窗口的最大值().maxInWindows(num, 5);
        System.out.println(integers);
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (size == 0 || num.length < size) {
            return result;
        }
        int r = 0;
        List<Integer> list = new ArrayList<>();
        while (r < num.length) {

            while (r < num.length && list.size() < size) {
                list.add(num[r]);
                r++;
            }

            int temp = 0;
            for (int res = 0; res < list.size(); res++) {
                if (list.get(res) > temp) {
                    temp = list.get(res);
                }
            }

            result.add(temp);

            list.remove(0);
        }

        return result;
    }
}
