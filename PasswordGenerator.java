import java.util.Random;

public class PasswordGenerator{

  private int len = 0;
  private int spec = 0;
  private int let = 0;
  private int nums = 0;
  private String password = "";
  private boolean caps = false;

/* I decided to create an overload here.
* If anyone ever uses this class, they can choose which they want to set and which they want to avoid.
* If you want to have a password with only letters, you do that by editing the top method here.
*/

  public void PasswordGenerator(int spec){
    this.spec = spec;
    this.let = 0;
    this.nums = 0;
  }

  public void PasswordGenerator(int spec, int let){
    this.spec = spec;
    this.let = let;
    this.nums = 0;
  }

  public void PasswordGenerator(int spec, int let, int nums){
    this.spec = spec;
    this.let = let;
    this.nums = nums;
  }

// Normal gets for the len, spec, let, and nums variables.
  public int getLen(){
    return len;
  }

  public int getSpec(){
    return spec;
  }

  public int getLet(){
    return let;
  }

  public int getNums(){
    return nums;
  }

// Normal sets for the spec, let, and nums variables.
  public void setSpec(int spec){
    this.spec = spec;
  }

  public void setLet(int let){
    this.let = let;
  }

  public void setNums(int nums){
    this.nums = nums;
  }

  public void setCaps(){
    this.caps = true;
  }

/* Here's the decide method.
* It will run a with two int parameters.
* Using those parameters, it will decide which character to add to the password randomly
* It will also make sure that we are not going over the amount of each type of character specified by the user by subtracting one from the respective variable every time they are used.
*/
  private void decide(int number, int modifier){
    String[] numbers = new String[] {"0","1","2","3","4","5","6","7","8","9"};
    String[] letters = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    String[] specials = new String[] {"~","`","!","@","$","%","^","&","*","(",")","-","_","+","=","{","}","[","]",":",";","\'","\\","|","\"","<",",",">",".","/","?"};
    Random rand = new Random();
    int randInt = modifier + rand.nextInt(number);
      if (randInt == 0){
        this.password = this.password + numbers[rand.nextInt(10)];
        this.nums--;
      }
      else if (randInt == 1){
        if (rand.nextInt(2) == 0 && caps){
          this.password = this.password + letters[rand.nextInt(25)].toUpperCase();
          this.let--;
        }
        else{
          this.password = this.password + letters[rand.nextInt(25)];
          this.let--;
        }
      }
      else if (randInt == 2 || randInt == -1){
        this.password = this.password + specials[rand.nextInt(30)];
        this.spec--;
      }
    }

/* The generate method
* This will set the len and length variable and then decide what to pass to decide.
* Once the random password is created, it returns the string.
*/
  public String generate(){
    this.len = spec + let + nums;
    int length = 0;
    while (length != this.len){
      while(this.spec !=0 && this.nums != 0 && this.let != 0){
        decide(3,0);
        length++;
      }
      while(this.spec == 0 && this.nums != 0 && this.let != 0){
        decide(2,0);
        length++;
      }
      while(this.spec !=0 && this.nums == 0 && this.let != 0){
        decide(2,1);
        length++;
      }
      while(this.spec !=0 && this.nums != 0 && this.let == 0){
        decide(2,-1);
        length++;
      }
      while(this.spec == 0 && this.nums != 0 && this.let == 0){
        decide(1,0);
        length++;
      }
      while(this.spec == 0 && this.nums == 0 && this.let != 0){
        decide(1,1);
        length++;
      }
      while(this.spec != 0 && this.nums == 0 && this.let == 0){
        decide(1,2);
        length++;
      }
    }
    String password = this.password;
    return password;
    }
}
