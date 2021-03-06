import java.util.*;

public class IsValid {


    public static boolean isValid(String s){
        if(s.length() % 2 != 0){
            return false;
        }

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
        //用Deque实现栈，代替Stack；Stack已经过时
        final Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            if(pairs.containsKey(character)){
                if(stack.isEmpty() || stack.peek() != pairs.get(character)){
                    return false;
                }
                stack.pop();
            } else {
                stack.push(character);
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValid2(String s){
        final Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.offerLast(')');
            } else if(c == '{'){
                stack.offerLast('}');
            } else if(c == '['){
                stack.offerLast(']');
            } else if(stack.isEmpty() || stack.pollLast() != c){
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args){
        final String s = "({})";
        System.out.println(isValid(s));
    }

}
