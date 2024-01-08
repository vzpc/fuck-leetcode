package org.example.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {"bdddddddddd","bbbbbbbbbbc"};
        List<List<String>> result = solution.groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }

    private static class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                String key = getKey(str);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }

        private String getKey(String str) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            return key;
        }
    }
}
