package springAU;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Assignment {
	public static void main(String[] args) throws IOException, SQLException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		out = new FileOutputStream("numbers.txt");
		in =new FileInputStream("numbers.txt");
		
		//Writing random numbers to file "numbers.txt"
		Random random = new Random();
		int num;
		do {
			num = random.nextInt(100);
			//System.out.println(num);
			out.write(num);
		} while (num%5!=0);
		
		//reading from "numbers.txt" and storing to list
		int c;
		List<Integer> ls = new ArrayList<>();
		while((c=in.read())!=-1) {
			//System.out.println(c);
			ls.add(c);
		}
		
		//Using Stream methods to fetch the result
		int res = ls.stream().filter(e -> e%5==0).map(e -> e*2).reduce(1,(a,b) -> a*b);
		//System.out.println(res);
		
		//Using InsertDB class to store the result in database
		InsertDB db = new InsertDB();
		db.insertToDB(res);
		
		out.close();
		in.close();
	}
}
