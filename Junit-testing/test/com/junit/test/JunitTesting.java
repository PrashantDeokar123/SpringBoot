package com.junit.test;

import org.junit.Before;

import static org.junit.Assert.*;
import org.junit.Test;

import com.junit.test.cases.UnitTestMethods;


public class JunitTesting {

	UnitTestMethods test=new UnitTestMethods();
	
	@Before
	public void before() {
		System.out.println("Before");
	}
	
	@Test
	public void math() {
		System.out.println("Test 1");
		int total=test.math(new int[] {1,3,4,5});
		assertEquals(13,total);
		
	}
	
	@Test
	public void test() {
		System.out.println("Test 2");
		int sum =test.sum(12, 12);
		assertEquals(24,sum);
		
	}
	
	@Test
	public void test1() {
		System.out.println("Test 3");
		int mul=test.Mul(4,2);
		assertEquals(8,mul);
	}
	
	@Test
	public void test2() {
		System.out.println("Test 4");
		int sub=test.sub(15,5);
		assertEquals(10,sub);
		
		
	}


	

}
