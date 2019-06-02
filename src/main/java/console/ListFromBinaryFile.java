package console;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ListFromBinaryFile {
	/**
	* method of deserialization 
	*/
	public static void FromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream out = new ObjectInputStream(new FileInputStream("VegetablesBinary.dat"));
		Object salad = out.readObject();
		System.out.println(salad);
		out.close();
	}
}
