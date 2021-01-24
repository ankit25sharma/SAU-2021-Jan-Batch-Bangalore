import java.util.*;   

public class Assignment1
{
	public static void main(String[] args) 
	{
	       	HashSet<Integer> hs = new HashSet<Integer>();   
                hs.add(7);   
                hs.add(3);   
                hs.add(1);   
                hs.add(89);   
                hs.add(65);   
                hs.add(34);   
                hs.add(97);  
                hs.add(39);  
                System.out.println("Before Sorting: "+ hs);
		List<Integer> ls = new ArrayList<>(hs);
                Collections.sort(ls);   
                System.out.println("After Sorting: "+ ls); 
		
	}
}
