
import java.util.Scanner;

public class clientApp {
	 
	public void displaydetails() {
		

		//Application name and the developer details 
System.out.println("\n \n     ======**APPLICATION NAME**======");
System.out.println("            LockedM.com\n\n");
System.out.println(" **DEVELOPER DETAILS**");
System.out.println("  NAME: "+" Shailja ");
System.out.println("  Id: PL0122202");
System.out.println("  BATCH_NAME: PROG_JFM22_FS_JAVA_16\n\n\n");
System.out.println("TO see File Menu type Show Menu");
	}
public void sty()
{
try
{
System.out.println("\n\n  ****..WELCOME TO MAIN SCREEN..****");
Thread.sleep(800);
}
catch(Exception e)
{
}
}
public void run()
{
try
{
int i;
char []arr=new char[7];
for(i=0;i<=3;i++)
{
arr[i]='.';
System.out.print(arr[i]);
Thread.sleep(800);
}
}
catch(Exception e)
{
}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		clientApp  c1= new clientApp();
		c1.sty();
		System.out.print("\n\n"+"    Initializing ");
		c1.run();
		//System.out.print("\n\n\t\t\t\t\t"+"loading");
		//c1.run();
		System.out.print("\n\n"+"    Please Wait ");
		c1.run();
		
       c1.displaydetails();
       lockedMe l1=new lockedMe();
       System.out.print("Type here:\n");
       String menu=sc.nextLine();
      // System.out.println("click Enter or wait for some time");
       if(menu.equalsIgnoreCase("Show Menu")) {
    	   System.out.println("\n");
       l1.Show();
       System.out.println("\nEnter you option");
       for(int i=1;true;i++) {
    	   i =sc.nextInt();
        l1.NavigateOption(i);

       }
       
       }
else {
    	System.out.println("Hint: Show Menu");  
    	 System.out.print("Type here:\n"); 
    	String menu1=sc.nextLine();
    	 
         if(menu1.equals("Show Menu")) {
        	  System.out.println("\n");
         l1.Show();
         System.out.println("Enter you option");
         for(int i=1;true;i++) {
      	   i =sc.nextInt();
          l1.NavigateOption(i);
       }
 
         }}
      sc.close();
	}

}
	