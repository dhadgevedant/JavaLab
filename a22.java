class a22 {

    static void checkAge(int age) throws ArithmeticException {
        if (age < 18) {
            throw new ArithmeticException("Not eligible for voting");
        } else {
            System.out.println("Eligible for voting");
        }
    }

    public static void main(String[] args) {
        
        // try {
        //     checkAge(15);
        // } catch (ArithmeticException e) {
        //     System.out.println("Exception caught: " + e.getMessage());
        // }
        // try {
        //     checkAge(20);
        // } catch (ArithmeticException e) {
        //     System.out.println("Exception caught: " + e.getMessage());
        // }        
        // 
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Enter your age");
        int age = sc.nextInt();
        try {
            checkAge(age);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

    }
}
