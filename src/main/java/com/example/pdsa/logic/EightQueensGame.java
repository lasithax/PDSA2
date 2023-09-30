package com.example.pdsa.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueensGame {
    private int MAX = 10;
    private int[] arr = new int[10];
    private List<List<String>> solutions = new ArrayList<>();

    public EightQueensGame() {
        int n = 8; // Number of queens
        EightQueen(1, n);
    }

    public List<List<String>> getSolutions() {
        return solutions;
    }

    public int validate(int[] response) {
        // return 0 if response is not valid
        // return index of solution if response is valid
        if(response.length != 8) {
            return 0;
        }

        //iterate through each solution in list of solutions
        for (List<String> solution : solutions) {
            //iterate through each position in solution and extract row values into array
            int[] positionRows = new int[8];
            for(int i = 0; i < 8; i++) {
                String position = solution.get(i);
                positionRows[i] = Integer.parseInt(position.substring(1)) - 1;
            }

            if(Arrays.equals(positionRows, response)) {
                return solutions.indexOf(solution) + 1;
            }
        }

        return 0;
    }

    // Recursive function to solve the Eight Queens Puzzle
    private void EightQueen(int k, int n) {
        for (int i = 1; i <= n; i++) {
            if (canPlace(k, i)) {
                arr[k] = i; // Place a queen in row 'k' and column 'i'
                if (k == n) {
                    storeSolution(n); // If all queens are placed, store the solution
                } else {
                    EightQueen(k + 1, n); // Move on to place the next queen
                }
            }
        }
    }

    // Helper function to check if it's safe to place a queen at row 'k' and column 'i'
    private boolean canPlace(int k, int i) {
        for (int j = 1; j <= k - 1; j++) {
            // Queens can attack each other if they are in the same row or diagonal
            if (arr[j] == i || (Math.abs(arr[j] - i) == Math.abs(j - k))) {
                return false;
            }
        }
        return true; // It's safe to place a queen at row 'k' and column 'i'
    }

    private void storeSolution(int n) {
        List<String> solution = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String position = "";
            char columnLabel = (char) ('A' + i - 1); // Convert column index to letter label
            position = String.valueOf(columnLabel) + arr[i];
            solution.add(position); // Add the position to the list
        }

        solutions.add(solution); // Add the solution to the list of solutions
    }


}
