//Armstrong number
class a13{
	
	public static boolean IsArmstrong(int num){
		
		int i = num, sum=0, cur;
		
		while(i!=0){
		
			cur = i%10;
			sum+= cur*cur*cur;
			i/=10;	
		}
		
		if(sum == num) return true;
		
		return false;
	}


	public static void main(String []A){
	
		int num = 153, num2 = 123;
		
		if(IsArmstrong(num))
			System.out.println(num+" is Armstrong number");
		else
			System.out.println(num+" is Armstrong NOT number");
			
		if(IsArmstrong(num2))
			System.out.println(num2+" is Armstrong number");
		else
			System.out.println(num2+" is Armstrong NOT number");
		
	}

}
