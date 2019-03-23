package com.w2a.rough;

public class sportdetails {
	
	 public static void main (String[] args)
	  {
	    
		 Sports sp = new Sports  ();
		 
		 Sports coach = new Sports ();
		 
		 sportdetails.sportsmen_details(sp);
		 	 	 
	  }
	
	public static void sportsmen_details (Sports sp)
	{
		
		System.out.println(sp.qual_age);
		
		String qualifiedage = Sports.checkeligibility();
		
		System.out.println(qualifiedage);
	
		
		
	}
	 
	
	

}
