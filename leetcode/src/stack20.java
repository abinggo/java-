import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//通过了，但是用时很长！
public class stack20 {
    public boolean isValid(String s) {
        if(s.length()%2!=0){return false;}
        Stack<Character> stack=new Stack<>();
        Stack<Character> stack2=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            stack.push(s.charAt(i));

        }
        while(!stack.isEmpty()){
            if(stack2.isEmpty()){stack2.push(stack.pop());continue;}
            char right=stack2.peek();
            char left=stack.pop();
            if(((left=='('&& right==')')||(left=='{'&&right=='}')||(left=='['&&right==']'))){
                stack2.pop();}
            else{stack2.push(left);}
        }
        if(stack2.isEmpty()){return true;}
        return false;
    }
}
