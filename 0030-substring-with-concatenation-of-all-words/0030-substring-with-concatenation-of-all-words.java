class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0) return res;
        int wordLen = words[0].length();
        int wordCount = words.length;
        int windowSize = wordLen * wordCount;
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, 1 + wordFreq.getOrDefault(word, 0));
        }
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> windowMap = new HashMap<>();
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                if (wordFreq.containsKey(word)) {
                    windowMap.put(word, 1 + windowMap.getOrDefault(word, 0));
                    count++;
                    while (windowMap.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, -1 + windowMap.get(leftWord));
                        count--;
                        left += wordLen;
                    }
                    if (count == wordCount) {
                        res.add(left);
                    }
                } else {
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return res;
    }
}