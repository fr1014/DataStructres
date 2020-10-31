package algorithm;

public class 整数反转 {

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        reverse(-2147483648);
    }

    public static int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int pos = x % 10;
            x /= 10;
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pos > 7)) return 0;
            if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pos < -8)) return 0;
            rev = rev * 10 + pos;
        }
        return rev;
    }
}
