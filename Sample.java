public class Sample {

    // This is a sample method
    public static void main(String[] args) {

        System.out.println("Hello World");

        int a = 10;
        int b = 20;

        int result = add(a, b);
        System.out.println("Result: " + result);

        // loop example
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

    }

    /* This method adds two numbers */
    public static int add(int x, int y) {
        return x + y;
    }

    // another utility method
    private static void dummyMethod() {
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}