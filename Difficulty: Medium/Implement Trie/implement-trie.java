class TrieNode{
    TrieNode children[] ;
    boolean isEndOfWord ;
    
    TrieNode(){
        children = new TrieNode[26] ;
        isEndOfWord = false ;
    }
}


class Trie {
    
    TrieNode root ;
    
    public Trie() {
        root = new TrieNode() ;
    }

    // Insert a word into the Trie
    public void insert(String word) {
        
        TrieNode curr = root ;
        for( int i = 0 ; i < word.length() ; i++ ){
            char ch = word.charAt(i) ;
            
            if( curr.children[ch-'a'] == null ){
                curr.children[ch-'a'] = new TrieNode() ;
            }
            
            curr = curr.children[ch-'a'] ;
        }
        
        curr.isEndOfWord = true ;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode curr = root ;
        for( int i = 0 ; i < word.length() ; i++ ){
            
            char ch = word.charAt(i) ;
            
            if( curr.children[ch-'a'] == null )
                return false ;
            
            curr = curr.children[ch-'a'] ;
        }
        
        return curr.isEndOfWord ;
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        TrieNode curr = root ;
        for( int i = 0 ; i < word.length() ; i++ ){
            
            char ch = word.charAt(i) ;
            
            if( curr.children[ch-'a'] == null )
                return false ;
            
            curr = curr.children[ch-'a'] ;
            
        }
        return true ;
    }
}