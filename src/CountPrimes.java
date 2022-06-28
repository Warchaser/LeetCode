import java.util.Arrays;

/**
 * https://leetcode.cn/problems/count-primes/
 * 定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * */
public class CountPrimes {

    public static int countPrimes(int n){
        if(n < 3){
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for(int i = 2; i < n; i++){
            if(isPrime[i]){
                for(int j = i * 2; j < n; j += i){
                    isPrime[j] = false;
                }
            }
        }

        int result = 0;

        for(boolean item : isPrime){
            if(item){
                result++;
            }
        }

        //排除0、1
        result -= 2;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(499979));
    }

}
