public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        
        // Left to right pass
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        
        left = right = 0;
        
        // Right to left pass
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        
        // Example 1
        String s1 = "(()";
        System.out.println("Input: s = \"" + s1 + "\"");
        System.out.println("Output: " + solution.longestValidParentheses(s1)); // Expected: 2
        
        // Example 2
        String s2 = ")()())";
        System.out.println("Input: s = \"" + s2 + "\"");
        System.out.println("Output: " + solution.longestValidParentheses(s2)); // Expected: 4
        
        // Example 3
        String s3 = "";
        System.out.println("Input: s = \"" + s3 + "\"");
        System.out.println("Output: " + solution.longestValidParentheses(s3)); // Expected: 0
    }
}
