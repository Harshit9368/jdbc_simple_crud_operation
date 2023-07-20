package PrintProgram;
	import java.util.Scanner;
	class Print{
	public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the range");
	int n=sc.nextInt();
	for(int i=2;i<=n;i++)
	{
	printPrime(i);
	}
	}
	public static void printPrime(int n)
	{
	int count=0;
	for(int i=2;i<=n/2;i++)
	{
	if(n%i==0)
	{
	count++;
	}
	}
	if(count==0)
	{
	System.out.println(n);
	}
	}
	
}
