'''
20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
'''

class Solution:
    def isValid(self, s):
        stack = []
        if s == "":
            return True

        for char in s:
            if char == "(":
                stack.append("(")
            elif char == "{":
                stack.append("{")
            elif char == "[":
                stack.append("[")
            elif char == ")":
                if not stack:
                    return False
                if stack.pop() != "(":
                    return False
            elif char == "}":
                if not stack:
                    return False
                if stack.pop() != "{":
                    return False
            elif char == "]":
                if not stack:
                    return False
                if stack.pop() !="[":
                    return False

        if not stack:
            return True
        return False

s = Solution()
print(s.isValid("{"))