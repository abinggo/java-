import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stack150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(!(tokens[i]=="+"||tokens[i]=="-"||tokens[i]=="*"||tokens[i]=="/")){
                num.push(Integer.parseInt(tokens[i]));
                continue;
            }
            else{
                int e=num.pop();
                int f=num.pop();
                int temp=calculate(f,e,tokens[i]);
                num.push(temp);
            }
        }
        int out=num.pop();
        return out;
    }
    public int calculate(int f,int e,String c){
        int result=0;
        switch(c){
            case("+"):
                result=f+e;
                break;
            case("-"):
                result=f-e;
                break;
            case("*"):
                result=f*e;
                break;
            case("/"):
                result=f/e;
                break;
        }
        return result;
    }
}
