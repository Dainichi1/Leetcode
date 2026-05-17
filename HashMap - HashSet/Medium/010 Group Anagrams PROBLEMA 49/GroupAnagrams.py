class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        # Dizionario:
        # chiave = stringa ordinata
        # valore = lista di anagrammi
        groups = {}

        for s in strs:
            # 1. Ordina i caratteri della stringa
            key = ''.join(sorted(s))

            # 2. Se la chiave non esiste ancora, crea una lista vuota
            if key not in groups:
                groups[key] = []

            # 3. Aggiungi la stringa originale al gruppo corretto
            groups[key].append(s)

        # 4. Restituisce tutte le liste di anagrammi
        return list(groups.values())