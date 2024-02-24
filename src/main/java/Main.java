import java.util.Objects;
import java.util.Scanner;

public class Main {
    // adding comments to try and force a push
    
    private static boolean validInput(String arg) {
        return Objects.equals(arg, "add") || Objects.equals(arg, "subtract")
                || Objects.equals(arg, "multiply") || Objects.equals(arg, "binary")
                || Objects.equals(arg, "divide") || Objects.equals(arg, "ID") || Objects.equals(arg, "fib");
    }
    
    private static boolean whichInputs(String arg) {
        return Objects.equals(arg, "add") || Objects.equals(arg, "subtract")
                || Objects.equals(arg, "multiply") || Objects.equals(arg, "divide")
                || Objects.equals(arg, "fib");
    }
    
    private static boolean numberOfInputs(String arg) {
        return Objects.equals(arg, "add") || Objects.equals(arg, "subtract")
                || Objects.equals(arg, "multiply") || Objects.equals(arg, "divide");
    }
    
    private static void args() {
        System.out.println("please provide a command such as add, subtract, multiply, divide, binary, ID, or fib" +
                " followed by an appropriate number of numbers");
    }
    
    private static int computeInts(String[] args) {
        String arg = args[0];
        Calculator calc = new Calculator();
        if (Objects.equals(arg, "add")) {
            return calc.add(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        } else if (Objects.equals(arg, "subtract")) {
            return calc.subtract(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        } else if (Objects.equals(arg, "multiply")) {
            return calc.multiply(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        } else if (Objects.equals(arg, "divide")) {
            return calc.divide(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        } else {
            return calc.fibonacciNumberFinder(Integer.parseInt(args[1]));
        }
    }
    
    private static String computeStrings(String[] args) {
        String arg = args[0];
        Calculator calc = new Calculator();
        if (Objects.equals(arg, "binary")) {
            return calc.intToBinaryNumber(Integer.parseInt(args[1]));
        } else {
            return calc.createUniqueID(args[1]);
        }
    }
    
    public static void main(String[] args) {
//        System.out.println("Testing Dockerfile");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String[] operations = {scanner.next(), scanner.next(), null};
            if (numberOfInputs(operations[0])) {
                operations[2] = scanner.next();
            }
            if (validInput(operations[0])) {
                if (whichInputs(operations[0])) {
                    System.out.println(computeInts(operations));
                } else {
                    System.out.println(computeStrings(operations));
                }
            } else {
                args();
            }
        }
    }
}
