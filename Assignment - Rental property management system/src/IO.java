import java.io.*;


public class IO {
	public File loadFile(String fileName) {
		try {
			File result = new File(fileName);
			if (result.exists()) {
				if (result.canRead()) {						
					
				}
				else
					System.out.println("File '" + fileName + "' can not be written to");
			}
			else
				System.out.println("File '" + fileName + "' does not exist");
		}
		
		catch (SecurityException e) {
			
		}
		
		return null;
	}
}
