package Easy._004_Longest_Common_Prefix;

/**
 * Classe che implementa la soluzione al problema "Longest Common Prefix" (LeetCode #14).
 *
 * <p>Data una lista di stringhe, il metodo {@link #longestCommonPrefix(String[])} restituisce
 * il prefisso comune più lungo tra tutte le stringhe.
 * Se non esiste alcun prefisso comune, ritorna una stringa vuota "".</p>
 *
 * <p>Esempi:
 * <ul>
 *   <li>["flower", "flow", "flight"] → "fl"</li>
 *   <li>["dog", "racecar", "car"] → ""</li>
 * </ul>
 *
 * <p>Complessità:
 * Tempo: O(N * M) dove N è il numero di stringhe e M la lunghezza media delle stringhe.
 * Spazio: O(1), viene usata solo una variabile di appoggio.</p>
 */
class Solution {

    /**
     * Trova il prefisso comune più lungo tra tutte le stringhe fornite.
     *
     * @param strs array di stringhe in cui cercare il prefisso comune
     * @return il prefisso comune più lungo; stringa vuota se non esiste
     */
    public String longestCommonPrefix(String[] strs) {
        // Caso base: se l'array è nullo o vuoto, non c'è prefisso comune
        if (strs == null || strs.length == 0) return "";

        // 1. Usare la prima stringa come prefisso iniziale
        String prefix = strs[0];

        // 2. Confrontare progressivamente con tutte le altre stringhe
        for (int i = 1; i < strs.length; i++) {
            // Finché la stringa corrente non inizia con il prefisso
            while (!strs[i].startsWith(prefix)) {
                // Rimuovere l'ultimo carattere dal prefisso
                prefix = prefix.substring(0, prefix.length() - 1);

                // Se il prefisso diventa vuoto, non c'è prefisso comune
                if (prefix.isEmpty()) return "";
            }
        }

        // 3. Restituire il prefisso comune trovato
        return prefix;
    }
}
