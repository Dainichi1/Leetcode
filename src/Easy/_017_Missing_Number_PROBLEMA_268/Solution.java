package Easy._017_Missing_Number_PROBLEMA_268;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;

        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }

        for (int value : nums) {
            xor ^= value;
        }

        return xor;
    }
}
