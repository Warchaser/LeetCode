public class CountAndSay {

    public static String countAndSay(int n){
        StringBuilder result = new StringBuilder();
        result.append(1);
        for(int i = 1; i < n; i++){
            final StringBuilder s = new StringBuilder();
            int start = 0;
            for(int j = 1; j < result.length(); j++){
                if(result.charAt(j) != result.charAt(start)){
                    s.append(j - start).append(result.charAt(start));
                    start = j;
                }
            }
            s.append(result.length() - start).append(result.charAt(start));
            result = s;
        }
        return result.toString();
    }


    public static void main(String[] args){
        System.out.println(countAndSay(4));
    }
}
