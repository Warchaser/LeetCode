public class LengthOfLastWord {

    /**
     * 相当于先找到不是空格的字符串结尾
     * 再找到不是空格开头的字符串开头
     * 结尾一减开头就行了
     * */
    public static int lengthOfLastWord(String s){
        int end = s.length() - 1;
        while(end >=0 && s.charAt(end) == ' '){
            end--;
        }

        int start = end;
        while(start >= 0 && s.charAt(start) != ' '){
            start--;
        }

        return end - start;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World!"));
    }
}
