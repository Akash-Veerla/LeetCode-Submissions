class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charCount.put(ch, 1 + charCount.getOrDefault(ch, 0));
        }
        int targetCharsRemaining = t.length(), startIndex = 0;
        int[] minWindow = {0, Integer.MAX_VALUE};
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            char ch = s.charAt(endIndex);
            if (charCount.containsKey(ch) && charCount.get(ch) > 0) {
                targetCharsRemaining--;
            }
            charCount.put(ch, -1 + charCount.getOrDefault(ch, 0));
            if (targetCharsRemaining == 0) {
                while (true) {
                    char charAtStart = s.charAt(startIndex);
                    if (charCount.containsKey(charAtStart) && charCount.get(charAtStart) == 0) {
                        break;
                    }
                    charCount.put(charAtStart, 1 + charCount.getOrDefault(charAtStart, 0));
                    startIndex++;
                }
                if (endIndex - startIndex < minWindow[1] - minWindow[0]) {
                    minWindow[0] = startIndex;
                    minWindow[1] = endIndex;
                }
                charCount.put(s.charAt(startIndex), 1 + charCount.getOrDefault(s.charAt(startIndex), 0));
                targetCharsRemaining++;
                startIndex++;
            }
        }
        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], 1 + minWindow[1]);
    }
}