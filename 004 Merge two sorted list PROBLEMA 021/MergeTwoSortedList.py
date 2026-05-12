class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeTwoLists(self, list1: ListNode, list2: ListNode) -> ListNode:

        # Nodo sentinella (dummy)
        dummy = ListNode(0)

        # tail punta sempre all'ultimo nodo della lista finale
        tail = dummy

        # Finché entrambe le liste hanno nodi
        while list1 is not None and list2 is not None:

            # Prendi il nodo col valore più piccolo
            if list1.val <= list2.val:
                tail.next = list1
                list1 = list1.next
            else:
                tail.next = list2
                list2 = list2.next

            # Sposta tail in avanti
            tail = tail.next

        # Collega i nodi rimasti
        if list1 is None:
            tail.next = list2
        else:
            tail.next = list1

        # Restituisce la vera testa (saltando dummy)
        return dummy.next
