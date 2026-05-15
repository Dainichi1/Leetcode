class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        if len(ransomNote) > len(magazine):
            return False

        counts = [0] *26

        for c in magazine:
            counts[ord(c) - 97] += 1

        for c in ransomNote:
            index = ord(c) - 97
            if counts[index] == 0:
                return False
            counts[index] -= 1

        return True

# ransomNote = "aa"
# magazine = "aab
