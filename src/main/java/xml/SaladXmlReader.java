package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import domain.Ingredient;
import domain.Salad;


public class SaladXmlReader {
	
	/**
	* method parse salad and ingredients from xml 
	* @param filename 
	* @throws FileNotFoundException
	*/
	public static List<Salad> read(String fileName) throws FileNotFoundException {
		XMLStreamReader reader = null;
		try {
			List<Salad> salads = new ArrayList<Salad>();
			List<Ingredient> ingredients = new ArrayList<Ingredient>();
			Salad salad = null;
			Ingredient ingredient = null;
			XMLInputFactory factory = XMLInputFactory.newFactory();
			reader = factory.createXMLStreamReader(new FileInputStream(fileName));
			while(reader.hasNext()) {
				int type = reader.next();
				switch(type) {
					case XMLStreamConstants.START_ELEMENT: {
						String tagName = reader.getLocalName();
						if("salad".equals(tagName)) {
							salad = new Salad();
							ingredient = new Ingredient();
						} else if("name".equals(tagName)) {
							salad.setName(reader.getElementText());
							System.out.println(salad.getName());
							salads.add(salad);
						} else if("name_ingredient".equals(tagName)) {
							ingredient.setName(reader.getElementText());
							System.out.println(ingredient.getName());
							ingredients.add(ingredient);
						} else if("weight".equals(tagName)) {
							ingredient.setWeight(Double.parseDouble(reader.getElementText()));
							System.out.println(ingredient.getWeight() + " grams");
						} else if("calory".equals(tagName)) {
							ingredient.setCalory(Integer.parseInt(reader.getElementText()));
							System.out.println(ingredient.getCalory() + " calories");
						} 		
					}				
					break;				
					case XMLStreamConstants.END_ELEMENT: {
						String tagName = reader.getLocalName();
						if("Salad".equals(tagName)) {
							salads.add(salad);
						}
						break;				
					}			
				}
			}
			return salads;
		} catch (XMLStreamException e) {
			return null;
		} finally {
			try {
				reader.close();
			} catch(Exception e) {}
		}
	}
}