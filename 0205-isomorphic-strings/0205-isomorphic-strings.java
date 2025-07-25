class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mapStoT = new HashMap<>();
        Map<Character, Character> mapTtoS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (mapStoT.containsKey(charS)) {
                if (mapStoT.get(charS) != charT) {
                    return false;
                }
            } else {
                mapStoT.put(charS, charT);
            }
            if (mapTtoS.containsKey(charT)) {
                if (mapTtoS.get(charT) != charS) {
                    return false;
                }
            } else {
                mapTtoS.put(charT, charS);
            }
        }
        return true;
    }
}