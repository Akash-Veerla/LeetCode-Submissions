class TriNode{
    private TriNode[] children;
    private boolean isEndWord;
    public TriNode(){
        children = new TriNode[26];
    }
    public void put(char ch , TriNode node){
        children[ch - 'a'] = node;
    }
    public TriNode get(char ch){
        return children[ch - 'a'];
    }
    public boolean containsKey(char ch){
        return children[ch - 'a'] != null;
    }
    public void setEnd(){
        isEndWord = true;
    }
    public boolean isEnd(){
        return isEndWord;
    }
}
class Trie {
    private TriNode root;
    public Trie() {
        root = new TriNode();
    }
    
    public void insert(String word) {
        TriNode curr = root;
        for(char ch : word.toCharArray()){
            if(!curr.containsKey(ch)){
                curr.put(ch , new TriNode());
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        TriNode curr = root;
        for(char ch : word.toCharArray()){
            if(!curr.containsKey(ch)){
                return false;
            }
            curr = curr.get(ch);
        }
        return curr.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TriNode curr = root;
        for(char ch : prefix.toCharArray()){
            if(!curr.containsKey(ch)){
                return false;
            }
            curr = curr.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */