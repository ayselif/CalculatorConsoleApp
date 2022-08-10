import java.util.Scanner;

public class App {

    String CONFIRM = "yes";
    String REJECT = "no";
    String WRONGSELECTMESSAGE = "Wrong select, try again";

    private void showStartMessage() {
        System.out.println("Hello, this is my calculator!");
    }

    public void start(){
        this.showStartMessage();

        char operator = getTargetOperator();
        System.out.println("Now type in the first number you would like to" + " "+ getNameOfOperator(operator));
        double number1 = getTargetNumber();
        System.out.println("Enter your second number");
        double number2 = getTargetNumber();
        double result = getCalculateResult(number1, number2, operator);
        System.out.println(result);

        System.out.println("if you want a new calculate press: " + CONFIRM + ", want to exit press :" + REJECT);

        if (isContinue()) {
            start();
        }
    }
    
    private char getTargetOperator() {
        System.out.println("To add: type a, To substract: type s, To multiply: type m, To divide: type d");
        System.out.println("Please select the operand");
        Scanner scanner = new Scanner(System.in);
        char operator = scanner.next().charAt(0);
        if ((operator!='a') && (operator!='d') && (operator!='m') && (operator!='s')) {
            System.out.println(WRONGSELECTMESSAGE);
            operator = getTargetOperator();
        }

        return operator;
    }

    private double getTargetNumber(){
        Scanner scanner = new Scanner(System.in);
        double number;

        if(scanner.hasNextDouble()){
            number = scanner.nextDouble();
        } else {
            System.out.println(WRONGSELECTMESSAGE);
            number = getTargetNumber();
        }
        return number;
    }

    private String getNameOfOperator(char operator){
        String operatorFunction = "";

        switch (operator) {
            case 'a':
                operatorFunction = "add";
                break;
            case 'd' :
                operatorFunction = "divide";
                break;
            case 'm' :
                operatorFunction = "multiply";
                break;
            case 's' :
                operatorFunction = "substract";
                break;
        }
        return operatorFunction;
    }

    private double getCalculateResult(double number1, double number2, char operator){
        double result = 0;

        switch (operator) {
            case 'a' :
                result = number1+number2;
                break;
            case 's' :
                result = number1 - number2;
                break;
            case 'm' :
                result = number1 * number2;
                break;
            case 'd':
                result = number1/number2;
        }
        return result;
    }

    private boolean isContinue(){
        Scanner select = new Scanner(System.in);
        String isContinue = select.nextLine().toLowerCase();
        boolean result = false;

        if(isContinue.equals(CONFIRM)){
            result = true;
        } else if(isContinue.equals(REJECT)){
            result = false;
        } else {
            System.out.println(WRONGSELECTMESSAGE);
            result = isContinue();
        }

        return result;
    }

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }
}
