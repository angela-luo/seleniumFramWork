package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

	public String firstName,lastName,email,password;
	
	public void jsonReader() throws FileNotFoundException, IOException, ParseException {
		
		String filePath=System.getProperty("user.dir")+"/src/test/java/data/Book.json";
		File srcFile = new File(filePath);
		
		JSONParser parser = new JSONParser();
		JSONArray Jarr = (JSONArray) parser.parse(new FileReader(srcFile));
		
		for(Object Jobj : Jarr) {
			JSONObject object = (JSONObject) Jobj;
			firstName= (String) object.get("firstName");
			System.out.println(firstName);
			lastName = (String) object.get("lastName");
			System.out.println(lastName);
			email= (String) object.get("email");
			System.out.println(email);
			password= (String) object.get("password");
			System.out.println(password);
		}
	}
	
	
}
