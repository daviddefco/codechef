public class Fibonacci {
    private int[] writeFibonnaci(int n) {
        int[] fibonacci = new int[n];
        for(int i=0; i<fibonacci.length; i++) {
            if(i <= 1) {
                fibonacci[i] = 1;
            } else {
                fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
            }
        }
        return fibonacci;
    }
}
