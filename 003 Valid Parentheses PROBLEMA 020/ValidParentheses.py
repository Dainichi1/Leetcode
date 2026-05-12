class Solution:
    def isValid(self, s: str) -> bool:
        # Se la lunghezza è dispari, non può essere valida
        if len(s) % 2 == 1:
            return False

        stack = []

        for c in s:

            # Se troviamo una parentesi aperta,
            # mettiamo nello stack quella di chiusura attesa
            if c == '(':
                stack.append(')')

            elif c == '[':
                stack.append(']')

            elif c == '{':
                stack.append('}')

            # Se troviamo una parentesi chiusa
            else:
                # Stack vuoto oppure parentesi sbagliata
                if not stack or stack.pop() != c:
                    return False

        # Se lo stack è vuoto, tutto è stato chiuso correttamente
        return len(stack) == 0


# s = "([])"
