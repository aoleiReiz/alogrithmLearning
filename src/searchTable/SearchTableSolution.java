package searchTable;

import java.util.HashMap;
import java.util.Map;

public class SearchTableSolution {

    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> letter2Word = new HashMap<>();
        Map<String, Character> word2Letter = new HashMap<>();
        String []wordsArray = s.split(" ");
        if (wordsArray.length != pattern.length())
            return false;
        int idx = 0;
        for (String s1 : wordsArray){
            if (word2Letter.containsKey(s1)){
                char c = word2Letter.get(s1);
                if (c != pattern.charAt(idx))
                    return false;
            }else{
                char c = pattern.charAt(idx);
                if (letter2Word.containsKey(c)){
                   return false;
                }else{
                    word2Letter.put(s1, c);
                    letter2Word.put(c, s1);
                }
            }
            idx++;
        }
        return true;
    }

}
