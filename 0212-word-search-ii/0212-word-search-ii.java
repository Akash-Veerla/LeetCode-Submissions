class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null; 

    public TrieNode() {
    }
}

class Solution {
    char[][] fullboard = null; 
    ArrayList<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        
        for (String word : words) {
            TrieNode node = root;
            for (Character letter : word.toCharArray()) {
                if (!node.children.containsKey(letter)) {
                    node.children.put(letter, new TrieNode());
                }
                node = node.children.get(letter);
            }
            node.word = word; 
        }

        this.fullboard = board;

        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }
        return ans;
    }

    public void backtracking(int row, int col, TrieNode parent) {
        Character letter = fullboard[row][col];
        TrieNode currNode = parent.children.get(letter);

        
        if (currNode.word != null) {
            this.ans.add(currNode.word); 
            currNode.word = null; 
        }

        fullboard[row][col] = '#'; 

        
        int[] rowOffset = { -1, 0, 1, 0 };
        int[] colOffset = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int nrow = row + rowOffset[i];
            int ncol = col + colOffset[i];

            
            if (nrow < 0 || ncol < 0 || nrow >= fullboard.length || ncol >= fullboard[0].length) {
                continue;
            }

            
            if (currNode.children.containsKey(fullboard[nrow][ncol])) {
                backtracking(nrow, ncol, currNode);
            }
        }

        fullboard[row][col] = letter; 

        
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}