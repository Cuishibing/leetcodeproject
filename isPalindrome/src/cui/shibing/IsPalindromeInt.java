package cui.shibing;

public class IsPalindromeInt {
    public static void main(String[] args) {
        System.out.printf(new IsPalindromeInt().isPalindrome(0) + "");
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        char[] array = new char[11];
        int curIndex = 0;
        while (x != 0) {
            array[curIndex++] = (char) (x % 10);
            x = x / 10;
        }
        for (int i = 0, len = curIndex; i < len / 2; i++) {
            int rightIndex = len - i - 1;
            if (i != rightIndex && array[i] != array[rightIndex]) {
                return false;
            }
        }
        return true;
    }
}
