package com.example.pdsa.logic;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

public class LCSGame {
    int stringLength = 10;
    String str1, str2;
    public LCSGame(){
        str1 = generateRandomString(stringLength);
        str2 = generateRandomString(stringLength);
    }

    public Map<String, String> getStrings(){
        return Map.of("string 1", str1, "string 2", str2);
    }

    public boolean checkAnswer(String answer){
        String lcs = findLCS(str1, str2);
        String ans = answer.toUpperCase();
        return ans.equals(lcs);
    }

    private static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }

    private static String findLCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] characters = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    characters[i][j] = 0;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    characters[i][j] = characters[i - 1][j - 1] + 1;
                else
                    characters[i][j] = Math.max(characters[i - 1][j], characters[i][j - 1]);
            }
        }

        int index = characters[m][n];
        char[] lcs = new char[index];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs[--index] = str1.charAt(i - 1);
                i--;
                j--;
            } else if (characters[i - 1][j] > characters[i][j - 1])
                i--;
            else
                j--;
        }

        return new String(lcs);
    }
}
