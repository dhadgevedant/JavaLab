//function overloading 
class addr{

  
    int add(int a, int b){
    	
    	return(a+b);
    }
    
    int add(int a, int b, int c){
    
    	return(a+b+c);
    }

}

class a19
{
    public static void main(String[] args)
    {
       
        addr x = new addr();
        
        int a = x.add(10,20);
        int b = x.add(10,20,30);
        
        System.out.println("first function output: "+ a +"\nSecond function output: "+ b);
    }
}
