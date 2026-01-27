package Easy._012_Number_of_1_bits_PROBLEMA_191;

class Solution {
    /**
     * Conta quanti bit sono impostati a 1 nella rappresentazione binaria di n.
     * Usa il trucco n & (n - 1) che rimuove il bit a 1 più a destra ad ogni iterazione.
     */
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}
