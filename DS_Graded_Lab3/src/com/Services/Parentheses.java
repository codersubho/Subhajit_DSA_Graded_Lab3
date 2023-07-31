package com.Services;

import java.util.Stack;

public class Parentheses {
	private static Stack<Character> stack = new Stack<Character>();
	public static String str;

	public static void balancedParentheses() {

		int i;
		for (i = 0; i < str.length(); i++) {
			if (stack.empty() && (str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']')) {
				break;
			} else {
				if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
					stack.push(str.charAt(i));
				}
				if (str.charAt(i) == ')') {
					if (stack.peek() == '(')
						stack.pop();
					else {
						// System.out.println("Invalid");
						break;
					}
				}
				if (str.charAt(i) == '}') {
					if (stack.peek() == '{')
						stack.pop();
					else {
						// System.out.println("Invalid");
						break;
					}
				}
				if (str.charAt(i) == ']') {
					if (stack.peek() == '[')
						stack.pop();
					else {
						// System.out.println("Invalid");
						break;
					}
				}
			}

		}
		if (stack.empty() && i == str.length()) {
			System.out.println("Valid String");
		} else
			System.out.println("Invalid String");
	}

}
