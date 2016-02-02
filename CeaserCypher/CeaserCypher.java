
/**
 * Write a description of class CeaserCypher here.
 * Program to encrypt and decrypt simple ceaser cyphers by trial and error
 * 
 * @author (Martin Wallace) 
 * @version 1
 */
import java.util.Scanner;
import java.util.Random;
public class CeaserCypher{
    char [] alphabet =       {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
   public static void main(String[]args){
       CeaserCypher CeaserCypherInstance = new CeaserCypher();
       CeaserCypherInstance.mainLoop();
    }
    public void mainLoop() {
          Scanner input = new Scanner(System.in);
             Random ran = new Random();
          
          int userChoice=1;
          while(userChoice !=4){
              System.out.println("****************************************");
          System.out.println("Welcome to Marty's Ceaser Cypher program.");
          System.out.println("Please select one of the following options:");
          System.out.println("Press 1 to encrypt or decrypt a code using your own settings");
          System.out.println("Press 2 to decrypt a code using trial and error");
          System.out.println("Press 3 to encrypt a code using a randomly generated number");
          System.out.println("Press 4 to exit");
          
          userChoice = input.nextInt();
          switch(userChoice){
              case 1:
                System.out.println("You have selected 1");
                
                String userSentence = userString();
                int userShift = userLetterShift();
                encrypt(userSentence,userShift);
                break;
              case 2:
                int userNumber = -1;
                System.out.println("You have selected 2");
                String tNE = userString();
                System.out.println("Enter 1 to shift right 1 letter. Enter 0 to stop");
                int count = 0;
                    while (userNumber != 0){
                        int shift = input.nextInt();
                        if ( shift == 0){
                            break;
                        }
                        count+=shift;
                        count=count%26;
                        if (count >= 0){
                        System.out.print("Currently displaying " + count + " shifts to the right: ");
                        encrypt(tNE, count);
                    }
                }
                    break;
                
              case 3:
                    int random = ran.nextInt(26);
                    String randomSentence = userString();
                    encrypt(randomSentence, random);
              
                break;
                
              case 4:
                System.out.println("You have selected 4. Thanks for using Marty's Ceaser Cypher!");
                System.exit(0);
              
            }
      } // end of while loop to keep bringing you backk to the menu
    } // end of mainloop
      
      public static void encrypt(String userSentence, int letterShift){
        char [] alphabet =       {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Scanner input = new Scanner(System.in);
        userSentence = userSentence.toLowerCase();
        char [] userArray = userSentence.toCharArray();
        
        for(int i=0; i<userSentence.length();i++){
            int numletter=0;
             
             
             if(userArray[i]==' '){
                 System.out.print(' ');
                 continue;
                }
               numletter=letterToNumber(userArray[i]);
               
             numletter=letterShift + numletter;
             if (numletter < 0){
                numletter = 26+numletter;
                }
             if (numletter > 25){
                 numletter = numletter % 26;
                }
            userArray[i] = alphabet[numletter];
            System.out.print(userArray[i]);
        }
        System.out.println();
        
        }
            public static int letterToNumber(char letter) {
        int numletter=0;
        switch (letter){
            
            case 'a':
                numletter=0;
                break;
            case 'b':
                numletter=1;
                break;
            case 'c':
                numletter=2;
                break;    
            case 'd':
                numletter=3;
                break;
            case 'e':
                numletter=4;
                break;
            case 'f':
                numletter=5;
                break;
            case 'g':
                numletter=6;
                break;
            case 'h':
                numletter=7;
                break;
            case 'i':
                numletter=8;
                break;
            case 'j':
                numletter=9;
                break;
            case 'k':
                numletter=10;
                break;
            case 'l':
                numletter=11;
                break;
            case 'm':
                numletter=12;
                break;
            case 'n':
                numletter=13;
                break;
            case 'o':
                numletter=14;
                break;
            case 'p':
                numletter=15;
                break;
            case 'q':
                numletter=16;
                break;
            case 'r':
                numletter=17;
                break;
            case 's':
                numletter=18;
                break;
            case 't':
                numletter=19;
                break;
            case 'u':
                numletter=20;
                break;
            case 'v':
                numletter=21;
                break;
            case 'w':
                numletter=22;
                break;
            case 'x':
                numletter=23;
                break;
            case 'y':
                numletter=24;
                break;
            case 'z':
                numletter=25;
                break;

            }
            return numletter;
    }
    public static String userString(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the words you would like to use: ");
        String userSentence = input.nextLine();
       
        return userSentence;
    }
    public static int userLetterShift (){
    Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of shifts you would like to apply.");
        System.out.println("Use positive numbers to shift right negative numbers to shift left");
        int userNumber = input.nextInt();
        return userNumber;
    }
}
    
          