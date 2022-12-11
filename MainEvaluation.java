package APIProject;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;  
import java.util.Scanner;  
import com.google.gson.Gson;

import APIProject.ApiExce;
//import school.Student;

public class MainEvaluation {

	private static final String JSONValue = null;
	private static final Set<String> UserInputSet = null;

	public static void main(String[] args) throws IOException {
		final String path="C:\\Users\\user008\\eclipse-workspace\\EvaluationProject\\EvaluationJson.txt";
		
		ArrayList<String> douplcate=new ArrayList<>();
		//ArrayList<Student> studentEmail = new ArrayList<>();
		//ArrayList<String> emailList = new ArrayList<>();
		HashSet<String> eList = new HashSet<>();
		HashMap<String, Double> amountList = new HashMap<String, Double>();
		HashMap<String, HashMap<String, Double>> studentAmountList = new HashMap<>();
		boolean menuExit = true;
		Scanner sa = new Scanner(System.in);
		while (menuExit) {
			System.out.println("PLS SELECTE ONE OPTION:");
			System.out.println("1.READ json");
			System.out.println("2.WRITE JSON IN THE FILE");
			System.out.println("3.SEARCH FROM FILE");
			System.out.println("4.ask");
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
//				  Object obj = new JSONParser().parse(new FileReader("EvaluationJson.txt"));
//		          
//			        // typecasting obj to JSONObject
//			        ConditionObject jo = (ConditionObject) obj;
//			          
//			        // getting firstName and lastName
//			        String firstName = (String) jo.get("firstName");
//			        String lastName = (String) jo.get("lastName");
//			          
//			        System.out.println(firstName);
//			        System.out.println(lastName);
//			          
//			        // getting age
//			        long age = (long) jo.get("age");
//			        System.out.println(age);
//			          
//			        // getting address
//			        Map address = ((Map)jo.get("address"));
//			          
//			        // iterating address Map
//			        Iterator<Map.Entry> itr1 = address.entrySet().iterator();
//			        while (itr1.hasNext()) {
//			            Map.Entry pair = itr1.next();
//			            System.out.println(pair.getKey() + " : " + pair.getValue());
//			        }
//			          
//			        // getting phoneNumbers
//			        JSONArray ja = (JSONArray) jo.get("phoneNumbers");
//			          
//			        // iterating phoneNumbers
//			        Iterator itr2 = ja.iterator();
//			          
//			        while (itr2.hasNext()) 
//			        {
//			            itr1 = ((Map) itr2.next()).entrySet().iterator();
//			            while (itr1.hasNext()) {
//			                Map.Entry pair = itr1.next();
//			                System.out.println(pair.getKey() + " : " + pair.getValue());
//			            }
//			        }
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
				Scanner Scanner=new Scanner(f1);
				Path fetchFile= Paths.get(path);
				while(Scanner.hasNextLine())
				{
					Files.writeString(fetchFile, Scanner.nextLine().replaceAll("\\W", " "),StandardCharsets.UTF_8); 
				}
				     String[] words=null;  
				     FileReader fr1 = new FileReader(f1);  
				     BufferedReader br1 = new BufferedReader(fr1); 
				     String s;    
				     
				        System.out.println("PLS WRITE WHAT YOU WANT TO SEARCH?");

				     String input=sa.next();
				     Set<String> input1 = new HashSet<>();
				     input1.add(input);
				     System.out.println(input1);
				     
				   
				     int count=0;   
				     while((s=br1.readLine())!=null)   
				     {
				        words=s.split(" "); 
				       
				        for(File c: files) {
				         for (String word : words)
				         {
				                if (word.equals(input))   
				                {
				        System.out.println("The Word is : \t"+input+"\t the file is :\t "+c);
				        

					    		
					    		 
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
			case 4:
				String text="TXT";
				System.out.println("CHOICE WHAT YOU WANT PDF OF TXT");
				String txt=sa.next();
				if (txt.contains("txt")) {
					File dir1 = new File("C:\\Users\\user008\\eclipse-workspace\\EvaluationProject");
					FilenameFilter textFilter1 = new FilenameFilter() {
					           public boolean accept(File dir, String name) {
					               return name.toLowerCase().endsWith(".txt");
					           }
					       };
					       File[] files1 = dir1.listFiles(textFilter1);
					       for (File file1 : files1) {
					           if (file1.isDirectory()) {
					               System.out.print("directory:");
					           } else {
					               System.out.print("     file:");
					           }
					           System.out.println(file1.getCanonicalPath());
					       }
					       
					       Set<String> words12 = new HashSet<>();
					File f2=new File("C:\\Users\\user008\\eclipse-workspace\\EvaluationProject\\EvaluationJson.txt");
					Scanner Scanner2=new Scanner(f2);
					Path fetchFile2= Paths.get(path);
					while(Scanner2.hasNextLine())
					{
						Files.writeString(fetchFile2, Scanner2.nextLine().replaceAll("\\W", " "),StandardCharsets.UTF_8); 
					}
					     String[] words11=null;  
					     FileReader fr2 = new FileReader(f2);  
					     BufferedReader br12 = new BufferedReader(fr2); 
					     String s1;    
					     
					        System.out.println("PLS WRITE WHAT YOU WANT TO SEARCH?");

					     String input11=sa.next();
					     Set<String> input12 = new HashSet<>();
					     input12.add(input11);
					     System.out.println(input12);
					     
					   
					     int count1=0;   
					     while((s=br12.readLine())!=null)   
					     {
					        words=s.split(" "); 
					       
					        for(File c: files1) {
					         for (String word : words)
					         {
					                if (word.equals(input11))   
					                {
					        System.out.println("The Word is : \t"+input11+"\t the file is :\t "+c);
					        

						    		
						    		 
					                  count1++; 
					                  
					               
					                }
					         }
					        }
					     }
					  
					     
					     if(count1!=0)  
					    	 
					     {
					        System.out.println("The given word is present for "+count1+ " Times in the file");
					       
					     }
					     else
					     {
					        System.out.println("The given word is not present in the file");
					     }
					     
					     fr2.close();
				}else {
					File dir1 = new File("C:\\Users\\user008\\eclipse-workspace\\EvaluationProject");
					FilenameFilter textFilter1 = new FilenameFilter() {
					           public boolean accept(File dir, String name) {
					               return name.toLowerCase().endsWith(".pdf");
					           }
					       };
					       File[] files1 = dir1.listFiles(textFilter1);
					       for (File file1 : files1) {
					           if (file1.isDirectory()) {
					               System.out.print("directory:");
					           } else {
					               System.out.print("     file:");
					           }
					           System.out.println(file1.getCanonicalPath());
					       }
					       
					         
					       System.out.println("PLS WRITE WHAT YOU WANT TO SEARCH?");
						     String input11=sa.next();
						     sa.nextLine();
						     boolean word12=false;
						     int count1=0; 
						     Scanner sca2=new Scanner(new FileInputStream("sample.pdf")); 
						    
						     while(sca2.hasNextLine())
						     //File f2=new File("C:\\Users\\user008\\eclipse-workspace\\EvaluationProject\\sample.pdf");
								
								 { 
									String words11=sca2.nextLine(); 
									if (words11.indexOf(input11)!= -1) { 
										word12=true;
										count1=count1+1;
										   File file2 = new File("C:\\Users\\user008\\eclipse-workspace\\EvaluationProject");
							     	         
							  		        // renaming the file and moving it to a new location
							  		        if(file2.renameTo
							  		           (new File("C:\\")))
							  		        {
							  		            // if file copied successfully then delete the original file
							  		            file2.delete();
							  		            System.out.println("File moved successfully");
							  		        }
							  		        else
							  		        {
							  		            System.out.println("Failed to move the file");
							  		        }
									}
								 }
				}
				break;
			}

		
		
	
	}menuExit = false;
}
//						     if(word12) {
//						    	  System.out.println("The given word is present for "+count1+ " Times in the file");
//						    	  Path temp=Files.copy(Paths.get("C:\\Users\\user008\\Desktop\\sample.pdf"),Paths.get("C:\\Users\\user008\\Desktop\\pdf\\sample2.pdf"));
//						    	 if(temp!=null) {
//						    		 System.out.println("pdf file contain the word");
//						     }else {
//						    	 System.out.println("pdf file does not contain the word");
//						     }
						    	 
						    	 
						    	 
			
//								     FileReader fr2 = new FileReader(f2);  
//								     BufferedReader br12 = new BufferedReader(fr2); 
//								     String s1;  	
//								      
//								     for(File c: files1) {
//								         //for (String word : words11)
//								         {
//								                  
//								                {
//								        System.out.println("The Word is : \t"+input11+"\t the file is :\t "+c);
//								         count1++;   
//								                }
//								         }
//								        }
//								     
//								                  if(count1!=0)  
//												    	 
//												     {
//												        System.out.println("The given word is present for "+count1+ " Times in the file");
//												       
//												     }
//												     else
//												     {
//												        System.out.println("The given word is not present in the file");
//												     }
//												     
//												     fr2.close();
//								                }

									    		
									    		 
								                  
				//}
			
//								     while((s=br12.readLine())!=null)   
//								     {
//								        words=s.split(" "); 
								       
								       
								         
								        
								     
				
								
								
			
					
					
					
					
					
					
					
					
					
					
					
//					 URL url1 = new URL("https://ipinfo.io/161.185.160.93/geo");
//			
//										    byte[] ba1 = new byte[1024];
//										    int baLength;
//										    FileOutputStream fos1 = new FileOutputStream("pdf-sample.pdf");
//										    if (Desktop.isDesktopSupported()) {
//									             try {
//									                    URL url = new URL(null);
//									                    File myFile = new File(url.toURI());
//									                    Desktop.getDesktop().open(myFile);
//									            } catch (IOException | URISyntaxException ex) {
//									                        // no application registered for PDFs
//									                }
//									            }
//										    
//										    
//										    
//										    
//											try {
//												URL url = new URL("https://ipinfo.io/161.185.160.93/geo");
//												HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//												conn.setRequestMethod("GET");
//												conn.connect();
//												StringBuilder informationString = new StringBuilder();
//												int responseCode = conn.getResponseCode();
//												if (responseCode != 200) {
//													throw new RuntimeException("HttpresponseCode" + responseCode);
//					
//												} else {
//					
//													Scanner scanner = new Scanner(url.openStream());
//													while (scanner.hasNext()) {
//														informationString.append(scanner.nextLine());
//													}
//													scanner.close();
//													System.out.println(informationString);
//												}
//												FileWriter filewriter = new FileWriter("ApiInPdf.pdf");
//												filewriter.write(informationString.toString());
//												filewriter.close();
//					
//												FileReader read = new FileReader("ApiInPdf.pdf");
//												BufferedReader buffeRedreader = new BufferedReader(read);
//												String line;
//												while ((line = buffeRedreader.readLine()) != null) {
//													System.out.println(line);
//												}
//												read.close();
//					
//												System.out.println("THE FILE IS CREATE");
//												System.out.println("Successful");
//											} catch (Exception e) {
//												System.out.println(e);
//											}
				

					    
				
				
				
				
	

private static String convertFileIntoString(String string) {
	// TODO Auto-generated method stub
	return null;
}
}
