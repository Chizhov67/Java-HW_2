import java.io.IOException;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    static int getSum(int a, int b) {
        return a + b;
    }

    static int getSubtraction(int a, int b) {
        return a - b;
    }

    static int getProduct(int a, int b) {
        return a * b;
    }

    static double getDivision(int a, int b) {
        return (double) a / (double) b;
    }

    static String getResultOfOperation(int a, int b, String signOperation) {
        switch (signOperation) {
            case "+":
                return String.format("%d %s %d = %d \n", a, signOperation, b, getSum(a, b));
            case "-":
                return String.format("%d %s %d = %d \n", a, signOperation, b, getSubtraction(a, b));
            case "*":
                return String.format("%d %s %d = %d \n", a, signOperation, b, getProduct(a, b));
            case "/":
                if (b != 0) {
                    return String.format("%d %s %d = %.4f \n", a, signOperation, b, getDivision(a, b));
                }
                return "ERROR: division by zero!!!";
            default:
                return "Unknown";
        }
    }

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logging.properties"));
        Logger log = Logger.getLogger(Main.class.getName());
        Scanner scn = new Scanner(System.in);
        log.info("Enter first number: ");
        int a = 0;
        if (!scn.hasNextInt()) {
            log.info("You entered wrong number!!!");
        } else {
            a = scn.nextInt();
            log.info("> " + a);
            Scanner sc = new Scanner(System.in);
            log.info("Enter sign of operation from list: +, -, *, /");
            String signOperation = "";
            if (sc.hasNextLine()) {
                signOperation = sc.nextLine();
                log.info("> " + signOperation);
            }
            if (signOperation.equals("+") || signOperation.equals("-") || signOperation.equals("*")
                    || signOperation.equals("/")) {
                int b = 0;
                log.info("Enter second number: ");
                if (!scn.hasNextInt()) {
                    log.info("You entered wrong number!!!");
                } else {
                    b = scn.nextInt();
                    log.info("> " + b);
                    log.info(getResultOfOperation(a, b, signOperation));
                }
            } else {
                log.info("You entered wrong operation!!!");
            }
            scn.close();
            sc.close();
        }
    }
}