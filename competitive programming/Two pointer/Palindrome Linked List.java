/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

     static ListNode getMid(ListNode head)
    {
            ListNode slow =head;
            ListNode fast=head;
            //    return head;
                while(fast!=null && fast.next!=null)
                {

                    slow=slow.next;
                    fast=fast.next.next;
                }
                return slow;
    }


    static ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }



static boolean IsIdentical(ListNode n1,ListNode n2)
{
    while(n1!=null && n2!=null)
    {
        if(n1.val!=n2.val)
        {
            return false;
        }
        n1=n1.next;
        n2=n2.next;
    }

    return true;
}
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode mid=getMid(head);
        
        ListNode head2=reverse(mid);
        
        mid.next=null;

        boolean res=IsIdentical(head,head2);

        head2=reverse(head2);
        mid.next=head2;
        return res;

        
    }
}
