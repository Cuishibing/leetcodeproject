package cui.shibing;

public class ReverseInt {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
//        System.out.println((char) '0' + 0);
    }

    public static int reverse(int x) {
        StringBuilder stringBuilder = new StringBuilder(11);
        int opx = x;
        while (opx != 0) {
            stringBuilder.append(Math.abs(opx % 10));
            opx = opx / 10;
        }
        long result = 0;
        for (int i = 0, len = stringBuilder.length(); i < len; i++) {
            result += (stringBuilder.charAt(i) - 48) * Math.pow(10, len - i - 1);
        }
        if (result > Integer.MAX_VALUE)
            return 0;
        return x < 0 ? -(int) result : (int) result;
    }
}
