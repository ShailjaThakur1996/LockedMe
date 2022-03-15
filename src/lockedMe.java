
import java.util.*;
import java.io.*;
public class lockedMe{
	private ArrayList<String> options = new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	 public lockedMe() {
	    	
	    	options.add("1. Add a File");
	        options.add("2. Delete A File");
	        options.add("3. Search A File");
	        options.add("4. Write to File");
	        options.add("5. Read from File");
	        options.add("6. All files of Dir");
	        options.add("7. Return to Menu");
	        
	    }
	    
	 
	    public void Show() {
	    	System.out.println("File Options Menu");
	        for (String s : options) {
	            System.out.println(s);
	            
	        }

	    }
	    
	    public void NavigateOption(int option) {
	        
	    	switch(option) {

	            case 1: 
	                this.AddFile();
	                
	                this.Show();
	                break;
	                
	            case 2: 
	                this.DeleteFile();
	                
	                this.Show();
	                break;
	                
	            case 3: 
				try {
					this.SearchFile();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	                this.Show();
	                break;
	            
	                
	            case 4: 
	            	this.WriteFile();
	            	this.Show();
	                
	                break;
	                
	            case 5: 
	            	this.ReadFile();
	            	this.Show();
	                
	                break;
	                
	            case 6: 
	            	this.allFiles();
	            	this.Show();
	                
	                break;
	                
	            case 7: 
	            	
	            	System.exit(0);
	                
	                break;
	              
	            default:
	                System.out.println("Invalid Option");
	                break;
	                
	                
	        }

	    }


		private void allFiles() {
			System.out.println("Do you want to see the files in directory ?? Yes/No");
			String permit= sc.nextLine();
			if(permit.equalsIgnoreCase("yes")) {
			System.out.println("Enter the path to folder to search for files");
		    
		      String folderPath = sc.next();
		      File folder = new File(folderPath);
		      
		      if (folder.isDirectory()) {
		         File[] listOfFiles = folder.listFiles();
		         if (listOfFiles.length < 1)System.out.println(
		            "There is no File inside Folder");
		         else System.out.println("List of Files & Folder");
		         for (File file : listOfFiles) {
		            if(!file.isDirectory())
						try {
							System.out.println(
							   file.getCanonicalPath().toString());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		         } 
		      } 
		      else { System.out .println("There is no Folder @ given path :" + folderPath);
		}
			}
		}


		private void ReadFile() {
			 try {
				 System.out.println("Enter file name");
			      String filename = sc.next();
			      File myObj = new File(filename);
			      Scanner myReader = new Scanner(myObj);
			      while (myReader.hasNextLine()) {
			        String data = myReader.nextLine();
			        System.out.println(data);
			      }
			      myReader.close();
			    } catch (FileNotFoundException e) {
			      System.out.println("An error occurred. file not found");
			     // e.printStackTrace();
			    }
			
		}


		private void WriteFile() {
			try {
				System.out.println("Do you want to write the files in directory ?? Yes/No");
				String permit= sc.nextLine();
				if(permit.equalsIgnoreCase("yes")) {
				 System.out.println("Enter file name");
			     // String filename = sc.next();
			      FileWriter myWriter = new FileWriter(sc.nextLine(), true);
			      System.out.println("Write text to add and add ## to exit ");
			      String line="";
			    
			     do {
			    	  line = sc.nextLine();
			    	  line+="\n";
			    	  if(!line.equals("##\n"))
			      myWriter.write(line);
			    
			     }
			     while(!line.equals("##\n"));
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.\n");
			     
				
				}
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			    //e.printStackTrace();
			    }
			
		}


		private void SearchFile() throws IOException {
		      System.out.println("Enter file name");
		      String filename = sc.next();
		      File directory = new File("D:\\myproject\\lockedMe");
		      
		        // store all names with same name
		        // with/without extension
		        String[] flist = directory.list();
		        int flag = 0;
		        if (flist == null) {
		        System.out.println("Empty directory.");
		        }
		        else {
		  
		            // Linear search in the array
		            for (int i = 0; i < flist.length; i++) {
		                String filename1 = flist[i];
		                if (filename1.equalsIgnoreCase(filename)) {
		                System.out.println(filename1 + " found");
		                flag = 1;
		                }
		            }
		        }
		  
		        if (flag == 0) {
		        System.out.println("File Not Found");
		        }
		      
		   }
		
		


		private void DeleteFile() {
			System.out.println("Do you want to Delete existing file ??");
			System.out.println("Please Enter the Filename:");
            String filename=sc.nextLine();
            File file = new File(filename);
            if (file.delete()) { 
            System.out.println("Deleted the file: " + file.getName());
               
              } else {
                System.out.println("Failed to delete the file." + file + ", file was not found.");
              } 
		}


		private void AddFile() {
			System.out.println("Do you want to create new file ?? yes/No");
			String permit= sc.nextLine();
			if(permit.equalsIgnoreCase("yes")) {
			System.out.println("Please Enter the Filename:");
            String filename=sc.nextLine();
            File file = new File(filename);
            boolean result;  
            try   
            {  
            result = file.createNewFile();  
            if(result)      
            {  
            System.out.println("file created "+file.getCanonicalPath());
            System.out.println("name of the file "+file.getName());
            }  
            else  
            {  
            System.out.println("File already exist at location: "+file.getCanonicalPath());  
            }  
            }   
            catch (IOException e)   
            {  
            e.printStackTrace();    
            } 
			}
			else {
				System.out.println("you choose nothing");
				this.Show();
			}
			
		}


}
