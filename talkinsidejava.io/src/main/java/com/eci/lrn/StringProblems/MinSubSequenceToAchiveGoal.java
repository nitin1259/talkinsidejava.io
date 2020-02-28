package com.eci.lrn.StringProblems;

import java.util.Stack;

public class MinSubSequenceToAchiveGoal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static int maximalRectangle(String[][] matrix) {
        //Sanity check
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        for (int j = 0; j < n; j++) {
            heights[j] = "1".equals(matrix[0][j]) ? 1 : 0;
        }
        int max = getMax(heights);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] =  "0".equals(matrix[i][j]) ? 0 : heights[j] + 1;
            }
            max = Math.max(max, getMax(heights));
        }
        return max;
    }
    
    private static int getMax(int[] heights){
        int i = 0, n = heights.length, max = 0;
        Stack<Integer> s = new Stack<>();
        while (i < n) {
            while (!s.empty() && heights[i] < heights[s.peek()]) {
                max = Math.max(max, heights[s.pop()] * (i - (s.empty() ? 0 : s.peek() + 1)));
            }
            s.push(i++);
        }
        while (!s.empty()) {
            max = Math.max(max, heights[s.pop()] * (n - (s.empty() ? 0 : s.peek() + 1)));
        }
        return max;
    }
}
