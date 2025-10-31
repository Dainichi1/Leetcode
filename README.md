# 🧠 LeetCode Solutions in Java
<details open>
<summary> 🟢 EASY</summary>
<details>
<summary>📂 ✅ #1. Two Sum </summary>

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
<details>
<summary> 📂 ✅ #217. Contains Duplicate </summary>

**Difficoltà:** Easy  
**Link al problema:** [LeetCode - Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)

---

### 🔍 Descrizione

Dato un array di interi `nums`, restituisci **`true` se esiste almeno un valore che compare due o più volte** nell’array, altrimenti **`false`**.

---

### 🧠 Soluzione ottimizzata (HashSet)

1. Crea un `HashSet<Integer>` vuoto per tracciare i numeri già visti.
2. Scorri `nums`:
    - se `num` è **già nel set**, hai trovato un duplicato → **ritorna `true`**;
    - altrimenti **aggiungi** `num` al set e continua.
3. Se il ciclo termina senza trovare duplicati → **ritorna `false`**.

**Complessità:** **Tempo O(n)** (un solo passaggio) — **Spazio O(n)** (nel caso peggiore, tutti distinti).

---

### 🔁 Esecuzione passo passo

Con input:

```java
nums = [1, 2, 3, 1]
```

| Codice/Passo                              | Esecuzione pratica                               |
|------------------------------------------|--------------------------------------------------|
| `Set<Integer> seen = new HashSet<>();`   | 👉 `seen = { }`                                   |
| Leggo `1`                                | `seen.contains(1)` → ❌ no → `seen = {1}`         |
| Leggo `2`                                | `seen.contains(2)` → ❌ no → `seen = {1, 2}`       |
| Leggo `3`                                | `seen.contains(3)` → ❌ no → `seen = {1, 2, 3}`     |
| Leggo `1`                                | `seen.contains(1)` → ✅ sì → **ritorna `true`**     |

✅ Risultato finale: `true` perché `1` compare almeno due volte.

---

### 🔎 Spiegazione chiave

- Un `HashSet` contiene **solo elementi unici**: se provi ad inserire un valore **già presente**, lo **rilevi immediatamente** (con `contains`) e puoi **uscire subito**.
- Questo approccio evita confronti ripetuti tra tutti gli elementi (niente doppi cicli), massimizzando l’efficienza su input grandi.

---

### 🧪 Edge cases utili

- Array vuoto o con 1 elemento → **`false`** (nessun duplicato possibile).
- Valori negativi o molto grandi → **irrilevanti** per la logica; il set gestisce qualsiasi `int`.
- Duplicato ad inizio array → **uscita anticipata** (ottimo nella pratica).

---

### 💻 Snippet Java (coincide con la tua soluzione)

```java
public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> seenNumbers = new HashSet<>();
    for (int num : nums) {
        if (seenNumbers.contains(num)) return true;
        seenNumbers.add(num);
    }
    return false;
}
```
</details>
<details>
<summary>📂 ✅ #219. Contains Duplicate II</summary>

**Difficoltà:** Easy  
**Link al problema:** [LeetCode - Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/)

---

### 🔍 Descrizione

Dato un array di interi `nums` e un intero `k`, restituisci **`true` se esistono due indici `i` e `j`** tali che:

- `nums[i] == nums[j]` (stesso valore) e
- `|i - j| <= k` (distanza tra indici non superiore a `k`).

---

### 🧠 Intuizione (Sliding Window + HashSet)

Mantieni una **finestra scorrevole** degli ultimi `k` elementi usando un `HashSet`:

- Se il valore corrente è **già nel set**, significa che lo **stesso valore è apparso entro `k` posizioni** → `true`.
- Altrimenti lo **aggiungi** al set.
- Se la finestra supera la dimensione `k`, **rimuovi** l’elemento uscito (`nums[i - k]`).

**Complessità:** **Tempo O(n)** — **Spazio O(min(n, k))**.

---

---

### 🔁 Esecuzione passo passo — **Caso TRUE**

**Input:** `nums = [1, 0, 1, 1]`, `k = 1` → **`true`** (gli ultimi due `1` sono a distanza 1 ≤ k)

| Codice Java                           | Esecuzione pratica / Stato finestra (`set`)              |
| ------------------------------------- | -------------------------------------------------------- |
| `Set<Integer> set = new HashSet<>();` | `set = { }`                                              |
| `i = 0` → `nums[0] = 1`               | `contains(1)` ➜ no → `add(1)` → `set={1}`                |
| `i = 1` → `nums[1] = 0`               | `contains(0)` ➜ no → `add(0)` → `set={1,0}`              |
| `if (set.size() > k)`                 | `2 > 1` ➜ sì → `remove(nums[1-1]=nums[0]=1)` → `set={0}` |
| `i = 2` → `nums[2] = 1`               | `contains(1)` ➜ no → `add(1)` → `set={0,1}`              |
| `if (set.size() > k)`                 | `2 > 1` ➜ sì → `remove(nums[2-1]=nums[1]=0)` → `set={1}` |
| `i = 3` → `nums[3] = 1`               | `contains(1)` ➜ **sì** → **`return true`**               |

**Spiegazione:** quando `i=3`, `1` è **già** nella finestra degli ultimi `k=1` elementi (indice 2), quindi la distanza è `3 - 2 = 1 ≤ k`.

---

### 🔁 Esecuzione passo passo — **Caso FALSE**

**Input:** `nums = [1, 2, 3, 1, 2, 3]`, `k = 2` → **`false`**  
(I duplicati ricompaiono sempre a **distanza 3**, che è `> k`.)

| i   | Valore | `contains(nums[i])` | `add(nums[i])` → set | `size > k`? → rimozione           | Finestra effettiva (ultimi ≤ k) |
| --- | ------ | ------------------- | -------------------- | --------------------------------- | ------------------------------- |
| 0   | 1      | no                  | `{1}`                | no                                | `[1]`                           |
| 1   | 2      | no                  | `{1,2}`              | no                                | `[1,2]`                         |
| 2   | 3      | no                  | `{1,2,3}`            | sì → remove `nums[0]=1` → `{2,3}` | `[2,3]`                         |
| 3   | 1      | no (`{2,3}`)        | `{2,3,1}`            | sì → remove `nums[1]=2` → `{3,1}` | `[3,1]`                         |
| 4   | 2      | no (`{3,1}`)        | `{3,1,2}`            | sì → remove `nums[2]=3` → `{1,2}` | `[1,2]`                         |
| 5   | 3      | no (`{1,2}`)        | `{1,2,3}`            | sì → remove `nums[3]=1` → `{2,3}` | `[2,3]`                         |

**Spiegazione:** per ogni duplicato (1, 2, 3) la ricomparsa è a distanza **3** (0↔3, 1↔4, 2↔5), quindi **mai ≤ k=2**. Nessun `contains(...)` scatta a `true` → si arriva alla fine e si **ritorna `false`**.

</details>
</details>