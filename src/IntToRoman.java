/**
 * https://leetcode.cn/problems/integer-to-roman/
 * 12. 整数转罗马数字
 * */
public class IntToRoman {

    public static String intToRoman(int num){
        final int[] intGroup = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] strGroup = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 13; i++){
            int ans = num / intGroup[i];
            for(int j = 0; j < ans; j++){
                builder.append(strGroup[i]);
            }
            num %= intGroup[i];
        }

        return builder.toString();
    }

    public static String intToRoman2(int num){
        int[] intGroup = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strGroup = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final StringBuilder builder = new StringBuilder();
        for(int i = 0; i < intGroup.length; i++){
            int value = intGroup[i];
            while (num >= value){
                num -= value;
                builder.append(strGroup[i]);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Util.currentMillis();
        System.out.println(intToRoman2(1994));
        Util.currentMillis();
    }
}
