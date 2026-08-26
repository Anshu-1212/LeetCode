class Solution {
    public boolean isPalindromic(String s) {
        int totalBits = s.length() * 8;

        int left = 0;
        int right = totalBits - 1;

        while (left < right) {
            int leftChar = left / 8;
            int leftBit = left % 8;

            int rightChar = right / 8;
            int rightBit = right % 8;

            int l = (s.charAt(leftChar) >> (7 - leftBit)) & 1;
            int r = (s.charAt(rightChar) >> (7 - rightBit)) & 1;

            if (l != r) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}