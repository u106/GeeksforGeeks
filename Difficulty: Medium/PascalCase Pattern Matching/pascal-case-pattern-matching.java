class Solution{
    
    class TrieNode{
        TrieNode[] children ;
        // A list to hold all full words which are ending 
        // at this specific sequence 
        ArrayList<String> words ;
        
        TrieNode(){
            children = new TrieNode[26] ;
            words = new ArrayList<String>() ;
        }
        
    }
    public List<String> pascalCase(String[] arr, String pat) {
        // code here
        
        // 1. Insert all the words in the trie 
        TrieNode root = new TrieNode() ;
        
        for( String word : arr ){
            TrieNode curr = root ;
            
            for( int i = 0 ; i < word.length() ; i++ ){
                char ch = word.charAt(i) ;
                
                if( Character.isUpperCase(ch) ){
                    if( curr.children[ch-'A'] == null ){
                        curr.children[ch-'A'] = new TrieNode() ;
                    }
                    curr = curr.children[ch-'A'] ;
                }
            }
            curr.words.add( word ) ;
        }
        // insertion of words is completed here 
        // Eg : PAT = HT
        // We have to search this entire pattern in the trie 
        TrieNode curr = root ;
        for( int i = 0 ; i < pat.length() ; i++ ){
            char ch = pat.charAt(i) ;
            
            if( curr.children[ch-'A'] == null ){
                // answer does not exist
                return new ArrayList<>() ;
            }
            curr = curr.children[ch-'A'] ;
        }
        // curr is resting at the node which represents the last char of pattern
        
        ArrayList<String> ans = new ArrayList<>() ;
        collectWords( curr , ans ) ;
        return ans ;
        
    }
    public void collectWords( TrieNode curr , ArrayList<String> ans ){
        // if( curr == null ){
        //     return ;
        // }
        
        ans.addAll( curr.words ) ;
        // Iterating over all the 26 children of curr
        for( int i = 0 ; i < 26 ; i++ ){
            if( curr.children[i] != null ){
                collectWords( curr.children[i] , ans ) ;
            }
        }
        
    }
    
    
    
    
    
    
    
}
