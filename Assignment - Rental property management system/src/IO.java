import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class IO {	
	//load the file and return it as a string array
	public String[] loadFile(String fileName) {
		try {
			File file = new File(fileName);	
			List<String> result = new ArrayList<String>();
			if (file.exists()) {				
				if (file.canRead()) {						
					Scanner sc = new Scanner(file);
					
					while (sc.hasNextLine())
						result.add(sc.nextLine());
					
					sc.close();
					
					return result.toArray(new String[0]);
				}
				else
					throw new SecurityException("Unable to read file");
			}
			else
				throw new FileNotFoundException();
		}
		
		catch (SecurityException e) {
			System.out.println("Security exception encountered: " + e.getMessage());
		}
		
		catch (FileNotFoundException e) {
			System.out.println("File Not Found " + e.getMessage());
		}
		
		return null;
	}
	
	public boolean saveFile(String fileName, String[] data) {
		boolean result = true;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		if (data != null)	
		{
			try {
				fw = new FileWriter(fileName);
				bw = new BufferedWriter(fw);		
				
				for (String string : data)
					bw.write(string + "\n");
			}
			
			catch (IOException e) {
				System.out.println("IOException has occured: " + e.getMessage());
				result = false;
			}
			
			finally {
				try {
					if (bw != null)
						bw.close();
					
					if (fw != null)
						fw.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}		
			}
		}
		else
			result = false;
		
		return result;
	}
}
