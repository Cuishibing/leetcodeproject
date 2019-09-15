package cui.shibing;


import java.sql.BatchUpdateException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 构建一棵树，每个节点记录当前括号使用的情况
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        final List<String> pairs = new GenerateParenthesis().solution(1);
        pairs.forEach(pair->{
            System.out.println(pair);
        });
    }

    public List<String> solution(int n) {
        return rawSolution("",n,0,0);
    }

    public List<String> rawSolution(String s, int total, int leftNum, int rightNum) {
        List<String> result = new ArrayList<>(2);

        if (leftNum < total) {
            String n = s + "(";
            result.addAll(rawSolution(n, total, leftNum + 1, rightNum));
        }
        if (rightNum < total && leftNum != rightNum) {
            String n = s + ")";
            result.addAll(rawSolution(n, total, leftNum, rightNum + 1));
        }
        if (leftNum == total && rightNum == total) {
            result.add(s);
        }
        return result;
    }

}
