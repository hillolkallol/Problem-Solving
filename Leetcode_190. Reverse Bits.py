'''
190. Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

Example:

Input: 43261596
Output: 964176192
Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
             return 964176192 represented in binary as 00111001011110000010100101000000.
Follow up:
If this function is called many times, how would you optimize it?
'''


class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        binaryNum = str(bin(n))
        l = len(binaryNum)
        binaryNum = '0'*(32-l+2) + binaryNum[2:]
        binaryNum = binaryNum[::-1]

        n = int(binaryNum, 2)

        return n

s = Solution()
print(s.reverseBits(43261596))