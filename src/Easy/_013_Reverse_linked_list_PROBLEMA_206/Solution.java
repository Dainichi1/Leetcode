package Easy._013_Reverse_linked_list_PROBLEMA_206;


  class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
          this.next = null;
      }
  }

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;      // 1) "dietro" al nodo corrente (inizialmente non c'è nulla)
        ListNode curr = head;      // 2) nodo che sto guardando adesso
        ListNode next = null;

        while (curr != null) {     // 3) finché non arrivo alla fine della lista
            next = curr.next; // 4) salvo dove andrei dopo (per non perderlo)
            curr.next = prev;          // 5) giro la freccia: curr ora punta indietro
            prev = curr;               // 6) sposto prev avanti (diventa curr)
            curr = next;               // 7) sposto curr avanti (diventa il vecchio next)
        }

        return prev;               // 8) prev è la nuova testa della lista invertita
    }
}

/*
vedi questo:
https://www.youtube.com/watch?v=jY-EUKXYT20&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=58
per la spiegazione
 */
