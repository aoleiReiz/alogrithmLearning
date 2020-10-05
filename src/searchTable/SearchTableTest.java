package searchTable;

import org.junit.Test;

public class SearchTableTest {

    @Test
    public void testWordPattern(){
        String pattern = "aaaa", str = "dog cat cat dog";
        SearchTableSolution searchTableSolution = new SearchTableSolution();
        System.out.println(searchTableSolution.wordPattern(pattern, str));
    }
}
