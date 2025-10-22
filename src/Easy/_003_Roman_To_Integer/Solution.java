package Easy._003_Roman_To_Integer;

import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * Converte un numero romano rappresentato come stringa in un intero.
     * <p>
     * L'algoritmo utilizza una mappa per associare i simboli romani ai rispettivi valori numerici.
     * Scorre la stringa da sinistra a destra e, per ogni carattere:
     * - Se il simbolo corrente è minore di quello successivo (caso di sottrazione: es. IV, IX, XC, ecc.),
     *   allora sottrae il valore corrente dal totale.
     * - Altrimenti, aggiunge il valore al totale.
     * </p>
     *
     * @param s la stringa contenente il numero romano (es: "MCMXCIV")
     * @return il valore intero corrispondente al numero romano
     */
    public int romanToInt(String s) {
        // Mappa simboli romani → valori numerici
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0; // Variabile per il risultato finale

        // Scorri ogni carattere della stringa
        for (int i = 0; i < s.length(); i++) {
            int current = romanMap.get(s.charAt(i)); // Valore del simbolo corrente

            // Se esiste un simbolo successivo e il valore corrente è minore di quello successivo,
            // si tratta di un caso di sottrazione (es: IV = 4, IX = 9, ecc.)
            if (i < s.length() - 1 && current < romanMap.get(s.charAt(i + 1))) {
                result -= current; // Sottrai il valore corrente dal risultato
            } else {
                result += current; // Altrimenti, aggiungi il valore corrente al risultato
            }
        }
        return result; // Ritorna il valore intero calcolato
    }
}
