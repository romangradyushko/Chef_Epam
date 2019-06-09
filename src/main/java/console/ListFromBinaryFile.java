package console;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ListFromBinaryFile {
	/**
	* method of deserialization 
	*/
	public static void FromFile() throws IOException, ClassNotFoundException {
		try{
		ObjectInputStream out = new ObjectInputStream(new FileInputStream(".\\src\\main\\java\\resources\\VegetablesBinary.dat"));
		Object salad = out.readObject();
		System.out.println(salad);
		out.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Sorry, but file with object not found");
		}
	}
}
