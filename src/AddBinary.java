public class AddBinary {


    public static String addBinary(String a, String b){
        final StringBuilder ans = new StringBuilder();
        //进位
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--){
            int sum = ca;
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            ans.append(sum % 2);
            ca = sum / 2;
        }

        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1010";
        System.out.println(addBinary(a, b));
    }

}
