# 🧠 LeetCode Solutions in Java

<details open>
<summary>📂 ✅ #1. Two Sum — Soluzione con HashMap</summary>

**Difficoltà:** Easy  
**Link al problema:** [LeetCode - Two Sum](https://leetcode.com/problems/two-sum/)

---

### 🔍 Descrizione

Dato un array di interi `nums` e un intero `target`, restituisci **gli indici di due numeri** nell'array tali che la loro somma sia uguale a `target`.

- Ogni input ha **esattamente una soluzione**.
- Non puoi usare due volte lo stesso elemento.
- Puoi restituire la soluzione in qualsiasi ordine.

---

### 🧠 Soluzione ottimizzata (HashMap)

1. Usiamo una `HashMap` per memorizzare i numeri già visti e i loro indici.
2. Per ogni numero nell’array, calcoliamo il **complemento** (cioè `target - nums[i]`).
3. Se il complemento esiste già nella mappa, abbiamo trovato la coppia.
4. Ritorniamo gli indici: quello del complemento (già visto) e quello attuale.
5. In caso contrario, salviamo `nums[i]` con il suo indice.
6. Complessità: **Tempo O(n)**, **Spazio O(n)**.

---

### 🔁 Esecuzione passo passo

Con input:

```java
nums = [2, 7, 11, 15]
target = 9
```

| Codice Java                                       | Esecuzione pratica                                 |
|--------------------------------------------------|----------------------------------------------------|
| `Map<Integer, Integer> map = new HashMap<>();`   | 👉 Creo una mappa vuota: `map = {}`                 |
| `for (int i = 0; i < nums.length; i++) {`        | 🔁 Iterazione `i = 0` → `nums[0] = 2`               |
| `int complement = target - nums[i];`             | ✏️ Calcolo: `complement = 9 - 2 = 7`                |
| `if (map.containsKey(complement)) {`             | ❌ `map.containsKey(7)` → no                        |
| `return new int[] { map.get(complement), i };`   | (salto)                                            |
| `}`                                              |                                                    |
| `map.put(nums[i], i);`                           | ✅ Inserisco `2` con indice `0` → `map = {2=0}`     |
| `}` (fine iterazione 0)                          | ---                                                |
|                                                  | 🔁 Iterazione `i = 1` → `nums[1] = 7`               |
| `int complement = target - nums[i];`             | ✏️ `complement = 9 - 7 = 2`                         |
| `if (map.containsKey(complement)) {`             | ✅ `map.containsKey(2)` → sì                        |
| `return new int[] { map.get(complement), i };`   | 🎯 `map.get(2) = 0`, `i = 1` → ritorna `[0, 1]`     |
| `}`                                              |                                                    |
| `map.put(nums[i], i);`                           | (non eseguito, perché è già stato fatto return)    |
| `}`                                              |                                                    |
|                                                  | ✅ Risultato finale: `[0, 1]`, perché `2 + 7 = 9`   |

---

### 🔎 Spiegazione chiave

Quando siamo a `i = 1`, `nums[i] = 7`, e la mappa è:

```
map = { 2: 0 }
```

Calcoliamo `complement = target - nums[i] = 9 - 7 = 2`.

➡️ `map.get(complement)` restituisce `0`, quindi ritorniamo:

```java
return new int[] { map.get(2), 1 };  // → return new int[] { 0, 1 }
```

📦 Visuale:

```
nums = [2, 7, 11, 15]
         ↑  ↑
        [0][1] → 2 + 7 = 9
```

</details>