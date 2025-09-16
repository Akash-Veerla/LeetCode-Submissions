class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int startIndex = -1;
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        // create adjacent list for all
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord))
                startIndex = i;
            list.add(new ArrayList<Integer>());
        }

        //check if endWord is in wordList
        if (startIndex == -1) {
            return 0;
        }

        // create a visitedList to create track of what we have covered
        boolean[] visited = new boolean[wordList.size()];
        Arrays.fill(visited, false);

        // fill each adj list
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String w1 = wordList.get(i), w2 = wordList.get(j);

                if (diffBy1(w1, w2)) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }

            String w1 = wordList.get(i);
            if (diffBy1(w1, beginWord)) {
                set.add(i);
            }
        }

        int depth = 0;
        boolean match = false;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(startIndex);
        visited[startIndex] = true;

        while (!deque.isEmpty()) {
            int size = deque.size();

            while (size > 0) {
                int currIndex = deque.removeFirst();

                if (wordList.get(currIndex).equals(beginWord)) {
                    return depth + 1;
                }

                if (set.contains(currIndex)) {
                    match = true;
                }

                for (int i = 0; i < list.get(currIndex).size(); i++) {
                    if (!visited[list.get(currIndex).get(i)]) {
                        visited[list.get(currIndex).get(i)] = true;
                        deque.addLast(list.get(currIndex).get(i));
                    }
                }
                size--;
            }
            depth++;
            if (match)
                break;
        }
        return match ? depth + 1 : 0;
    }

    public boolean diffBy1(String str1, String str2) {
        int strikes = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                strikes++;
            }

            if (strikes > 1) {
                return false;
            }
        }

        return true;
    }
}