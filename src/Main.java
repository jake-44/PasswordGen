// We are creating a basic password generator
// Will update this with more complex solutions

import java.util.*;
public class Main {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String tempPass = "Pa$sw0rD";
        int mainChoice = 0;
        int length = 8;

        while(mainChoice != 3){
            mainChoice = getMainChoice();

            if(mainChoice == 1) {
                System.out.println("Here is your password utilizing the default parameters: "); // setup pass params
                System.out.println(tempPass);
                System.out.println("\nEnjoy!");
                mainChoice = 3;
            } else if(mainChoice == 2) {
                System.out.println("\n|Specify Your Parameters|");
                boolean passSet = false;
                while (!passSet){
                    int x = 8;
                    System.out.println("Set Password Length:");
                    x = scan.nextInt();
                    if(x >= 8 && x <= 20){
                        setPass(x);

                        passSet = true;
                        mainChoice = 3;
                    }else{
                        System.out.println("Your Length Must Be Between 8 and 20 Characters!");
                    }
                }
            } else if(mainChoice == 3) {
                System.out.println("\nGoodbye!");
                System.out.println(length);
            }else{
                System.out.println("\nPlease Enter Either 1, 2, or 3");
            }
        }

    }
    public static int getMainChoice(){
        displayMainMenu();
        return scan.nextInt();
    }

    public static void displayMainMenu(){
        System.out.println("\n|Password Generator|");
        System.out.println("--Make a selection--");
        System.out.println("1. Use Default Password");
        System.out.println("2. Create a New Password");
        System.out.println("3. Exit");
    }

    static void setPass(int length){

        String[] symArray = {"=", "'", "-", "!", "@", "#", "$", "%", "^", "&", "*", "+", "<", ">", "?", "/", "|", "~"};
        System.out.println("\nYour New Password is: ");
        for(int i = 0; i < length; i++) {
            Random r = new Random();
            Random s = new Random();
            int num = r.nextInt(4) + 1;

            if(num == 1){
                char passChar = (char)(s.nextInt(26) + 'a');
                System.out.print(passChar);
            }
            else if(num == 2){
                int index = s.nextInt(symArray.length);
                System.out.print(symArray[index]);
            }
            else if(num == 3){
                char passCaps = (char)(s.nextInt(26) + 'A');
                System.out.print(passCaps);
            }
            else{
                int passNum = s.nextInt(10) + 1;
                System.out.print(passNum);
            }
        }
        System.out.println();
        System.out.println("\nEnjoy!");

    }


}