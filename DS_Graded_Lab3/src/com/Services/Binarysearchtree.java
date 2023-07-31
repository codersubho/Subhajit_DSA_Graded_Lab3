package com.Services;

public class Binarysearchtree {
	BinaryNode root;
	void insert(int data) {
		BinaryNode n = new BinaryNode(data);
		if (root == null) {
			root = n;
			return;
		}
		BinaryNode temp = root;
		do {
			if (data == temp.data) {
				System.out.println("Data already present");
				break;

			} else {
				if (data < temp.data) {
					if (temp.left != null) {
						//temp.pos++;
						temp = temp.left;
						;
					} else {
						temp.left = n;
						break;
					}
				} else {
					if (temp.right != null) {
						temp = temp.right;
					} else {
						temp.right = n;
						break;
					}
				}
			}
		} while (true);
		
	}

	void insertIntArr(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			insert(arr[i]);
		}
	}

	BinaryNode search(int data) {
		
		if (root == null) {
			System.out.println("Empty Binary Search tree");
			return root;
		}
		BinaryNode temp = root;
		while (temp != null) {
			if (data == temp.data) {
				return temp;
			} else if (data < temp.data) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}

		}
		return temp;
	}

	void display_Traverse(boolean flag,BinaryNode n) {
		if (root == null) {
			System.out.println("Empty Binary Search tree");
			return;
		}
		if(n==null) {
			return;
		}
		if(flag) {
			System.out.println(n.data);
		}
		if(flag && n.left!=null) {
			System.out.print("/");
			System.out.print(" ");
		}
		if(flag && n.right!=null) {
			System.out.println("\\");
		}
		System.out.print(n.left.data+"   ");
		display_Traverse(flag,n.left);
		display_Traverse(flag,n.right);

	}

}

