import java.util.Scanner;

/**
 * This class will demonstrates all the required implementation
 * for Project 3, binary search tree.
 * @author Alan Huang
 */
public class BinarySearchTreeDemo
{

	public static void main(String[] args)
	{
		int val;
		int total =0 ;
		String command;
		
		BinarySearchTree  myTree = new BinarySearchTree ();
		   
	    String lin;	
	        
	    System.out.println("Please enter the initial sequence of values:");     
	    
	    @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);	 
	    
	    lin=input.nextLine();	 
	    
	    String[] sarr = lin.split(" ");
	     
	    int[] array = new int[sarr.length];
	      
   
	    for(total = 0; total < sarr.length; total++) 
	    {            
	    	array[total] = Integer.parseInt(sarr[total]);	       
	    }
	       
	    for(int k=0;k<total;k++)
	    {	    	    
	    	myTree.addEntry(array[k]);	
	    }	
	    
	    	System.out.print("Pre-Order: ");	              
	    	myTree.preOrderTraversal();	       	       
	    	System.out.println();	      	       
	    	System.out.print("In-Order: ");	      	      
	    	myTree.inOrderTraverse();	      	       
	    	System.out.println();	     	      
	    	System.out.print("Post-Order: ");	      	      
	    	myTree.postOrderTraverse();	     	       	  	    	
	    	System.out.println();
	    
	      	       
	       
	    	System.out.print("Command? ");    
	    	command=input.nextLine().toUpperCase();	       
	    	String[] ar=new String[10];
	       
	    	
	    while(command.charAt(0) !='E')   
	    {	    	
	    	char co=command.charAt(0);
   	    	
	    	switch(co)
	       {
	               
	       
	       case 'I':
	                  	    	   
	    	   ar=command.split(" ");	                   	                 	    	   
	    	   val=Integer.parseInt(ar[1]);             
	    	  
	    	   if(!myTree.search(val) )
	    	   {  
	    		   myTree.addEntry(val);	                	 
	    		   System.out.print("In-Order: ");	                	
	    		   myTree.inOrderTraverse();
	    	   }
	    	   
	    	   else 
	    	   {         	   	                	  
	    		   System.out.print(val + " already exists, ignore.");	                	   		    	                  
	    	   }
	    	   break;
	                   	             	               
	       case 'D':
	                  
	    	   ar=command.split(" ");	                 
	    	   val=Integer.parseInt(ar[1]);	               
	    	   	    	   
	    	   if (myTree.search(val)) 
	    	   {
	    		   myTree.remove(val);	               
		    	   System.out.print("In-Order: ");	               
		    	   myTree.inOrderTraverse();	                     		   
	    	   } 
	    	   else 
	    	   {
	    		   System.out.print(val + " doesn't exist!");
	    		   
	    	   }	                  
	    	   break;
	               	              	            	   
	            	   	              
	       case 'H': 
	            	   	            	  
	    	   System.out.println("I Insert a value");	                    	            	 
	    	   System.out.println("D Delete a value");	                 
	    	   System.out.println("E Exit the program");	                 
	    	   System.out.print("H Display this message");	                   
	                  
	    	   break;	
	    	   
	       default:
	                               	           	       
	       }
	    	
	    	
	    	System.out.println("");   	
	    	System.out.print("Command? ");	    
	    	command=input.nextLine(); 
	  
	    }
	    	    
	    System.out.println("Thank you for using my program!"); 
	   	           
	}

}
