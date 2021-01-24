class Assignment2
{ 
    static void test() throws ArithmeticException
    { 
        System.out.println("Inside test(). "); 
        throw new ArithmeticException("Explicitly throwing exception"); 
    } 
    public static void main(String args[]) 
    { 
        try
        { 
            test(); 
        } 
        catch(ArithmeticException e) 
        { 
            System.out.println("Caught in main."); 
            System.out.println(e.getMessage());

        } 
    } 
} 