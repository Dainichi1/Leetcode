package Easy._005_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Classe che risolve il problema "Valid Parentheses" (LeetCode #20).
 *
 * <p>Dati solo i caratteri '(', ')', '{', '}', '[' e ']', determina se la stringa
 * è valida: le parentesi devono essere chiuse dallo stesso tipo e nell'ordine corretto.</p>
 *
 * <p>Esempi:
 * <ul>
 *   <li>"()" → true</li>
 *   <li>"()[]{}" → true</li>
 *   <li>"(]" → false</li>
 *   <li>"([])" → true</li>
 *   <li>"([)]" → false</li>
 * </ul>
 *
 * <p>Complessità:
 * Tempo O(n), Spazio O(n).</p>
 */
class Solution {
    /**
     * Verifica se la stringa di parentesi è valida.
     * @param s stringa composta solo da '()[]{}'
     * @return true se valida, altrimenti false
     */
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) return false;

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }

        return stack.isEmpty();
    }
}
