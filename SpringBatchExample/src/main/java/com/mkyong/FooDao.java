package com.mkyong;

public class FooDao {
	
	public void updateFoo() {
		System.out.println("#################################");
		System.out.println("#################################");
		System.out.println("#################################");
		System.out.println("#################################");		
	}
	
	public void updateFoo2() throws Exception{
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		if (1 == 1) throw new Exception("erro");
	}
	
	public void updateFoo3(){
		System.out.println("+++++++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++++++");
	}


}
