import java.util.ArrayList;
import java.util.Scanner;
import p1.Contact;
import java.io.*;
class ContactList extends ArrayList<Contact> 
{
public void addContact(Contact contact) 
 {
 add(contact);
 System.out.println("contact successfully added");
}
 public void removeContact(String name) throws Exception 
 {
 for (int i = 0; i < size(); i++) 
 {
 if (get(i).getName().equals(name)) 
 {
 remove(i);
 System.out.println("contact 
successfully removed");
 return;
 }
 }
 throw new Exception("Contact not found.");
}
 
public Contact getContact(String name) throws Exception 
 {
 for (int i = 0; i < size(); i++)
 {
 if (get(i).getName().equals(name)) 
 {
 return get(i);
 }
 }
 throw new Exception("Contact not found.");
 }
 class MyThread implements Runnable
 {
String name;
int n;
Thread t;
MyThread(String fname,int i)
{ 
n=i;
name=fname; 
t=new Thread(this,"Thread"+n);
t.start();
}
public void run()
{
try
{
Reader r=new FileReader(name);
BufferedReader br=new BufferedReader(r);
String s=br.readLine();
while(s!=null)
{
System.out.println("Thread "+n+":"+s);
s=br.readLine();
Thread.sleep(1000);
}
}
catch (Exception e)
{
System.out.println(e);
}
}
 }
}
public class Main
{
public static void main(String[] args) 
 {
 Scanner scanner = new Scanner(System.in);
 ContactList contactList = new ContactList();
 System.out.println("Enter File 1 name:");
 String file1=scanner.nextLine();
 System.out.println("Enter File 2 name:");
 String file2=scanner.nextLine();
 new MyThread(file1,1);
 new MyThread(file2,2);
 
 while (true)
 {
 System.out.println("1. Add contact");
 System.out.println("2. Remove contact");
 System.out.println("3. Get contact");
 System.out.println("4. Exit");
 
 System.out.print("Enter your choice: ");
 int choice = scanner.nextInt();
 
 if (choice == 1) 
 {
 System.out.print("Enter name: ");
 String name = scanner.next();
 System.out.print("Enter phone number: 
");
 String phoneNumber = scanner.next();
 
 Contact contact = new Contact(name, 
phoneNumber);
 contactList.addContact(contact);
 }
 else if (choice == 2) 
 {
 System.out.print("Enter name: ");
 String name = scanner.next();
 try
 {
 
contactList.removeContact(name);
 } 
 catch (Exception e) 
 {
 
System.out.println(e.getMessage());
 }
 } 
 else if (choice == 3) 
 {
 System.out.print("Enter name: ");
 String name = scanner.next();
 try 
 {
 Contact contact = 
contactList.getContact(name);
 System.out.println("Name: " + 
contact.getName());
 System.out.println("Phone 
number: " + contact.getPhoneNumber());
 } 
 catch (Exception e) 
 {
 
System.out.println(e.getMessage());
 }
 }
 else if(choice==4)
{
break;
}
 }
}
}
