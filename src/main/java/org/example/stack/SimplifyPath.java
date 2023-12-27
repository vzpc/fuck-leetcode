package org.example.stack;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String result = solution.simplifyPath("/home/");
        System.out.println(result);
    }

    private static class Solution {

        public String simplifyPath(String path) {
            String[] names = path.split("/");
            Deque<String> stack = new LinkedList<>();
            for (String name : names) {
                if (name.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!name.equals(".") && !name.isEmpty()) {
                    stack.push(name);
                }
            }
            StringBuffer result = new StringBuffer();
            while (!stack.isEmpty()) {
                result.append("/").append(stack.pollLast());
            }
            return result.length() == 0 ? "/" : result.toString();
        }
    }
}
