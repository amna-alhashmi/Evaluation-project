package APIProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;
import java.nio.file.Files;  
import java.nio.file.Paths;  
import java.util.Scanner;  
import com.google.gson.Gson;

import APIProject.ApiExce;

public class MainEvaluation {

	private static final String JSONValue = null;
	private static final Set<String> UserInputSet = null;

	public static void main(String[] args) throws IOException {
		boolean menuExit = true;
		Scanner sa = new Scanner(System.in);
		while (menuExit) {
			System.out.println("PLS SELECTE ONE OPTION:");
			System.out.println("1.READ json");
			System.out.println("2.WRITE JSON IN THE FILE");
			System.out.println("3.SEARCH FROM FILE");
			String menu = sa.next();
			int option = Integer.parseInt(menu);
			switch (option) {
			case 1:

				try {
					URL url = new URL("https://ipinfo.io/161.185.160.93/geo");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.connect();
					StringBuilder informationString = new StringBuilder();
					int responseCode = conn.getResponseCode();
					if (responseCode != 200) {
						throw new RuntimeException("HttpresponseCode" + responseCode);

					} else {

						Scanner scanner = new Scanner(url.openStream());
						while (scanner.hasNext()) {
							informationString.append(scanner.nextLine());
						}
						scanner.close();
						System.out.println(informationString);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				break;

			case 2:
				try {
					URL url = new URL("https://ipinfo.io/161.185.160.93/geo");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.connect();
					StringBuilder informationString = new StringBuilder();
					int responseCode = conn.getResponseCode();
					if (responseCode != 200) {
						throw new RuntimeException("HttpresponseCode" + responseCode);

					} else {

						Scanner scanner = new Scanner(url.openStream());
						while (scanner.hasNext()) {
							informationString.append(scanner.nextLine());
						}
						scanner.close();
						System.out.println(informationString);
					}

					FileWriter filewriter = new FileWriter("EvaluationJson.txt");
					filewriter.write(informationString.toString());
					filewriter.close();

					FileReader read = new FileReader("EvaluationJson.txt");
					BufferedReader buffeRedreader = new BufferedReader(read);
					String line;
					while ((line = buffeRedreader.readLine()) != null) {
						System.out.println(line);
					}
					read.close();

					System.out.println("THE FILE IS CREATE");
					System.out.println("Successful");

				} catch (Exception e) {
					System.out.println(e);
				}

				break;
			case 3:
			
				File dir = new File("C:\\Users\\user008\\eclipse-workspace\\EvaluationProject");
				FilenameFilter textFilter = new FilenameFilter() {
				           public boolean accept(File dir, String name) {
				               return name.toLowerCase().endsWith(".txt");
				           }
				       };
				       File[] files = dir.listFiles(textFilter);
				       for (File file1 : files) {
				           if (file1.isDirectory()) {
				               System.out.print("directory:");
				           } else {
				               System.out.print("     file:");
				           }
				           System.out.println(file1.getCanonicalPath());
				       }
				       
				       Set<String> words1 = new HashSet<>();
				File f1=new File("C:\\Users\\user008\\eclipse-workspace\\EvaluationProject\\EvaluationJson.txt");
				     String[] words=null;  
				     FileReader fr1 = new FileReader(f1);  
				     BufferedReader br1 = new BufferedReader(fr1); 
				     String s;    
				        System.out.println("PLS WRITE WHAT YOU WANT TO SEARCH?");

				     String input1=sa.next();
				     
				     if (words1.contains(input1)) {
				         System.out.println("You gave the word " + words + " twice");
				         break; // end the programm if the word exists twice
				     }
				     words1.add(input1);
				     int count=0;   
				     while((s=br1.readLine())!=null)   
				     {
				        words=s.split(" "); 
				       
				        for(File c: files) {
				         for (String word : words)
				         {
				                if (word.equals(input1))   
				                {
				        System.out.println("The Word is : \t"+input1+"\t the file is :\t "+c);

				                  count++;    

				                }
				         }
				        }
				     }
				  
				     
				     if(count!=0)  
				    	 
				     {
				        System.out.println("The given word is present for "+count+ " Times in the file");
				       
				     }
				     else
				     {
				        System.out.println("The given word is not present in the file");
				     }
				     
				     fr1.close();
				    
				
				
				
				
				
				break;
			}

		

	
	}menuExit = false;
}

private static String convertFileIntoString(String string) {
	// TODO Auto-generated method stub
	return null;
}
}
