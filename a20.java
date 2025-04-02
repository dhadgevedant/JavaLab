//errorrs
/*
        In this code:
        1. ArithmeticException is handled in the first try-catch block.
        2. ArrayIndexOutOfBoundsException is handled in the second try-catch block.
        3. Compile-time and Syntax errors are commented out as they are not handled by try-catch blocks.
*/

class a20 {

    public static void main(String[] args) {
        // Exception Handling (Runtime Error)
        try {
            int data = 100 / 0; // May throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e.getMessage());
        }

        // Compile-time Error 
        
        // int x = 10  // This line would cause a compile-time error
        // System.out.println(x);

        // Syntax Error (Example - incorrect syntax)
        // if (a > b) // This line would cause a syntax error if 'a' and 'b' are not defined
        // System.out.println("a is greater");

        int x = 10;
        int y = 20;
        if (x < y) {
            System.out.println("x is less than y");
        }  
        
        try{
            int[] arr = new int[5];
            System.out.println(arr[10]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out Of Bounds Exception: " + e.getMessage());
        }
    }
}

