package Easy._021_Merge_two_sorte_list;


class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Nodo finto (sentinella) per semplificare la costruzione della lista finale
        ListNode dummy = new ListNode(0);

        // "tail" punta sempre all'ultimo nodo della lista che stiamo costruendo
        ListNode tail = dummy;

        // Finché entrambe le liste hanno nodi da confrontare
        while (list1 != null && list2 != null) {

            // Scegliamo il nodo più piccolo e lo agganciamo alla lista finale
            if (list1.val <= list2.val) {
                tail.next = list1;      // collega il nodo di list1
                list1 = list1.next;     // avanza in list1
            } else {
                tail.next = list2;      // collega il nodo di list2
                list2 = list2.next;     // avanza in list2
            }

            tail = tail.next; // aggiorna la coda all'ultimo nodo inserito
        }

        // Una delle due liste è finita: attacca tutto il resto dell'altra
        if (list1 == null) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }
        // La vera testa è dummy.next (dummy è solo un appoggio)
        return dummy.next;
    }
}

/*
vedi questo:
https://www.youtube.com/watch?v=IMWiPqoneT4&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=71
per la spiegazione
 */
