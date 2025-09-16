class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> bankset = new HashSet();

        for (String str : bank) {
            bankset.add(str);
        }

        if (!bankset.contains(endGene)) {
            return -1;
        }

        Queue<String> q = new LinkedList();
        Set<String> visited = new HashSet();
        q.add(startGene);
        visited.add(startGene);

        List<Character> choices = Arrays.asList('A', 'C', 'G', 'T');

        int level = 0;

        while (!q.isEmpty()) {

            int sz = q.size();

            while (sz-- > 0) {

                String curr = q.remove();

                if (curr.equals(endGene)) {
                    return level;
                }

                for (int i = 0; i < 8; i++) {

                    for (Character c : choices) {

                        String tmp = curr.substring(0, i) + c + curr.substring(i + 1);

                        if (!visited.contains(tmp) && bankset.contains(tmp)) {
                            visited.add(tmp);
                            q.add(tmp);
                        }
                    }
                }
            }

            level++;
        }
        return -1;
    }
}