package Easy._001_Two_Sum;

/**
 * La classe TwoSum fornisce un metodo per risolvere il problema "Two Sum":
 * dato un array di numeri interi e un target, restituisce gli indici di due numeri
 * tali che la loro somma sia uguale al target.
 *
 * <p>Assunzioni:
 * - Ogni input ha esattamente una soluzione.
 * - Non si possono usare due volte lo stesso elemento.
 * - L'ordine degli indici nella risposta può essere qualsiasi.</p>
 *
 * Esempio:
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1] (perché 2 + 7 = 9)
 */
public class TwoSum {

    /**
     * Restituisce gli indici dei due elementi nell'array nums la cui somma è uguale a target.
     *
     * @param nums   array di interi
     * @param target valore target da raggiungere con la somma di due numeri
     * @return array di 2 interi con gli indici degli elementi che sommano il target
     */
    public int[] twoSum(int[] nums, int target) {
        // Scorriamo tutti gli elementi dell'array con indice i
        for (int i = 0; i < nums.length; i++) {
            // Per ogni i, scorriamo gli elementi successivi (j > i)
            for (int j = i + 1; j < nums.length; j++) {
                // Verifichiamo se la somma dei due elementi è uguale al target
                if (nums[i] + nums[j] == target) {
                    // Se sì, restituiamo immediatamente gli indici i e j
                    return new int[]{i, j};
                }
            }
        }
        // In teoria non dovrebbe mai arrivare qui perché è garantita una soluzione
        return new int[]{};
    }
}
