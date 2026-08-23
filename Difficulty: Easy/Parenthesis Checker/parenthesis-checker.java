class Solution {
    public boolean isBalanced(String str) {
        // code here
        
        // What to do ? 
        // 1. Stack is empty in the end = Balanced
        // 2. Stack is not empty => Not Balanced
        // 3. Closing bracket found but stack is empty => Not Balanced
        // 4. Type mismatch => Not Balanced
        
        // How to do 
        // 1. Stack create krenge
        Stack<Character> st = new Stack<>() ;
        
        // 2. Iterate over the string 
        int n = str.length() ;
        for( int i = 0 ; i < n ; i++ ){
            // opening bracket -=> push
            char ch = str.charAt(i) ;
            
            if( ch == '{' || ch == '[' || ch == '(' )
                st.push( ch ) ;
            else{
                // closing bracket => 
                if( st.isEmpty() )
                    return false ;
                    
                char popElement = st.pop() ;
                
                if( popElement == '[' && ch == ']' )
                    continue ;
                else if( popElement == '{' && ch == '}' )
                    continue ;
                else if( popElement == '(' && ch == ')' )
                    continue ;
                else{
                    return false ;
                }
                
                // type mismatch => not balanced
                // type match => continue 
                // stack is empty => not balanced   
            }
            
        }
            
        return st.isEmpty() ; 
    }
}

// [[[]]]
// {[()]}
// ([)] -> No
// ([])
// }[] -> No
// {{{}} -> No