public class MySqrt {

    public static int mySqrt(int x){
        long n = x;
        while (n * n > x){
            n = (n + x / n) / 2;
        }

        return (int)n;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

}
