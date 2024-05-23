import java.util.Stack;
/*出栈的时候，我们使用的是直接传出最最后一个，再入栈，但是
参考代码随想录实际上可以不需要，再次传回去，直接判断后面那个栈是否为空，不为空则输出
为空则把第一个栈传进来，还有就是代码复用性的问题记得
class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /** Initialize your data structure here. */
//public MyQueue() {
//    stackIn = new Stack<>(); // 负责进栈
//    stackOut = new Stack<>(); // 负责出栈
//}
//
///** Push element x to the back of queue. */
//public void push(int x) {
//    stackIn.push(x);
//}
//
///** Removes the element from in front of queue and returns that element. */
//public int pop() {
//    dumpstackIn();
//    return stackOut.pop();
//}
//
///** Get the front element. */
//public int peek() {
//    dumpstackIn();
//    return stackOut.peek();
//}
//
///** Returns whether the queue is empty. */
//public boolean empty() {
//    return stackIn.isEmpty() && stackOut.isEmpty();
//}
//
//// 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
//private void dumpstackIn(){
//    if (!stackOut.isEmpty()) return;
//    while (!stackIn.isEmpty()){
//        stackOut.push(stackIn.pop());
//    }
//}
//}
//* */
public class stack232 {
    class MyQueue {
        Stack<Integer> stackfr;
        Stack<Integer> stackbe;
        public MyQueue() {
            stackfr = new Stack<>();
            stackbe = new Stack<>();
        }

        public void push(int x) {
            stackfr.push(x);
        }

        public int pop() {
            while(!stackfr.isEmpty()){
                int temp;
                temp=stackfr.pop();
                stackbe.push(temp);
            }
            int out;
            out=stackbe.pop();
            while(!stackbe.isEmpty()){
                int temp;
                temp=stackbe.pop();
                stackfr.push(temp);
            }
            return out;
        }

        public int peek() {
            while(!stackfr.isEmpty()){
                int temp;
                temp=stackfr.pop();
                stackbe.push(temp);
            }
            int out;
            out=stackbe.peek();
            while(!stackbe.isEmpty()){
                int temp;
                temp=stackbe.pop();
                stackfr.push(temp);
            }
            return out;
        }

        public boolean empty() {
            if(stackbe.isEmpty()&&stackfr.isEmpty()){return true;}
            return false;
        }
    }

        }
