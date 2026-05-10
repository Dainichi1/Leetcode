class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        # Prezzo minimo trovato finora
        min_price = float('inf')

        # Profitto massimo trovato finora
        max_profit = 0

        # Scorriamo tutti i prezzi
        for price in prices:

            # Se troviamo un prezzo più basso, aggiorniamo il minimo
            if price < min_price:
                min_price = price

            # Altrimenti calcoliamo il profitto potenziale
            else:
                profit = price - min_price

                # Se il profitto è migliore, aggiorniamo
                if profit > max_profit:
                    max_profit = profit

        return max_profit