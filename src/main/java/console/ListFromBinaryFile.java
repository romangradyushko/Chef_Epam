package console;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ListFromBinaryFile {
	/**
	* method of deserialization 
	*/
	public static void fromFile() throws IOException, ClassNotFoundException {
		ObjectInputStream out = null;
		try{
		out = new ObjectInputStream(new FileInputStream(".\\src\\main\\resources\\VegetablesBinary.dat"));
		Object salad = out.readObject();
		System.out.println(salad);
		}
		catch(FileNotFoundException e) {
			System.out.println("Sorry, but file with object not found");
		}
		finally {
			out.close();
		}
	}
}
