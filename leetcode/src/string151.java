import java.util.ArrayList;
//自己的第第一版做法，消耗时间和内存都很大，用了正则（这个可能是时间长的原因），同时使用arraylist来解决正则过后的空格问题
//但是如果使用了split这道题就浪费了意义哦！
public class string151 {
    public String reverseWords(String s) {
        //用法：字符串的正则,并且可以用字符串数组，接收对象
        //添加在末尾不会改变大小，前面有多少加多少//中间是n-1个“”
        //111hello1111world11
        //输出“”“”“”hello“”“”“”world
        ArrayList<String> sites = new ArrayList<String>();
        String[] buff=s.split(" ");
        int start=0;
        while(start<buff.length){
            if(buff[start]==""){start++;continue;}
            sites.add(buff[start]);start++;}
        for(int i=0;i<sites.size()/2;i++){
            String temp;
            temp= sites.get(i);
            sites.set(i,sites.get(sites.size()-1-i));
            sites.set(sites.size()-1-i,temp);
        }
        String out=sites.get(0);
        for(int i=1;i<sites.size();i++){
            out=out+" "+sites.get(i);
        }
        return out;
    }
}
