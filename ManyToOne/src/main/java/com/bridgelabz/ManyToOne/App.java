package com.bridgelabz.ManyToOne;

import java.util.Scanner;

import com.bridgelabz.ManyToOne.EmployeDao;

public class App 
{
    public static void main( String[] args )
    {
    	 Scanner scanner=new Scanner(System.in);
         int choice;
         String continueLoop="y";
         while(continueLoop.equals("y"))
         {
      	   System.out.println("Enter choice \n1.Add \n2.update \n3.Delete");
             choice=scanner.nextInt();
  	       switch(choice)
  	       {
  	       case 1:
  	            EmployeDao.addEmployee();
  	       break;
  	       case 2:
  	            EmployeDao.updateEmployee();
  	       break;
  	       case 3:
  	    	   EmployeDao.deleteEmployee();
  	       break;
      	   default:
      		 System.out.println("wrong choice "); 
  	       }
  	       System.out.println("Do you want to continue[Y/N]");
  	       continueLoop=scanner.next();
         }
    }
}
