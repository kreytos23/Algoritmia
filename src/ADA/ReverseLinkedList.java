package ADA;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = null;
        ListNode current = head;

        while (current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}



     class ListNode2 {
        int val;
        ListNode next;
        ListNode2() {}
        ListNode2(int val) { this.val = val; }
        ListNode2(int val, ListNode next) { this.val = val; this.next = next; }
    }
