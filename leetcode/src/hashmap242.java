import java.util.HashMap;

public class hashmap242 {
    //Hashmap的很多用法要开始学习
    //本题更好的思路：就是不用遍历两遍，构建一个数组，然后统计s中26个字母出现的次数，然后遍历t删除对应的部分。
    /*
    *class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++)
            if(alpha[i] != 0)
                return false;
        return true;
    }
}
    *
    * */
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> Sites = new HashMap< Character,Integer >();
        //在 Java 中，HashMap 的键（key）和值（value）不能是基本类型，如 char 或 int。它们必须是类类型。
        // 因此，你应该使用包装类 Character 和 Integer
        HashMap<Character,Integer> tites = new HashMap< Character,Integer >();
        int lens=s.length();
        int lent=t.length();
        if(lens!=lent){return false;}
        for(int i=0;i<lens;i++){
            char c;
            c=s.charAt(i);
            if(Sites.containsKey(c)){Sites.replace(c,Sites.get(c)+1);}
            //Sites.containsKey(c)判断hashmap中是否存在c这个键
            //replace，替换key中的值
            else{Sites.put(c,1);}
        }
        for(int i=0;i<lent;i++){
            char c;
            c=t.charAt(i);
            //c.charAt(i)字符串中获取第i个元素字符
            if(tites.containsKey(c)){tites.replace(c,tites.get(c)+1);}
            else{tites.put(c,1);}
        }

        for(Character i:tites.keySet()){

            if(tites.containsKey(i)&&tites.get(i)==Sites.get(i)){continue;}
            else{return false;}
        }
        return true;

    }
    //自己参考的第二个版本可以通过，但是时间复杂度高，可能是因为hashmap没有设置大小
    public boolean isAnagramV2(String s, String t) {
        HashMap<Character,Integer> Sites = new HashMap< Character,Integer >();//在 Java 中，HashMap 的键（key）和值（value）不能是基本类型，如 char 或 int。它们必须是类类型。因此，你应该使用包装类 Character 和 Integer

        long lens=s.length();
        long lent=t.length();
        if(lens!=lent){return false;}
        for(int i=0;i<lens;i++){
            char c;
            c=s.charAt(i);
            if(Sites.containsKey(c)){Sites.replace(c,Sites.get(c)+1);}
            else{Sites.put(c,1);}
        }
        for(int i=0;i<lent;i++){
            char c;
            c=t.charAt(i);
            if(Sites.containsKey(c)){Sites.replace(c,Sites.get(c)-1);}
            else{return false;}
        }

        for(Integer value:Sites.values()){
            if(value!=0){return false;}
        }
        return true;
    }
}
