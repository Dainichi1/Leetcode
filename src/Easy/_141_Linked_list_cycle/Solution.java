package Easy._141_Linked_list_cycle;

public class Solution {
    public boolean hasCycle(ListNode head) {

        // 1) Caso base: lista vuota -> nessun ciclo
        if (head == null) return false;

        // 2) Due puntatori che partono dalla testa
        ListNode slow = head;
        ListNode fast = head;

        // 3) Finché fast può fare "due passi" senza cadere fuori (null)
        while (fast != null && fast.next != null) {

            // 4) slow fa 1 passo
            slow = slow.next;

            // 5) fast fa 2 passi
            fast = fast.next.next;

            // 6) Se si incontrano, c'è un ciclo
            if (slow == fast) return true;
        }

        // 7) Se fast arriva a null, la lista finisce -> niente ciclo
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
