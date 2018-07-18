package io.talkinsidejava.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveInvalidParanthese {
	static ArrayList<String> result = new ArrayList<String>();
	static int max = 0;

	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		// Scanner scanner = new Scanner(System.in);
		// String str = scanner.next();
		String str = ")()()))";
		List<String> outList = removeInvalidParentheses(str);
		for (String s : outList)
			System.out.println(s);
	}

	public static List<String> removeInvalidParentheses(String inputString) {
		if (inputString == null) {
			return result;
		}
		searchForInvalidParanthese(inputString, "", 0, 0);
		if (result.size() == 0) {
			result.add("");
		}
		return result;
	}

	public static void searchForInvalidParanthese(String left, String right, int countLeft, int maxLeft) {
		if (left.length() == 0) {
			if (countLeft == 0 && right.length() != 0) {
				if (maxLeft > max) {
					max = maxLeft;
				}
				if (maxLeft == max && !result.contains(right)) {
					result.add(right);
				}
			}
			return;
		}
		if (left.charAt(0) == '(') {
			searchForInvalidParanthese(left.substring(1), right + "(", countLeft + 1, maxLeft + 1);// keep (
			searchForInvalidParanthese(left.substring(1), right, countLeft, maxLeft);// drop (
		} else if (left.charAt(0) == ')') {
			if (countLeft > 0) {
				searchForInvalidParanthese(left.substring(1), right + ")", countLeft - 1, maxLeft);
			}
			searchForInvalidParanthese(left.substring(1), right, countLeft, maxLeft);
		} else {
			searchForInvalidParanthese(left.substring(1), right + String.valueOf(left.charAt(0)), countLeft, maxLeft);
		}
	}
}
