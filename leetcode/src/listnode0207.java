public class listnode0207 {
    //参考了代码随想录的一个思想，切记要保证末尾对齐！！！这个比公共字串简单一点！别想复杂！
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //有点像找公共子串 ！！！重点思想 末尾对齐！！！
        ListNode cura=headA;
        ListNode curb=headB;
        int sizea=0;
        int sizeb=0;
        while(cura!=null){
            sizea++;
            cura=cura.next;
        }
        cura=headA;
        while(curb!=null){
            sizeb++;
            curb=curb.next;
        }
        curb=headB;
        int size=0;
        if(sizea>sizeb){
            size=sizea-sizeb;
            for(int i=0;i<size;i++){
                cura=cura.next;
            }
        }
        else{size=sizeb-sizea;
            for(int i=0;i<size;i++){
                curb=curb.next;
            }
        }
        ListNode ans=null;
        while(curb!=cura&&cura!=null){
            curb=curb.next;
            cura=cura.next;
        }
        if(cura!=null){ans=cura;}
        return ans;

    }
}
