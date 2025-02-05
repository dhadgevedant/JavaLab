//Sum of digits in a number
class a7{

	public static void main(String []args){
		
		int sum = 0, num = 12345, n = num;
			
		while(num>0){

			sum += num%10;
			num/=10;
		}
		
		System.out.println("Sum of digits of " + n + " = " + sum);
	
	}

}

