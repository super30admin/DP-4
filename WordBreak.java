import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Time : O(N^2)
// Space: O(N^2)
public class WordBreak {
    
    Map<String,Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        return helper(s,wordDict);
    }
    
    public boolean helper(String s, List<String> wordDict){
        // base 
        if(s.length()==0)
            return true;
        // logic 
        
        for(int i=0;i<s.length();i++){
            
            String str = s.substring(0,i+1);
            
            if(wordDict.contains(str)){
            
                String remainStr = s.substring(i+1);
                
                if(!map.containsKey(remainStr)){
                   boolean remainResult= helper(remainStr,wordDict);
                   map.put(remainStr,remainResult);
                }
              // if true return or else check for another substring      
                if(map.get(remainStr))
                    return map.get(remainStr);
            }
        }
        
        return false;
    }
}
