package ADA;

public class MiddleLinkedList {

    public static void main(String[] args) {

    }

    public static ListNode middleNode(ListNode head) {
        /*ListNode aux = head;
        int size = 0;
        while (head != null){
            head = head.next;
            size++;
        }
        size = size >> 1;
        for (int i = 0; i < size ; i++){
            aux = aux.next;
        }
        return aux;
         */
        ListNode aux = head;
        int size = 0;
        ListNode rabbit = head;
        ListNode turtle = head;

        while (turtle != null && turtle.next == null){
            head = head.next;
            size++;
        }

        size = size >> 1;
        for (int i = 0; i < size ; i++){
            aux = aux.next;
        }
        return aux;

    }
}


    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

