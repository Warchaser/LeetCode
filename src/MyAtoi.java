/**
 * https://leetcode.cn/problems/string-to-integer-atoi/
 * 8. 字符串转换整数 (atoi)
 * */
public class MyAtoi {

    public static int myAtoi(String s){
        if(s.isEmpty() || s.isBlank()){
            return 0;
        }

        String sTmp = s.trim();
        if(sTmp.isEmpty()){
            return 0;
        }

        int index = 0;
        boolean isNegative = false;
        char[] sChar = sTmp.toCharArray();
        if(sChar[index] == '-'){
            isNegative = true;
            index++;
        } else if(sChar[index] == '+'){
            index++;
        } else if(!Character.isDigit(sChar[index])){
            return 0;
        }

        int result = 0;
        while(index < sChar.length && Character.isDigit(sChar[index])){
            int digit = sChar[index] - '0';
            if(result > (Integer.MAX_VALUE - digit) / 10){
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        String s = "   -42";
        System.out.println(myAtoi(s));
    }
}
