package com.jinbin.leetcode.linked;

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;

        ListNode node = head;
        while(node != null){
            count++;
            node = node.next;
        }

        if(n == count){
            return head.next;
        }else{
            //删除第(count - n + 1)个元素
            int to_del = count - n + 1;
            ListNode current;
            ListNode pre = head;
            while(to_del > 2){
                pre = pre.next;
                to_del--;
            }
            current = pre.next;
            pre.next = current.next;
            return head;
        }
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int count = n;
        ListNode first = head;
        ListNode second = head;

        while(count > 0){
            second = second.next;
            count--;
        }

        if(second == null){
            return first.next;
        }

        while(second.next != null){
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
        return head;
    }
}
