package Array;
import java.util.Arrays;
import java.util.Scanner;
public class MainController {
	
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
     System.out.println("How many student objects you want to create and store");
     int size = sc.nextInt();

     Student[] st = new Student[size];
     for(int i =0; i<size-1;i++)
     {
         System.out.println("If u want to create object fill some details");
         System.out.println("Enter Id");
         int id = sc.nextInt();
         System.out.println("Enter phoneNumber");
         long phone = sc.nextLong();
         sc.nextLine();
         System.out.println("Enter name");
         String name = sc.nextLine();


        st[i] = new Student(name,id,phone);
        System.out.println("Object Created");

     }
//     System.out.println(Arrays.toString(st));
     for(int i =0; i<st.length;i++) {
    	 System.out.println("[ " + st[i].name + " , "+st[i].id +" , "+st[i].phone+ " ] ");
     }
}
}
