//sallary and tax
class a12{

	
	public static void main(String []args){
	
		double sal = 100000, tax, inHand;
		
		tax =  (sal * 0.18);
		inHand = sal - tax;
		
		System.out.println("Sallary = " + sal + "\ntax = " + tax + "\nIn hand Sallary = " + inHand);
	}

};
