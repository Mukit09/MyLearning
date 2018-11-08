package com.mukit.bitSet;

import java.util.BitSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		int n, m;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		BitSet b1 = new BitSet(n);
		BitSet b2 = new BitSet(n);
		
		scanner.nextLine();
		while(m-- > 0) {
			
			String[] strArray = scanner.nextLine().split(" ");
			String action = strArray[0];
			int x = Integer.parseInt(strArray[1]);
			int y = Integer.parseInt(strArray[2]);
			
			if(action.toLowerCase().equals("set")) {
				
				if(x == 1)
					b1.set(y);
				else
					b2.set(y);
			}
			else if(action.toLowerCase().equals("flip")) {
				
				if(x == 1)
					b1.flip(y);
				else
					b2.flip(y);
			}
			else if(action.toLowerCase().equals("and")) {
				
				if(x == 1)
					b1.and(b2);
				else
					b2.and(b1);
			}
			else if(action.toLowerCase().equals("or")) {
				
				if(x == 1)
					b1.or(b2);
				else
					b2.or(b1);
			}
			else if(action.toLowerCase().equals("xor")) {
				
				if(x == 1)
					b1.xor(b2);
				else
					b2.xor(b1);
			}
			System.out.println(b1.cardinality() + " " + b2.cardinality());
		}
	}
}
