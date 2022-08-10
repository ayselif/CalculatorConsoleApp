import java.util.Scanner;

public class App {
    public Integer calculate(){
        // Show Start Context and Get Selected Operator
        System.out.println("Hello, this is my calculator!");

        int result = 0;
        Boolean again = true;

        while (again = true) {
            System.out.println("To add: type a, To substract: type s, To multiply: type m, To divide: type d");
            System.out.println("Please select the operand");
            Scanner op = new Scanner(System.in);
            char operator = op.next().charAt(0);
            while ((operator!='a')&&(operator!='d')&&(operator!='m')&&(operator!='s')) {
                System.out.println("Wrong operator select! Try again!");
                Scanner sc = new Scanner(System.in);
                char newOp = sc.next().charAt(0);
                operator = newOp;
            }

            // Get Selected Operator Name
            String operatorFunction = " ";

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

            System.out.println("Now type in the first number you would like to" + " "+ operatorFunction);


            Scanner num1 = new Scanner(System.in);
            int number1 = num1.nextInt();

            Scanner num2 = new Scanner(System.in);
            System.out.println("Enter your second number");
            int number2 = num2.nextInt();


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
                    result = (Integer)(number1/number2);
            }
            System.out.println(result);

            System.out.println("if you want a new calculate press: 1, want to exit press :0");


            // Select Again
            Boolean newSelectForContinue = false;
            while (newSelectForContinue == false) {
                Scanner select = new Scanner(System.in);
                char continueSelect = select.next().charAt(0);
                if(continueSelect == 1){
                    newSelectForContinue = true;
                    again = true;
                } else if(continueSelect == 0){
                    newSelectForContinue = true;
                    again = false;
                    System.exit(0);
                } else {
                    System.out.println("Wrong select, try again");
                    newSelectForContinue = false;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        App app = new App();
        app.calculate();
    }
}
