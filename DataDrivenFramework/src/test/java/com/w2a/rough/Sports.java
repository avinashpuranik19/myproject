package com.w2a.rough;

public class Sports {
	
	static int qual_age=18;
	String  sporttype = "Cricket";
	int coachage =45;
	static String eligiblity;
		
	 public static String checkeligibility ()
	 {
		 
		 if (qual_age<18)
		 {
			 
			 System.out.println("not qualified");
			 eligiblity = "not qualified";
		 }
		 
		 else 
		 {
			 
			 System.out.println("qualified");
			 eligiblity = "qualified";
		 }
		return eligiblity;
		
		 
	 }

	 
	
}
