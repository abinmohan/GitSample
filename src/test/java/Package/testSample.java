package Package;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		dataDriven data = new dataDriven();
		ArrayList<String> d= data.getdata("Delete profile");
		System.out.println(d.get(0));
		System.out.println(d.get(1));
		System.out.println(d.get(2));
		System.out.println(d.get(3));
		System.out.println("branch");
		 
	}

}
