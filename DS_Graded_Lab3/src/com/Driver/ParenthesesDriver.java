package com.Driver;

import com.Services.Parentheses;

import java.util.Scanner;

public class ParenthesesDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("Enter input string");
		str = sc.nextLine();
		Parentheses.str = str;
		Parentheses.balancedParentheses();
		sc.close();
	}

}
