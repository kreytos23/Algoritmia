package ArraysAndStrings;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode node4 = new ListNode(4,new ListNode(5, new ListNode(6)));

        ListNode res = addTwoNumbers(node1, node4);

        while (res != null){
            System.out.print(res.val + " -> ");
            if (res.next == null){
                System.out.print(" null");
            }
            res = res.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder st1 = new StringBuilder();
        StringBuilder st2 = new StringBuilder();
        Long sum = 0L;
        while(l1 != null || l2 != null){
            if (l1 != null) {
                st1.append(l1.val);
                l1 = l1.next;
            }

            if (l2 != null) {
                st2.append(l2.val);
                l2 = l2.next;
            }
        }
        System.out.println(st1);
        System.out.println(st2);

        sum = Long.parseLong(st1.reverse().toString()) + Long.parseLong(st2.reverse().toString());
        System.out.println(sum);
        StringBuilder sumStr = new StringBuilder(String.valueOf(sum)).reverse();
        System.out.println(sumStr);
        ListNode resultado = addNode(sumStr, 0);

        return resultado;
    }

    public static ListNode addNode (StringBuilder num, int index){
        if (index == num.length()){
            return null;
        }
        ListNode root = new ListNode(Integer.parseInt(String.valueOf(num.charAt(index))));
        root.next = addNode(num, index + 1);
        return root;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }

    ListNode() {}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     *
     * public static ListNode addTwoLinkedList (ListNode l1, ListNode l2, int carry){
     *          // Caso base: si ya no hay nodos y no hay acarreo
     *         if (l1 == null && l2 == null && carry == 0) {
     *             return null;
     *         }
     *
     *         int val1 = (l1 != null) ? l1.val : 0;
     *         int val2 = (l2 != null) ? l2.val : 0;
     *
     *         int sum = val1 + val2 + carry;
     *         int newCarry = sum / 10;   // acarreo para la siguiente llamada
     *         int digit = sum % 10;      // dígito actual
     *
     *         // Crear nodo con el dígito calculado
     *         ListNode node = new ListNode(digit);
     *
     *         // Recursión al siguiente nodo
     *         node.next = addTwoLinkedList(
     *             (l1 != null) ? l1.next : null,
     *             (l2 != null) ? l2.next : null,
     *             newCarry
     *         );
     *
     *         return node;
     *     }
     */
}
