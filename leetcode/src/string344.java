public class string344 {
    //这题比较简单直接交换就行
    public void reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
            char temp;
            temp=s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }

    }
}
