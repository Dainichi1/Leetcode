class Solution:
    def isPalindrome(self, x: int) -> bool:

        # Caso 1: numeri negativi → non possono essere palindromi
        # Caso 2: numeri che finiscono con 0 ma non sono 0 (es: 10, 120)
        if x < 0 or (x % 10 == 0 and x != 0):
            return False

        # Variabile che conterrà la seconda metà del numero invertita
        inverted_second_half = 0

        # Invertiamo solo metà del numero
        while x > inverted_second_half:

            # Prende l'ultima cifra
            last_digit = x % 10

            # Costruisce la metà invertita
            inverted_second_half = inverted_second_half * 10 + last_digit

            # Rimuove l'ultima cifra da x
            x = x // 10

        # Caso cifre pari:     1221 → 12 == 12
        # Caso cifre dispari:  121  → 1 == 12 // 10
        return x == inverted_second_half or x == inverted_second_half // 10