class a4{
	
	public static void main(String[] args){
		
		int a = 11;
		
		if(a%2==1)
			System.out.println("Odd");
			
		else System.out.println("Even");
		
		int year = 1920;
		
		if( year%100==0 && year%400==0){
				
				System.out.println("Leap Year");
		}
		
		else if( year%4==0){
		
				System.out.println("Leap Year"); 
		}
		else
			System.out.println("NOT Leap Year"); 

	}
}
