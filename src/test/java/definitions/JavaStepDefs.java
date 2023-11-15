package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class JavaStepDefs {
    @Given("I print Hello World")
    public void iPrintHelloWorld() {
        System.out.println("Hello World");
    }

    @When("I print {string}")
    public void iPrint(String text) {
        System.out.println(text);
    }

    @Given("I print strings")
    public void iPrintStrings() {
        String fName = "Tania";
        String lName = "Chakhovich";
        String myOccupation = "student";
        System.out.println("Hello. I am " + fName + " " + lName + ".");
        System.out.println("I work as a " + myOccupation + ".");
        myOccupation = "QA Engineer";
        System.out.println("I work as a " + myOccupation + ".");
    }

    @When("I print {string} and {string}")
    public void iPrintAnd(String str1, String str2) {
        System.out.println(str1 + " " + str2);
        System.out.println(str1.toLowerCase() + " " + str2.toUpperCase());
        System.out.println(str1.length() + " " + str2.length());
        System.out.println(str1.charAt(0) + " " + str2.charAt(3));
        System.out.println(str1.charAt(str1.length()-1) + " " + str2.charAt(str2.length()-1));
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.contains("iver"));
    }

    @Given("I work with numbers")
    public void iWorkWithNumbers() {
        int num1 = 15;
        int num2 = 10;
        int sum = num1+num2;
        int mod = num1%num2;
        System.out.println(num1 + "+" + num2 + "=" + sum);
        System.out.println(num1 + "%" + num2 + "=" + mod);
    }

    @And("I work with booleans")
    public void iWorkWithBooleans() {
        boolean x = true;
        System.out.println("x == " + x);


    }

    @Given("I compare {int} and {int}")
    public void iCompareAnd(int num1, int num2) {
//        System.out.println(num1>num2);
//        System.out.println(num1<num2);
//        System.out.println(num1==num2);
//        System.out.println(num1!=num2);

        if (num1>num2){
            System.out.println(num1 + " is greater than " + num2);
//        } else if (num1<num2){
//            System.out.println(num1 + " is less than " + num2);
        } else if (num1!=num2){
            System.out.println(num1 + " is not equal " + num2);
        } else {
            System.out.println(num1 + " is equal " + num2);
        }
    }

    @When("I print url for {string}")
    public void iPrintUrlFor(String url) {
        if (url.contains("google")){
            System.out.println("http://google.com");
        }else if(url.contains("yahoo")){
            System.out.println("http://yahoo.com");
        }else{
            System.out.println(url + " is not supported! Sorry!");
        }
    }

    @Given("I work with arrays")
    public void iWorkWithArrays() {
        int[] numbers = {2,34,4,56,155};
        String[] cars = {"Toyota", "Ford", "Honda", "Subaru"};
        System.out.println(cars[0]);
        cars[1]="Audi";
        System.out.println(cars[1]);
        System.out.println(cars.length);
        System.out.println(cars);

//        for (String car:  cars) {
//            System.out.print(car + " ");
//        }

        for (int counter=0; counter <cars.length; counter++){
            System.out.println(cars[counter]);
        }
    }

    @Given("I convert {int} foot to centimeters")
    public void iConvertFootToCentimeters(int num) {
        double cent = num * 30.48;
        if(num<2){
            System.out.println(num + " foot is equal to " + cent + " centimeters." );
        }else{
            System.out.println(num + " feet are equal to " + cent + " centimeters." );
        }

    }

    @When("I convert {int} US gallon to liters")
    public void iConvertUSGallonToLiters(int num) {
        double lit = num * 3.79;
        if(num<2){
            System.out.println(num + " US gallon is equal to " + lit + " liters." );
        }else{
            System.out.println(num + " US gallons are equal to " + lit + " liters." );
        }
    }

    @And("I convert {int} Celsius to Fahrenheit")
    public void iConvertCelsiusToFahrenheit(int num) {
        double far = (num * 9/5)+32;
        System.out.println(num + " Celsuis is equal to " + far + " Fahrenheit.");
    }

    @Given("I got {int} percent on my test")
    public void iGotPercentOnMyTest(int score) {
        if(score>=90 && score<=100){
            System.out.println("You passed with Grade A");
        }else if(score>=80 && score<90){
            System.out.println("You passed with Grade B");
        }else if(score>=70 && score<79){
            System.out.println("You passed with Grade C");
        }else if(score>=60 && score<69){
            System.out.println("You passed with Grade D");
        }else if(score>=0 && score <60){
            System.out.println("You passed with Grade F");
        }else{
            System.out.println("Wrong score");
        }
    }

    @Given("I print out all elements in the loop")
    public void iPrintOutAllElementsInTheLoop() {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

//        for (String item:week) {
//            System.out.println(item);
//        }
        for (int x=0; x < week.length; x++){
            System.out.print(week[x] + " ");
        }
    }

    @Given("I summarize numbers in the array")
    public void iSummarizeNumbersInTheArray() {
        int[] numbers={1,8,7,6,4,2,12,13,5,4,2,10,22};
        int sum=0;
        for (int x=0; x<numbers.length; x++){
            sum=sum+numbers[x];
        }
        System.out.println("The sum is " + sum);
    }

    @Given("I check if number {int} is even or odd")
    public void iCheckIfNumberIsEvenOrOdd(int num) {
        if(num!=0){
            if(num%2==0){
                System.out.println("Number " + num + " is even.");
            }else{
                System.out.println("Number " + num + " is odd.");
            }
        }else{
            System.out.println("Mathematical operation cannot be executed!");
        }

    }
}
