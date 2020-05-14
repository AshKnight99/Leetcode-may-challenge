/*
Implement a trie with insert, search, and startsWith methods.
Example:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/


class Trie {
    class Node{
    Character c;
    Map <Character,Node> map;
    boolean b;
    public Node(Character c){
        this.c = c;
        this.map = new HashMap<>();
    }
}
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node('\0');
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()){
          Node temp = node.map.get(c);
            if (temp == null){
                temp = new Node(c);
                node.map.put(c,temp);
            }
            node = temp;                
        }
        node.b = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()){
            node = node.map.get(c);
                if (node == null)
                    return false;                    
        }
        return node.b;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()){
            node = node.map.get(c);
                if (node == null)
                    return false;                    
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