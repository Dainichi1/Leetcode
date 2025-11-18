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
<details>
<summary>📂 ✅ #242. Valid Anagram</summary>

**Difficoltà:** Easy  
**Link al problema:** [LeetCode - Valid Anagram](https://leetcode.com/problems/valid-anagram/)

---

### 🔍 Descrizione

Date due stringhe `s` e `t`, restituisci `true` **se `t` è un anagramma di `s`**, e `false` altrimenti.

📘 *Un anagramma è una parola o frase ottenuta riordinando le lettere di un’altra parola o frase.*

Esempio:
- `"anagram"` → `"nagaram"` ✅
- `"rat"` → `"car"` ❌

---

### 🧠 Soluzione ottimizzata (Array di conteggio)

L’idea: confrontare le **frequenze di ciascuna lettera**.  
Usiamo un array di 26 interi (per le lettere da `'a'` a `'z'`).

**Complessità:**
- ⏱ Tempo: **O(n)**
- 💾 Spazio: **O(1)** (26 posizioni fisse)

---

### 💻 Codice Java con spiegazione riga per riga

| Codice | Spiegazione pratica |
|--------|----------------------|
| ```java<br>class Solution {``` | Inizia la classe richiesta da LeetCode. |
| ```java<br>    public boolean isAnagram(String s, String t) {``` | Metodo pubblico che prende due stringhe `s` e `t` e restituisce `true` se sono anagrammi. |
| ```java<br>        if (s.length() != t.length()) {``` | Controllo rapido: se le lunghezze differiscono, non possono essere anagrammi. |
| ```java<br>            return false;``` | Esempio: `"rat"` (3) e `"caro"` (4) → ritorna `false`. |
| ```java<br>        }``` | Chiude l’`if`. |
| ```java<br>        int[] charCounts = new int[26];``` | Crea un array di 26 elementi, uno per ogni lettera da `'a'` a `'z'`. Tutti inizializzati a `0`. |
| ```java<br>        for (int i = 0; i < s.length(); i++) {``` | Ciclo che scorre tutti i caratteri di `s` e `t` contemporaneamente. |
| ```java<br>            charCounts[s.charAt(i) - 'a']++;``` | Incrementa il contatore della lettera `s[i]`. `'a'` serve per calcolare l’indice (0 per `'a'`, 1 per `'b'`, ecc.). |
| ```java<br>            charCounts[t.charAt(i) - 'a']--;``` | Decrementa il contatore della lettera `t[i]`. Così ogni coppia di lettere uguali si annulla. |
| ```java<br>        }``` | Fine del ciclo. Alla fine, se `s` e `t` contengono le stesse lettere, tutti i contatori saranno 0. |
| ```java<br>        for (int count : charCounts) {``` | Controlla tutti i contatori. |
| ```java<br>            if (count != 0) {``` | Se trovi un valore diverso da 0, almeno una lettera ha frequenza differente. |
| ```java<br>                return false;``` | Esempio: `"rat"` vs `"car"` → contatore di `'t'` e `'c'` ≠ 0 → `false`. |
| ```java<br>            }``` | Chiude l’`if`. |
| ```java<br>        }``` | Fine del ciclo di verifica. |
| ```java<br>        return true;``` | Se tutti i contatori sono 0, le due stringhe sono anagrammi → `true`. |
| ```java<br>    }``` | Fine del metodo. |
| ```java<br>}``` | Fine della classe. |

---

### 🔁 Esecuzione passo passo — Caso TRUE

**Input:**
```java
s = "anagram"
t = "nagaram"
```

| Iterazione | s[i] | Effetto (+) | t[i] | Effetto (–) | Stato parziale (lettere principali) |
|-------------|------|--------------|------|--------------|-------------------------------------|
| i = 0 | `'a'` → +1 | a:1 | `'n'` → –1 | n:-1 | a:1, n:-1 |
| i = 1 | `'n'` → +1 | n:0 | `'a'` → –1 | a:0 | tutto 0 finora |
| i = 2 | `'a'` → +1 | a:1 | `'g'` → –1 | g:-1 | a:1, g:-1 |
| i = 3 | `'g'` → +1 | g:0 | `'a'` → –1 | a:0 | tutto 0 |
| i = 4 | `'r'` → +1 | r:1 | `'r'` → –1 | r:0 | tutto 0 |
| i = 5 | `'a'` → +1 | a:1 | `'a'` → –1 | a:0 | tutto 0 |
| i = 6 | `'m'` → +1 | m:1 | `'m'` → –1 | m:0 | tutto 0 |

✅ Tutti i contatori = 0 ⇒ ritorna `true`.

---

### 🔁 Esecuzione passo passo — Caso FALSE

**Input:**
```java
s = "rat"
t = "car"
```

| Iterazione | s[i] | Effetto (+) | t[i] | Effetto (–) | Stato finale |
|-------------|------|--------------|------|--------------|---------------|
| i = 0 | `'r'` → +1 | r:1 | `'c'` → –1 | c:-1 | r:1, c:-1 |
| i = 1 | `'a'` → +1 | a:1 | `'a'` → –1 | a:0 | r:1, c:-1 |
| i = 2 | `'t'` → +1 | t:1 | `'r'` → –1 | r:0 | t:1, c:-1 |

Alla fine alcuni contatori ≠ 0 (`t:1`, `c:-1`) ⇒ **ritorna `false`**.

---

### 🔎 Spiegazione del `'a'`

Nell’espressione:

```java
s.charAt(i) - 'a'
```

- `'a'` è un **carattere** con codice Unicode 97.
- Ogni lettera minuscola successiva (`'b'`, `'c'`, …) ha codice maggiore.
- Quindi `'b' - 'a' = 1`, `'c' - 'a' = 2`, …, `'z' - 'a' = 25`.

In questo modo otteniamo un indice compreso tra 0 e 25, perfetto per accedere all’array `charCounts[26]`.

</details>
</details>