public class string541 {
    //得注意进入的位置，顺序，用start记录下来
    public char[] swap(char[] c,int start,int k){

        for(int i=0;i<k/2;i++){
            char temp;
            temp=c[i+start];
            c[i+start]=c[start+k-1-i];
            c[start+k-1-i]=temp;
        }
        return c;
    }
    public String reverseStr(String s, int k) {
        char[] c=new char[s.length()];
        c=s.toCharArray();//java字符串转为字符数组
        for(int i=0;i<s.length();i=i+2*k){
            //if((s.length()-i)<2*k&&(s.length()-i)>=k){swap(c,i,k);break;}
            if((s.length()-i)<k){c=swap(c,i,s.length()-i);break;}
            c=swap(c,i,k);

        }
        s=new String(c);
        return s;
    }
}
//代码随想录有一个方法，用Stringbuffer来实现
/*
class Solution {
    public String reverseStr(String s, int k) {
        StringBuffer res = new StringBuffer();
        int length = s.length();
        int start = 0;
        while (start < length) {
            // 找到k处和2k处
            StringBuffer temp = new StringBuffer();
            // 与length进行判断，如果大于length了，那就将其置为length
            int firstK = (start + k > length) ? length : start + k;
            int secondK = (start + (2 * k) > length) ? length : start + (2 * k);

            //无论start所处位置，至少会反转一次
            temp.append(s.substring(start, firstK));
            res.append(temp.reverse());

            // 如果firstK到secondK之间有元素，这些元素直接放入res里即可。
            if (firstK < secondK) { //此时剩余长度一定大于k。
                res.append(s.substring(firstK, secondK));
            }
            start += (2 * k);
        }
        return res.toString();//直接返回字符子序列
    }
}
 */