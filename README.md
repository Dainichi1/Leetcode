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
<details> <summary>📂 ✅ #121. Best Time to Buy and Sell Stock</summary>

Difficoltà: Easy
Link al problema: LeetCode - Best Time to Buy and Sell Stock

🔍 Descrizione

Ti viene dato un array prices dove prices[i] è il prezzo di un’azione nel giorno i.

Vuoi massimizzare il profitto scegliendo:

un solo giorno per comprare una azione

un giorno diverso nel futuro per vendere quell’azione

Restituisci il massimo profitto ottenibile.
Se non puoi ottenere profitto, restituisci 0.

🧠 Soluzione ottimizzata (One Pass: minimo + profitto)

Idea chiave:

Teniamo il prezzo minimo visto finora (minPrice) → miglior giorno per comprare fino a quel momento.

Per ogni giorno calcoliamo il profitto se vendiamo oggi: price - minPrice.

Aggiorniamo il profitto massimo (maxProfit) se troviamo un profitto migliore.

Un solo ciclo → Tempo O(n), Spazio O(1).

🔁 Esecuzione passo passo (esempio semplice)

Input:

prices = [5, 2, 4]

Codice Java / Stato	Esecuzione pratica (come nella realtà)
minPrice = ∞, maxProfit = 0	Inizio: non ho ancora visto prezzi, profitto migliore = 0
Giorno 1: price = 5	5 < ∞ → aggiorno minimo: compro “idealmente” a 5
Stato: minPrice = 5, maxProfit = 0	Miglior prezzo visto finora: 5
Giorno 2: price = 2	2 < 5 → nuovo minimo: compro meglio a 2
Stato: minPrice = 2, maxProfit = 0	Miglior prezzo visto finora: 2
Giorno 3: price = 4	4 non è minimo → provo a vendere oggi: profitto = 4 - 2 = 2
Stato: maxProfit = 2	Miglior affare trovato: compro a 2 e vendo a 4 → profitto 2

✅ Risultato finale: 2

💻 Codice Java (coincide con la soluzione ottimizzata)
class Solution {
public int maxProfit(int[] prices) {
int minPrice = Integer.MAX_VALUE;
int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }
}

🔎 Spiegazione chiave (super chiara)

minPrice = “il prezzo migliore a cui avrei potuto comprare fino a ieri/oggi”

quando il prezzo scende, aggiorno minPrice

quando il prezzo sale rispetto a minPrice, calcolo un possibile guadagno

tengo sempre il migliore in maxProfit

📦 Visuale:

minPrice  → miglior prezzo di acquisto finora
maxProfit → miglior guadagno possibile finora

🧪 Edge cases utili

prices = [7,6,4,3,1] → sempre in discesa → maxProfit resta 0

prices = [1] → non puoi vendere dopo → 0

prices = [2,1,2] → compro a 1, vendo a 2 → 1

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

<details open>
<summary>🟡 MEDIUM</summary>

<details>
<summary>📂 ✅ 49. Group Anagrams</summary>

**Difficoltà:** Medium  
**Link al problema:** [LeetCode - 49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)

---

### 🔍 Descrizione

Dato un array di stringhe `strs`, dobbiamo **raggruppare insieme** tutte le stringhe che sono **anagrammi** tra loro.

> Due stringhe sono anagrammi se:
>
> * hanno gli **stessi caratteri**,
> * con le **stesse frequenze**,
> * ma magari in **ordine diverso**.

Esempio:

* Input: `["eat","tea","tan","ate","nat","bat"]`
  Output possibile (ordine libero):

   * `["bat"]`
   * `["nat","tan"]`
   * `["ate","eat","tea"]`

L’ordine dei gruppi e l’ordine interno alle liste **non importa** per LeetCode.

---

### 💡 Idea / Intuizione

Trucco chiave:

1. Per ogni parola, **ordiniamo i caratteri** in ordine alfabetico:

   * `"eat"` → `"aet"`
   * `"tea"` → `"aet"`
   * `"tan"` → `"ant"`

2. Usiamo la stringa ordinata come **chiave** di una `HashMap<String, List<String>>`:

   * chiave `"aet"` → lista `["eat","tea","ate"]`
   * chiave `"ant"` → lista `["tan","nat"]`
   * chiave `"abt"` → lista `["bat"]`

3. Le **values** della mappa sono esattamente i gruppi di anagrammi da restituire.

Perché funziona?
Se due parole sono anagrammi, una volta ordinate diventano **identiche**. Quindi avranno la stessa chiave e finiranno nella stessa lista.

---

### 🧩 Algoritmo step-by-step

Dato `strs`:

1. Crea una mappa:

   ```java
   HashMap<String, List<String>> groups = new HashMap<>();
   ```

   * chiave = stringa ordinata (es. `"aet"`)
   * valore = lista di anagrammi (es. `["eat","tea","ate"]`)

2. Per ogni stringa `s` in `strs`:

   1. Converti `s` in array di caratteri.
   2. Ordina l’array.
   3. Crea una chiave `key` dalla stringa ordinata.
   4. Se `key` non esiste ancora nella mappa, crea una nuova lista.
   5. Aggiungi `s` alla lista corrispondente a `key`.

3. Alla fine, restituisci tutte le liste contenute nella mappa.

---

### ⏱️ Complessità

Sia:

* `n = strs.length` (numero di stringhe)
* `k = lunghezza media delle stringhe`

Per ogni stringa:

* conversione in array di char → `O(k)`
* ordinamento dell’array → `O(k log k)`
* inserimento in mappa → `O(1)` in media

**Tempo totale:** `O(n · k log k)`
**Spazio:** `O(n · k)` (salviamo tutte le stringhe dentro le liste + chiavi).

---

### 💻 Codice Java

```java
package Medium._049_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Mappa: chiave = stringa ordinata, valore = lista di anagrammi
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            // 1. Convertiamo la stringa in array di char
            char[] chars = s.toCharArray();
            // 2. Ordiniamo l'array di char
            Arrays.sort(chars);
            // 3. Creiamo la chiave come nuova stringa ordinata
            String key = new String(chars);

            // 4. Se la chiave non esiste ancora, creiamo una nuova lista
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            // 5. Aggiungiamo la stringa originale al gruppo corrispondente
            groups.get(key).add(s);
        }

        // 6. Restituiamo tutte le liste di anagrammi
        return new ArrayList<>(groups.values());
    }
}
```

---

## 🔬 Dry-run completo riga per riga (esempio pratico)

Useremo questo input:

```java
String[] strs = {"eat","tea","tan","ate","nat","bat"};
```

e vediamo **come ogni riga di codice si applica nella pratica**, con lo stato delle variabili e della mappa.

---

### 1️⃣ Chiamata del metodo e stato iniziale

| Codice                                                     | Cosa succede in pratica                                                     |
| ---------------------------------------------------------- | --------------------------------------------------------------------------- |
| `public List<List<String>> groupAnagrams(String[] strs) {` | Entra nel metodo. `strs` contiene: `["eat","tea","tan","ate","nat","bat"]`. |

---

### 2️⃣ Creazione della mappa `groups`

| Codice                                                    | Cosa succede in pratica                                                                                                                       |
| --------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- |
| `HashMap<String, List<String>> groups = new HashMap<>();` | Viene creata una mappa vuota. <br>`groups = { }`. Conterrà chiavi come `"aet"`, `"ant"`, `"abt"` e, come valori, liste di stringhe anagrammi. |

---

### 3️⃣ Il ciclo `for` – panoramica

```java
for (String s : strs) {
    ...
}
```

`strs = ["eat","tea","tan","ate","nat","bat"]`, quindi il ciclo farà 6 iterazioni con:

1. `s = "eat"`
2. `s = "tea"`
3. `s = "tan"`
4. `s = "ate"`
5. `s = "nat"`
6. `s = "bat"`

Ora analizziamo **ogni iterazione** nel dettaglio.

---

### 🔁 Iterazione 1 — `s = "eat"`

| Codice                                  | Cosa succede con `s = "eat"`                                                                              |
| --------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `char[] chars = s.toCharArray();`       | `"eat"` → `chars = ['e','a','t']`.                                                                        |
| `Arrays.sort(chars);`                   | Ordiniamo: `['e','a','t']` → `['a','e','t']`.                                                             |
| `String key = new String(chars);`       | `key = "aet"`.                                                                                            |
| `if (!groups.containsKey(key)) { ... }` | `"aet"` non esiste ancora → creiamo `groups.put("aet", new ArrayList<>());` → `groups = { "aet" -> [] }`. |
| `groups.get(key).add(s);`               | Aggiungiamo `"eat"` alla lista: `groups = { "aet" -> ["eat"] }`.                                          |

---

### 🔁 Iterazione 2 — `s = "tea"`

| Codice                     | Cosa succede con `s = "tea"`                                               |
| -------------------------- | -------------------------------------------------------------------------- |
| `s = "tea"`                | Secondo giro.                                                              |
| `s.toCharArray()`          | `"tea"` → `['t','e','a']`.                                                 |
| `Arrays.sort(chars);`      | `['t','e','a']` → `['a','e','t']`.                                         |
| `key = new String(chars)`  | `key = "aet"` (stessa chiave di `"eat"`).                                  |
| `containsKey("aet")`       | Esiste già → **non** creiamo una nuova lista.                              |
| `groups.get("aet").add(s)` | `["eat"]` → `["eat","tea"]`. Mappa: `groups = { "aet" -> ["eat","tea"] }`. |

---

### 🔁 Iterazione 3 — `s = "tan"`

| Codice                     | Cosa succede con `s = "tan"`                                                                     |
| -------------------------- | ------------------------------------------------------------------------------------------------ |
| `s = "tan"`                | Terzo giro.                                                                                      |
| `s.toCharArray()`          | `"tan"` → `['t','a','n']`.                                                                       |
| `Arrays.sort(chars);`      | `['t','a','n']` → `['a','n','t']`.                                                               |
| `key = new String(chars)`  | `key = "ant"`.                                                                                   |
| `containsKey("ant")`       | Non esiste → creiamo `groups.put("ant", new ArrayList<>());`.                                    |
| `groups.get("ant").add(s)` | Lista `"ant"` diventa `["tan"]`. Mappa: `groups = { "aet" -> ["eat","tea"], "ant" -> ["tan"] }`. |

---

### 🔁 Iterazione 4 — `s = "ate"`

| Codice                     | Cosa succede con `s = "ate"`                            |
| -------------------------- | ------------------------------------------------------- |
| `s = "ate"`                | Quarto giro.                                            |
| `s.toCharArray()`          | `"ate"` → `['a','t','e']`.                              |
| `Arrays.sort(chars);`      | `['a','t','e']` → `['a','e','t']`.                      |
| `key = new String(chars)`  | `key = "aet"`.                                          |
| `containsKey("aet")`       | Esiste già → non creiamo nuova lista.                   |
| `groups.get("aet").add(s)` | Lista `"aet"`: `["eat","tea"]` → `["eat","tea","ate"]`. |

---

### 🔁 Iterazione 5 — `s = "nat"`

| Codice                     | Cosa succede con `s = "nat"`                |
| -------------------------- | ------------------------------------------- |
| `s = "nat"`                | Quinto giro.                                |
| `s.toCharArray()`          | `"nat"` → `['n','a','t']`.                  |
| `Arrays.sort(chars);`      | `['n','a','t']` → `['a','n','t']`.          |
| `key = new String(chars)`  | `key = "ant"`.                              |
| `containsKey("ant")`       | Esiste già → usiamo la lista esistente.     |
| `groups.get("ant").add(s)` | Lista `"ant"`: `["tan"]` → `["tan","nat"]`. |

---

### 🔁 Iterazione 6 — `s = "bat"`

| Codice                     | Cosa succede con `s = "bat"`                                                                                           |
| -------------------------- | ---------------------------------------------------------------------------------------------------------------------- |
| `s = "bat"`                | Sesto (ultimo) giro.                                                                                                   |
| `s.toCharArray()`          | `"bat"` → `['b','a','t']`.                                                                                             |
| `Arrays.sort(chars);`      | `['b','a','t']` → `['a','b','t']`.                                                                                     |
| `key = new String(chars)`  | `key = "abt"`.                                                                                                         |
| `containsKey("abt")`       | Non esiste → creiamo nuova lista: `groups.put("abt", new ArrayList<>());`.                                             |
| `groups.get("abt").add(s)` | Lista `"abt"` diventa `["bat"]`. Mappa finale: `{ "aet"->["eat","tea","ate"], "ant"->["tan","nat"], "abt"->["bat"] }`. |

---

### 🔚 Return finale

```java
return new ArrayList<>(groups.values());
```

Questo restituisce qualcosa del tipo:

```java
[
  ["eat","tea","ate"],
  ["tan","nat"],
  ["bat"]
]
```
</details>
</details>
