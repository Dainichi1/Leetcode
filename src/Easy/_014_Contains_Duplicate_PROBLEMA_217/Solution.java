package Easy._014_Contains_Duplicate_PROBLEMA_217;

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate (int[] nums) {
        HashSet<Integer> seenNumbers = new HashSet<>();

        for (int num : nums) {
            if (seenNumbers.contains(num)) {
                return true;
            }
            seenNumbers.add(num);
        }

        return false;
    }
}
