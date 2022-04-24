package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperty {

	public static Properties userData =
			loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userProperties");
	
	private static Properties loadProperties(String path) {
		Properties pro = new Properties();
		
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (IOException e) {
         System.out.println("error occured : " + e.getMessage());		
}
		return pro;
				
	}
}
