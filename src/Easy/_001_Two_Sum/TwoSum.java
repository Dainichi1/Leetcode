package Easy._001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Restituisce gli indici di due numeri presenti nell'array {@code nums} la cui somma è uguale al {@code target}.
 * <p>
 * L'algoritmo utilizza una HashMap per memorizzare i numeri già visitati insieme ai rispettivi indici,
 * in modo da trovare la coppia cercata in tempo lineare O(n).
 * </p>
 *
 * <p>Esempio:</p>
 * <pre>{@code
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]  // perché nums[0] + nums[1] = 2 + 7 = 9
 * }</pre>
 *
 * <p>Funzionamento step-by-step:</p>
 * <ul>
 *   <li>Per ogni elemento nell'array, calcola il "complemento" = target - nums[i]</li>
 *   <li>Controlla se il complemento è già presente nella mappa</li>
 *   <li>Se sì, ritorna l'indice del complemento (preso dalla mappa) e l'indice corrente i</li>
 *   <li>Altrimenti, memorizza nums[i] e il suo indice nella mappa</li>
 * </ul>
 *
 * @param nums   L'array di interi in cui cercare la coppia
 * @param target Il valore target da raggiungere con la somma di due numeri nell'array
 * @return Un array di due interi contenente gli indici dei numeri che sommano il target
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // valore → indice

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calcolo il "complemento"

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Soluzione trovata
            }

            map.put(nums[i], i); // Altrimenti memorizzo il numero attuale e il suo indice
        }

        return new int[]{}; // non verrà mai eseguito (problema garantisce una soluzione)

    }
}
