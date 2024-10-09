import java.util.*;

public class StringGames {

    public static String bestCharacters(String s1, String s2) {
        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException("The length of the strings must be equal");
        }

        int lowerS1 = 0, upperS1 = 0, digitS1 = 0;
        int lowerS2 = 0, upperS2 = 0, digitS2 = 0;

        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (Character.isLowerCase(ch1)) lowerS1++;
            if (Character.isUpperCase(ch1)) upperS1++;
            if (Character.isDigit(ch1)) digitS1++;

            if (Character.isLowerCase(ch2)) lowerS2++;
            if (Character.isUpperCase(ch2)) upperS2++;
            if (Character.isDigit(ch2)) digitS2++;
        }

        int winsS1 = 0, winsS2 = 0;

        if (lowerS1 > lowerS2) winsS1++;
        else if (lowerS2 > lowerS1) winsS2++;

        if (upperS1 > upperS2) winsS1++;
        else if (upperS2 > upperS1) winsS2++;

        if (digitS1 > digitS2) winsS1++;
        else if (digitS2 > digitS1) winsS2++;

        return winsS1 >= winsS2 ? s1 : s2;
    }

    public static int crossingWords(String s1, String s2){
        int sum = 0;

        for(int j = 0; j < s1.length(); j++){
            for (int i = 0; i < s2.length(); i++){
                if (s1.charAt(j) == s2.charAt(i)){
                    sum += 1;
                }
            }
        }


        return sum;
    }

    public static String wackyAlphabet(String s1, String s2) {
        if (s2.length() != 26 || !isAllLetters(s2) || hasDuplicates(s2)) {
            throw new IllegalArgumentException("Invalid alphabet order string");
        }
        int[] numberLetters = new int[128];
        for (int i = 0; i < s2.length(); i++) {
            numberLetters[s2.charAt(i)] = i;
        }

        char[] s1Chars = s1.toCharArray();

        for (int i = 0; i < s1Chars.length - 1; i++) {
            for (int j = i + 1; j < s1Chars.length; j++) {
                if (numberLetters[s1Chars[i]] > numberLetters[s1Chars[j]]) {
                    char temp = s1Chars[i];
                    s1Chars[i] = s1Chars[j];
                    s1Chars[j] = temp;
                }
            }
        }

        StringBuilder sortedString = new StringBuilder(s1Chars.length);
        for (char c : s1Chars) {
            sortedString.append(c);
        }

        return sortedString.toString();
    }

    private static boolean isAllLetters(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasDuplicates(String s) {
        boolean[] seen = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c]) {
                return true;
            }
            seen[c] = true;
        }
        return false;
    }

}