package testGitHub;

//This program generates two integers and prompts the user to enter the sum

import java.util.Scanner;

public class test {

public static void main(String [] args) {

int number1 = (int)(Math.random() * 100);
int number2 = (int)(Math.random() * 100);

Scanner input = new Scanner(System.in);

System.out.print("What is the sum of " + number1 + " + " + number2 + " ?:");

int answer = input.nextInt();

System.out.println(number1 + " + " + number2 + " = " + answer + " is " + 
  (number1 + number2 == answer));

input.close();
}
}
