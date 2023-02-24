package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javafx.scene.chart.PieChart.Data;
import 字符串.StringTest;

public class BucketSort {
    

    public static void main(String[] args) throws Exception {
        BucketSort test2 = new BucketSort();
        System.out.println(test2.bucketSort("cbc","cab"));
    }

    public boolean bucketSort(String a, String b) {
        //对应26个字母的桶子
        int[] bucket = new int[26];
        for(char c : a.toCharArray()){
            bucket[c - 'a']++;
        }
        for(char c : b.toCharArray()){
            bucket[c- 'a']--;
        }
        for(int alphabetCnt : bucket){
            if(alphabetCnt != 0){
                return false;
            }
        }
        return true;
    }
}


