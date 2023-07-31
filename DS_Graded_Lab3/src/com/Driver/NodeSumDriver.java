package com.Driver;

import com.Services.Pairsum;

import java.util.Scanner;


public class NodeSumDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size,target;
		System.out.println("Enter array size ");
		size=sc.nextInt();
		System.out.println("Enter value of target sum ");
		target=sc.nextInt();
		int numarr[]= new int[size];
		for(int i=0;i<size;i++) {
			if((i+1)%10==1 && (i+1)%100 != 11)
				System.out.println("Enter the "+(i+1)+"st element");
			else if((i+1)%10==2 && (i+1)%100 != 12)
				System.out.println("Enter the "+(i+1)+"nd element");
			else if((i+1)%10==3 && (i+1)%100 != 13)
				System.out.println("Enter the "+(i+1)+"rd element");
			else
				System.out.println("Enter the "+(i+1)+"th element");
			
			numarr[i] =sc.nextInt();		
	}
		Pairsum.targetsum=target;
		Pairsum.arr=numarr;
		Pairsum.solve();
        sc.close();
	}

}
