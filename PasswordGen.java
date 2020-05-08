import java.util.Scanner;

public class PasswordGen{

/*Checker does exactly that, it checks.
* Its parameter will be formatted into the questions.
* It wants to know if you would like to include the arbitrary parameter.
* Then it asks how many if you say yes and returns a true boolean.
*/
  public static boolean checker(String type){
    Scanner scnr = new Scanner(System.in);
    boolean bool = false;
    System.out.printf("Would you like to use %s? (y for yes)\n", type);
    if (scnr.nextLine().equals("y")){
      System.out.printf("How many %s?\n", type);
      bool = true;
    }
    return bool;
  }

// Here's the beginning of main
  public static void main(String[] args){
    Scanner scnr = new Scanner(System.in);
    PasswordGenerator pass = new PasswordGenerator();
    int temp = 0;
    String temp1 = "";

/* First, it calls checker in an if statement.
* If checker returns true, then it will make sure that getLet() is less than or equal to zero.
* After that, it will test if getLet() is less than zero, where it will give an error message to the user.
* Then, it will take your input. If you don't provide a parsable integer, it will catch the exception and throw its own.
* It then resets the variables that may have been changed to 0 and starts from the beginning of the while loop.
* If you input an allowed integer, it will pass.
*/
    if (checker("letters")){
      while (pass.getLet() <= 0){
        if (pass.getLet() < 0)
          System.out.println("Input must be positive, please try again.");
        temp1 = scnr.nextLine();
        try{
          temp = Integer.parseInt(temp1);
        }catch (NumberFormatException e) {
          System.out.println("Invalid input, please try again.");
          temp = 0;
          pass.setLet(0);
          continue;
        }
        pass.setLet(temp);
      }

// Checks if you want capital letters
      System.out.println("Would you like to use capital letters? (y for yes)");
      String decide = scnr.nextLine();
      if (decide.toLowerCase().equals("y"))
        pass.setCaps();
    }

// This does the same as above, but with getNums() instead of getLet()
    if (checker("numbers")){
      while (pass.getNums() <= 0){
        if (pass.getNums() < 0)
          System.out.println("Input must be positive, please try again.");
        temp1 = scnr.nextLine();
        try{
          temp = Integer.parseInt(temp1);
        }catch (NumberFormatException e) {
          System.out.println("Invalid input, please try again.");
          temp = 0;
          pass.setNums(0);
          continue;
        }
        pass.setNums(temp);
      }
    }

// This does the same as above, but with special characters.
    if (checker("special characters")){
      while (pass.getSpec() <= 0){
        if (pass.getSpec() < 0)
          System.out.println("Input must be positive, please try again.");
        temp1 = scnr.nextLine();
        try{
          temp = Integer.parseInt(temp1);
        }catch (NumberFormatException e) {
          System.out.println("Invalid input, please try again.");
          temp = 0;
          pass.setSpec(0);
          continue;
        }
        pass.setSpec(temp);
      }
    }

// Now it runs generate(). Once this is complete, it prints the password created and its length.
    String password = pass.generate();
    if (pass.getLen() == 0)
      System.out.println("You must choose which kind of characters you want in your password.");
    else
      System.out.printf("%nYour password is %s.%n%nIt is %d characters long.%n", password , pass.getLen());
  }
}
