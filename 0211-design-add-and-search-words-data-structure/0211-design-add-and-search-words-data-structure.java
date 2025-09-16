class WordDictionary {

     class Node{
		Node childrens[];
		boolean eow;
		
		Node(){
			childrens=new Node[26];
			for(int i=0;i<26;i++) {
				childrens[i]=null;
			}
			eow=false;
		}
	}

    	 Node root=new Node();

    
    public void addWord(String word) {
        Node curr=root;
		
		for(int i=0;i<word.length();i++) {
			int index=word.charAt(i)-'a';
			if(curr.childrens[index]==null) {
				curr.childrens[index]=new Node();
			}
			
			if(i==word.length()-1) {
				curr.childrens[index].eow=true;
			}
			
			curr=curr.childrens[index];
		}
    }
    
    public  boolean search(String word) {
		return helper(word.toCharArray(),0,root);
	}
	
	public boolean helper(char[] chars,int k,Node curr) {
		if(k==chars.length) {
			return curr.eow;
		}
		
		
		if(chars[k]!='.') {
			return curr.childrens[chars[k]-'a']!=null && helper(chars,k+1,curr.childrens[chars[k]-'a']);
		}else {
			for(int i=0;i<26;i++) {
				if(curr.childrens[i]!=null) {
					if(helper(chars,k+1,curr.childrens[i])) {
						 return true;
					}
				}
			}
		}
		return false;
	}
	

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */