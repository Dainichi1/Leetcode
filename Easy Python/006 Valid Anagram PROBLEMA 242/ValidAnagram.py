class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        counts = [0] * 26

        for c1, c2 in zip(s, t):
            counts[ord(c1) - 97] += 1
            counts[ord(c2) - 97] -= 1

        return all(count == 0 for count in counts)

# s= abc
# t = cba
