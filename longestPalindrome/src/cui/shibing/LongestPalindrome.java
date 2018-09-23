package cui.shibing;

public class LongestPalindrome {
    public static void main(String[] args) {
        String value = new LongestPalindrome().longestPalindrome("ac");
        System.out.println(value);
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int longest = 0;
        int[] localResult = new int[2];
        localResult[0] = 0;
        localResult[1] = 0;
        char[] chars = s.toCharArray();
        for (int i = 1, len = s.length() * 2 - 1; i < len; i++) {
            indexOfLongestPalindrome(chars,i);
            int l = result[1] - result[0] + 1;
            if(l > longest){
                localResult[0] = result[0];
                localResult[1] = result[1];
                longest = l;
            }
        }
        if(longest == 0){
            longest+=1;
        }
        return new String(chars,localResult[0],longest);
    }
    int[] result = new int[2];
    /**
     * 把一字符串从某一点对折，检查相同的字符有多少个
     */
    private void indexOfLongestPalindrome(char[] array, int foldIndex) {
        int leftStartIndex;
        int rightStartIndex;
        if (foldIndex % 2 == 1) {
            leftStartIndex = foldIndex / 2;
            rightStartIndex = leftStartIndex + 1;
        } else {
            leftStartIndex = foldIndex / 2 - 1;
            rightStartIndex = leftStartIndex + 2;
        }
        final int watchHasResult = leftStartIndex;
        final int arrayLen = array.length;
        while (leftStartIndex >= 0 && rightStartIndex < arrayLen) {
            if (array[leftStartIndex] == array[rightStartIndex]) {
                leftStartIndex--;
                rightStartIndex++;
            } else break;
        }
        if (watchHasResult == leftStartIndex) {//no result
            result[0] = 0;
            result[1] = -1;
        } else {
            leftStartIndex += 1;
            rightStartIndex -= 1;
            result[0] = leftStartIndex;
            result[1] = rightStartIndex;
        }
    }
}
