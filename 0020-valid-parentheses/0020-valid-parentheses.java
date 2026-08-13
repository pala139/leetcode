import java.util.Stack;

class Solution {
    /**
     * Topic: LIFO Stack — Valid Parentheses (LeetCode 20)
     * Core Idea: Match the most recent opening bracket with incoming closing brackets.
     * 
     * Time Complexity:  O(N) — Single pass through string of length N
     * Space Complexity: O(N) — Stack holds up to N characters in worst case
     */
    public boolean isValid(String str) {
        // LIFO structure to store unclosed opening brackets
        Stack<Character> stack = new Stack();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            // Case 1: Matching closing square bracket found -> Pop corresponding opening bracket
            if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
            // Case 2: Matching closing round bracket found -> Pop corresponding opening bracket
            else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            // Case 3: Matching closing curly bracket found -> Pop corresponding opening bracket
            else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }
            // Case 4: Push opening brackets (or mismatched closing brackets) onto stack
            else {
                stack.push(ch);
            }
        }
        
        // Stack is empty ONLY if every opening bracket had a valid matching closing bracket
        return stack.isEmpty();
    }
}