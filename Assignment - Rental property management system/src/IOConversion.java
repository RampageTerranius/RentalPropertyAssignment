//used to convert various data types to help with saving/loading files
public class IOConversion {
	public String propertyToFile(Property property) {
		String result = "";
		
		if (property != null)		
			result = property.convertToString();
		else
			System.out.println("property was null, unable to return a result");
		
		return result;
	}
		
	public String personToFile(Person person) {
		String result = "";
		
		if (person != null)
			result = person.convertToString();
		else
			System.out.println("person was null, unable to return a result");
		
		return result;
	}
}
