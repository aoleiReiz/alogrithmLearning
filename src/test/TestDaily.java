package test;

import daily.DailySolution;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestDaily {

    @Test
    public void test(){
        DailySolution d = new DailySolution();
        String beginWord = "a";
        String endWord = "c";
        String []wordList = {"a","b","c"};
        List<String> arr = new ArrayList<>(Arrays.asList(wordList));

        int count = d.ladderLength(beginWord, endWord, arr);
        System.out.println(count);
    }
}
