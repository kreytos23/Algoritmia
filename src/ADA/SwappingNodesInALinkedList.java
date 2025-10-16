package ADA;

import java.util.ArrayList;
import java.util.List;

public class SwappingNodesInALinkedList {
    public static void main(String[] args) {

    }

    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        Integer start = list.get(k - 1);
        System.out.println(start);

        Integer end = list.get(list.size() - k);
        System.out.println(end);

        list.set(k - 1, end);
        list.set(list.size() - k, start);

        list.forEach(System.out::println);

        ListNode aux = new ListNode();
        ListNode newHead= aux;

        for (int i = 0; i < list.size(); i++) {
            aux.val = list.get(i);

            if (i < list.size() - 1){
                aux.next = new ListNode();
                aux = aux.next;
            }
        }

        return newHead;



    }
}
