import java.util.*;   

public class Assignment1
{
	public static void main(String[] args) 
	{
	       ArrayList<Integer> list = new ArrayList<Integer>();   
                list.add(7);   
                list.add(3);   
                list.add(1);   
                list.add(89);   
                list.add(65);   
                list.add(34);   
                list.add(97);  
                list.add(39);  
                System.out.println("Before Sorting: "+ list);   
                Collections.sort(list);   
                System.out.println("After Sorting: "+ list); 
		
	}
}