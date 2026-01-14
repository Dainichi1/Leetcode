package Easy._070_Climbing_Stairs;

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int ways1 = 1; // modi per arrivare al gradino precedente-1
        int ways2 = 2; // modi per arrivare al gradino precedente

        for (int i = 3; i <= n; i++) {
            int current = ways2 + ways1; // ways(i)
            ways1 = ways2;               // ways(1) “scorre” e diventa vecchio ways(2)
            ways2 = current;             // ways(2) diventa ways(i)
        }

        return ways2; // qui ritorni ways(n)
    }
}


/*
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];  // dp[i] = modi per arrivare al gradino i
        dp[1] = 1;                  // ways(1)
        dp[2] = 2;                  // ways(2)

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

 */