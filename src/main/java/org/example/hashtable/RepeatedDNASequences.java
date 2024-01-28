package org.example.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        List<String> result = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static class Solution {

        public List<String> findRepeatedDnaSequences(String s) {
            List<String> result = new ArrayList<>();
            if (s == null || s.length() < 10) {
                return result;
            }
            Map<String, Integer> sequenceMap = new HashMap<>();
            for (int i = 0; i <= s.length() - 10; i++) {
                String sequence = s.substring(i, i + 10);
                int count = sequenceMap.getOrDefault(sequence, 0);
                if (count == 1) {
                    result.add(sequence);
                }
                sequenceMap.put(sequence, count + 1);
            }
            return result;
        }

    }
}
