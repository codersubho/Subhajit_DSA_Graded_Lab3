package com.Services;

import java.util.Scanner;

public class Pairsum {
	static Scanner sc;
	public static Binarysearchtree bst = new Binarysearchtree();
	public static int targetsum;
	public static int arr[];
	static int verpos[];
	static int horpos[];

	public static boolean nodePair(BinaryNode temp) {
		boolean flag = false;

		if (temp == null) {
			return flag;
		}
		BinaryNode n = bst.search(targetsum - temp.data);
		if (n != null && n.data != targetsum/2) {
			System.out.println("Two such nodes in the binary search tree whose sum is " + targetsum + " are " + "("
					+ temp.data + " , " + n.data + ")");
			flag = true;
			return flag;
		}
		if (!flag) {
			flag = (nodePair(temp.left));
		}
		if (!flag) {
			flag = (nodePair(temp.right));
		}
		return flag;
	}

	static void horposFunc() {
		int len = arr.length;
		int newarr[] = new int[len];
		int i = 0;
		for (int k : arr) {
			newarr[i] = k;
			i++;
		}
		horpos = new int[len];
		merge_Sort(newarr, 0, len - 1);
		try {
			for (int j = 0; j < len; j++) {
				for (int k = 0; k < len; k++) {
					if (arr[j] == newarr[k]) {
						horpos[j] = k;
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("peyechi betake");
		}

		
	}

	static int nodeHeight(int n, BinaryNode start, int h) {
		if (start == null) {
			return -1;
		}
		BinaryNode temp = start;
		if (temp.data == n) {
			return h;
		} else {
			if (n < temp.data) {
				return nodeHeight(n, start.left, h + 1);
			} else {
				return nodeHeight(n, start.right, h + 1);
			}
		}
	}

	static void verposFunc() {
		verpos = new int[arr.length];
		try {
			for (int i = 0; i < arr.length; i++) {
				verpos[i] = nodeHeight(arr[i], bst.root, 0);
				
			}
		} catch (Exception e) {
			System.out.println("Exception dhorechi");
		}
	}

	static void display() {
		
		int height = 0;
		horposFunc();
		verposFunc();
		int idx = 0;
		
		while (idx < arr.length) {
			
			while (idx < verpos.length && verpos[idx] == height) {

				for (int id = 0; id < horpos[idx]; id++) {
					System.out.print(" ");
				}
				System.out.print(arr[idx]);
				idx++;
			}
			height++;
			System.out.println();
		}
	}

	public static void merge(int arr[], int start, int mid, int end) {
		int n1 = mid - start + 1;
		int n2 = end - mid;
		int i, j;
		int larr[] = new int[n1];
		int rarr[] = new int[n2];

		for (i = 0; i < n1; i++)
			larr[i] = arr[start + i];
		for (j = 0; j < n2; j++)
			rarr[j] = arr[mid + j + 1];
		i = j = 0;
		for (int k = start; k < start + n1 + n2; k++) {
			if (i == n1) {
				arr[k] = rarr[j];
				j += 1;
			} else if (j == n2) {
				arr[k] = larr[i];
				i += 1;
			} else if (larr[i] < rarr[j]) {
				arr[k] = larr[i];
				i += 1;

			} else {
				arr[k] = rarr[j];
				j += 1;

			}
		}
	}

	public static void merge_Sort(int arr[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			merge_Sort(arr, left, mid);
			merge_Sort(arr, mid + 1, right);
			merge(arr, left, mid, right);

		}
	}

	public static void solve() {
		boolean b = false;
		String st;
		sc = new Scanner(System.in);
		if (arr == null) {
			return;
		}
		bst.insertIntArr(arr);
		if (bst.root == null) {
			return;
		}
		System.out.println(
				"Do you want to see the diagram of the whole Binary search tree ? Type 'y' for yes and 'n' for no ");
		st = sc.next();
		if (st.equals("y") || st.equals("Y")) {
			b = true;
		} else if (st.equals("n") || st.equals("N")) {
			b = false;
		} else {
			System.out.println("Invalid character entered");
		}
		if (b) {
			 
			display();
		}

		if (!nodePair(bst.root)) {
			System.out.println("No such pair found whose sum is " + targetsum);
		}
	}
}
