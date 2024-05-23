public class listnode24 {

        public ListNode swapPairs(ListNode head) {
                ListNode current=head;
                ListNode pre = null;
                int flag=0;
                while(current!=null&&current.next!=null){
                 ListNode temp;
                 temp=current.next.next;
                 current.next.next=current;
                if(flag==0){pre=current.next;head=pre;}
                else{pre.next=current.next;}
                flag=1;
                current.next=temp;
                pre=current;
                current=current.next;
                }
                return head;
        }

}
