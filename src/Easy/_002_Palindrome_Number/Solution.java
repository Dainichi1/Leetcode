package Easy._002_Palindrome_Number;

/**
 * Soluzione per il problema LeetCode 9: Palindrome Number.
 * <p>
 * Verifica se un numero intero è un palindromo, cioè se si legge allo stesso modo
 * da sinistra a destra e da destra a sinistra.
 * <p>
 * Esempi:
 * - 121 → true
 * - -121 → false (i numeri negativi non possono essere palindromi)
 * - 10 → false (il numero termina con 0 ma non è 0)
 */
class Solution {

    /**
     * Verifica se il numero intero dato è un palindromo.
     *
     * @param x il numero intero da verificare
     * @return true se x è un palindromo, false altrimenti
     */
    public boolean isPalindrome(int x) {
        // Caso 1: numeri negativi non sono palindromi
        // Caso 2: se il numero finisce per 0 ma non è 0 (es. 10), non può essere palindromo
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // Inizializzazione della metà inversa del numero
        int invertedSecondHalf = 0;

        /**
         * Eseguiamo il reverse della metà destra del numero.
         * Quando invertedSecondHalf >= x, significa che abbiamo elaborato metà del numero
         * e possiamo confrontare le due metà.
         */
        while (x > invertedSecondHalf) {
            int lastDigit = x % 10;  // Estrae l'ultima cifra
            invertedSecondHalf = invertedSecondHalf * 10 + lastDigit;  // Aggiunge la cifra alla metà invertita
            x = x / 10;  // Rimuove l'ultima cifra da x
        }

        /**
         * Per numeri con numero pari di cifre: x == invertedSecondHalf
         * Per numeri con numero dispari di cifre: invertedSecondHalf avrà una cifra in più, quindi si rimuove quella cifra con /10
         */
        return (x == invertedSecondHalf || x == invertedSecondHalf / 10);
    }
}
