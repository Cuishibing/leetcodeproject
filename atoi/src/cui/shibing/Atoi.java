package cui.shibing;

public class Atoi {
    public static void main(String[] args) {
        System.out.println(new Atoi().myAtoi("-91283472332"));
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() < 1) {
            return 0;
        }
        char[] charArray = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        boolean isNeg = false;
        if (charArray[0] == '-') {
            i = 1;
            isNeg = true;
        } else if (charArray[0] == '+') {
            i = 1;
            isNeg = false;
        }
        for (int len = charArray.length; i < len; i++) {
            char v = charArray[i];
            if (v >= '0' && v <= '9') {
                stringBuilder.append(v);
            } else {
                break;
            }
        }
        if (stringBuilder.length() < 1) {
            return 0;
        }
        long result = 0;
        for (int j = 0, len = stringBuilder.length(); j < len; j++) {
            result = result * 10 + stringBuilder.charAt(j) - '0';
            if (result > Integer.MAX_VALUE) {
                if (!isNeg)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
        }
        if (isNeg) {
            result = -1 * result;
        }
        return (int) result;
    }
}
