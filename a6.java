//SUM OF 1 TO 100 ODD NUMBERS
class a6{

	public static void main(String []args){
		
		int sum = 0;
			
		for(int i=1;i<=100;i++)if(i%2 == 1)sum+=i;
		
		System.out.print("Sum of all Odd Numbers: " + sum);
		
		//for even numbers:
		//for(int i=1;i<=100;i++)if(i%2 == 0)System.out.print(i + " ");
	
	}

}
