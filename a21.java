class a21{

    void CheckAge(){
        
        int age = 15;
        
        try{
            if(age<18){
                throw(new ArithmeticException);
            }
            else{
                System.out.println("all good");
            }
    }
    
    
    
}
    catch(ArithmeticException e){
        System.out.println("not eligible");
    }
    }

    public static void main(String[] args) {
        a21 obj = new a21();
        obj.CheckAge();
    }
}

    
    