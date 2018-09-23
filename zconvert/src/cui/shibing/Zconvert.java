package cui.shibing;

import java.util.ArrayList;
import java.util.List;

public class Zconvert {
    public static void main(String[] args) {
        String value = new Zconvert().convert("PAYPALISHIRING", 5);
        System.out.println(value);
    }

    public String convert(String s, int numRows) {
        if (numRows < 2 || s.length() <= numRows) {
            return s;
        }
        int stringLength = s.length();
        char[] charArray = s.toCharArray();
        int currentPosition = 0;
        List<StringBuilder> cols = new ArrayList<>();
        int lastColType= -1;
        while (currentPosition + numRows <= stringLength) {
            StringBuilder col1 = new StringBuilder(numRows);
            col1.append(charArray, currentPosition, numRows);
            cols.add(col1);
            lastColType = 1;
            currentPosition += numRows;
            int middleLength = numRows - 2;
            if (middleLength >= 1 && currentPosition + middleLength <= stringLength) {
                StringBuilder col2 = new StringBuilder(numRows);
                col2.append((char)0);
                col2.append(charArray, currentPosition, middleLength);
                col2.append((char)0);
                col2 = col2.reverse();
                cols.add(col2);
                currentPosition += middleLength;
                lastColType = 2;
            }
        }
        if(currentPosition < stringLength){
            StringBuilder lastCol = new StringBuilder(numRows);
            int lastColLen = stringLength - currentPosition;
            if(lastColType == 2)
                lastCol.append(charArray,currentPosition,lastColLen);
            else{
                lastCol.append((char)0);
                lastCol.append(charArray,currentPosition,lastColLen);
                int zeroCount = numRows - lastCol.length();
                for(int i=0;i<zeroCount;i++)
                    lastCol.append((char)0);
                lastCol = lastCol.reverse();
            }
            cols.add(lastCol);
        }
        StringBuilder result = new StringBuilder(stringLength);
        for(int i=0;i<numRows;i++){
            for(StringBuilder col : cols){
                if(col.length() > i && col.charAt(i) != 0){
                    result.append(col.charAt(i));
                }
            }
        }
        return result.toString();
    }
}
