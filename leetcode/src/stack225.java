import java.util.LinkedList;
import java.util.Queue;
//采用引用的方式进行记录，重点在于队列有获取容量的能力，所以就把前面的存在另外一个队列中
//就可以实现栈的功能
public class stack225 {
    class MyStack {
        Queue<Integer> queuefr;
        Queue<Integer> queuebe;

        public MyStack() {
            queuefr = new LinkedList<>();
            queuebe = new LinkedList<>();
        }

        public void push(int x) {
            if(!queuebe.isEmpty()&&queuefr.isEmpty())
            {queuebe.add(x);}
            else
            {queuefr.add(x);}

        }

        public int pop() {
            if(queuebe.isEmpty()){
                int size=queuefr.size();
                for(int i=0;i<size-1;i++){
                    int temp;
                    temp=queuefr.remove();
                    queuebe.add(temp);
                }
                int out=queuefr.remove();
                return out;
            }
            int size=queuebe.size();
            for(int i=0;i<size-1;i++){
                int temp;
                temp=queuebe.remove();
                queuefr.add(temp);
            }
            int out=queuebe.remove();
            return out;


        }
        public int top() {
            if(queuebe.isEmpty()){
                int size=queuefr.size();
                for(int i=0;i<size-1;i++){
                    int temp;
                    temp=queuefr.remove();
                    queuebe.add(temp);
                }
                int out=queuefr.remove();
                queuebe.add(out);
                return out;
            }
            int size=queuebe.size();
            for(int i=0;i<size-1;i++){
                int temp;
                temp=queuebe.remove();
                queuefr.add(temp);
            }
            int out=queuebe.peek();
            queuebe.add(out);
            return out;
        }

        public boolean empty() {
            if(queuebe.isEmpty()&&queuefr.isEmpty()){return true;}
            return false;
        }

}}
/*
写了一个transport 改善
    public int pop() {

        int flag= transport();
        if(flag==1)
        {int out=queuefr.remove();
        return out;}

        int out=queuebe.remove();
        return out;
     }

    public int top() {

        int flag=transport();

        if (flag==1){
        int out=queuefr.remove();
        queuebe.add(out);
        return out;}

        int out=queuebe.peek();
        queuebe.add(out);
        return out;
    }
public int transport(){
        if(queuebe.isEmpty()){
        int size=queuefr.size();
        for(int i=0;i<size-1;i++){
            int temp;
            temp=queuefr.remove();
            queuebe.add(temp);
        }
        return 1;
    }
    int size=queuebe.size();
      for(int i=0;i<size-1;i++){
            int temp;
            temp=queuebe.remove();
            queuefr.add(temp);
        }
    return 0;
}
* */
