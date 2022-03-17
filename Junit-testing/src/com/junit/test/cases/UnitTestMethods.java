package com.junit.test.cases;

public class UnitTestMethods {

	
	
	public int math(int[] number) {
		
		int sum =0;
		for(int i:number) {
			
			sum+=i;
		}
		return sum;	
	}
	
	public int sum(int a, int b) {
		int sum=0;
		sum=a+b;
		return sum;
		
		
	}
	
	public int Mul(int a,int b) {
		int mul=0;
		mul=a*b;
		return mul;
		
	}
	public int sub(int a , int b) {
		
		int sub=0;
		sub=a-b;
		return sub;
		
	}
}
