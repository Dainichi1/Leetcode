package Medium._049_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Mappa: chiave = stringa ordinata, valore = lista di anagrammi
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            // 1. Convertiamo la stringa in array di char
            char[] chars = s.toCharArray();
            // 2. Ordiniamo l'array di char
            Arrays.sort(chars);
            // 3. Creiamo la chiave come nuova stringa ordinata
            String key = new String(chars);

            // 4. Se la chiave non esiste ancora, creiamo una nuova lista
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            // 5. Aggiungiamo la stringa originale al gruppo corrispondente
            groups.get(key).add(s);
        }

        // 6. Restituiamo tutte le liste di anagrammi
        return new ArrayList<>(groups.values());
    }
}
