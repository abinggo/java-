public class listnode142 {
    /*这道题很难
    * 一定要了解清楚是否有环？如何确定起始位置
    * 可以使用快慢指针法，分别定义 fast 和 slow 指针，从头结点出发，fast指针每次移动两个节点，slow指针每次移动一个节点，
    * 如果 fast 和 slow指针在途中相遇 ，说明这个链表有环。
    * 然后判断环的入口，相遇时记录下相遇的位置
    * 从起点出发一个指针，从相遇的节点出发一个指针，每次移动一个，当两者相遇时，就说明时环入口，具体公式推导可以查看代码随想录
    *
    * */
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode meet=null;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                ListNode index1=head;
                ListNode index2=fast;
                while(index1!=index2){
                    index1=index1.next;
                    index2=index2.next;
                }
                meet=index1;
                return meet;
            }
        }
        return meet;
    }

}
