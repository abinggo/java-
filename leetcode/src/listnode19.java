public class listnode19 {
    /*
    代码随想录的方法：双指针
    快慢指针，中间相隔n+1，为什嚒n+1呢？当n+1的时候，slow指针会指向删除的前一个！
    *public ListNode removeNthFromEnd(ListNode head, int n){
    ListNode dummyNode = new ListNode(0);
    dummyNode.next = head;

    ListNode fastIndex = dummyNode;
    ListNode slowIndex = dummyNode;

    // 只要快慢指针相差 n 个结点即可
    for (int i = 0; i < n  ; i++){
        fastIndex = fastIndex.next;
    }

    while (fastIndex != null){
        fastIndex = fastIndex.next;
        slowIndex = slowIndex.next;
    }

    //此时 slowIndex 的位置就是待删除元素的前一个位置。
    //具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
    slowIndex.next = slowIndex.next.next;
    return dummyNode.next;
}
    *
    *
    *
    *
    * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current=head;
        int size=0;
        while(current!=null)
        {
            size++;
            current=current.next;
        }
        ListNode cur=head;
        for(int i=0;i<size-n-1;i++)
        {
            cur=cur.next;
        }
        if(size-n==0){head=head.next;return head;} //注意一下，这个情况，就是删除第一个节点
        cur.next=cur.next.next;
        return head;
    }
}
