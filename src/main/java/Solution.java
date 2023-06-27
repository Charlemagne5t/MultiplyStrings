import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String multiply(String num1, String num2) {

        String top = "";
        String down = "";
        if (num1.length() >= num2.length()) {
            top = num1;
            down = num2;
        } else {
            top = num2;
            down = num1;
        }
        StringBuilder sb = new StringBuilder();
        List<String> listOfSubResults = new ArrayList<>();
        int memory = 0;
        for (int i = 0; i < top.length(); i++) {
            for (int j = 0; j < down.length(); j++) {
                int subResult = memory + (top.charAt(top.length() - 1 - i) - '0') * ((down.charAt(down.length() - 1 - j) - '0'));
                sb.insert(0, subResult % 10);
                memory = subResult / 10;
            }
            if (memory != 0) {
                sb.insert(0, memory);
                memory = 0;
            }
            listOfSubResults.add(appendZeroes(sb, i));
            sb.setLength(0);
        }
        String result = listOfSubResults.get(0);
        for (int i = 1; i < listOfSubResults.size(); i++) {
            result = stringSummation(result, listOfSubResults.get(i));
        }
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                return result;
            }
        }

        return "0";
    }

    private String appendZeroes(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

    private String stringSummation(String s1, String s2) {

        StringBuilder sb = new StringBuilder();
        String top = "";
        String down = "";
        if (s1.length() >= s2.length()) {
            top = s1;
            down = s2;
        } else {
            top = s2;
            down = s1;
        }
        if (top.length() - down.length() != 0) {
            int dif = top.length() - down.length();
            StringBuilder downSb = new StringBuilder(down);
            for (int i = 0; i < dif; i++) {
                downSb.insert(0, "0");
            }
            down = downSb.toString();
        }
        int memory = 0;
        int i = 0;
        for (; i < down.length(); i++) {
            int subResult = memory + (top.charAt(top.length() - 1 - i) - '0') + ((down.charAt(down.length() - 1 - i) - '0'));
            sb.insert(0, subResult % 10);
            memory = subResult / 10;
        }
        if (memory != 0) {
            sb.insert(0, memory);
        }

        return sb.toString();
    }
}
