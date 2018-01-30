package assessmentproject2;//Names doc.
import java.util.Scanner;//Imports Scanner tool, which reads user input.
import java.util.regex.*;//Imports Regex tool
/**
 *
 * Author: Justin Michael Boon
 * Location: Edinburgh College
 * Date 12/2018 - 01/2018
 */
/*_______________________________1. Menu______________________________________*/
public class Menu {//CLASS THAT DEFINES MENU (& THE ENTIRE DOCUMENT)
    boolean exit;//a boolean automatically starts off at false. Meaning the menu is open.
                //meaning the 'exit' boolean (specified later) is false.
    public void runMenu(){//METHOD THAT RUNS THE BODY OF THE MENU
        welcomeName();
        printHeader();//does printHeader which makes header appear.(Present Header)
        while(!exit){//means: While NOT exit (boolean is false)(While menu is open)
            printMenu();//makes the menu appear below the header while !exit (Present menu options)
            int choice = getInput();//assigns name 'choice' to an integer expected from user in the getInput method descibed later.(Declare integer)
            performAction(choice);//passes choice integer to appropriate method
        }//*************I'm not sure if I should include a check for users input to be an integer here or leave it in the later document.**************
    }
            private void printHeader(){//METHOD THAT DEFINES HEADER
                System.out.println("+-------------------------------------------+");
                System.out.println("  Welcome to 1st Year Software Developement  ");
                System.out.println("       Please Choose an Option Below         ");
                System.out.println("+-------------------------------------------+");
            }
            private void printMenu(){//METHOD THAT DEFINES MENU
                System.out.println("\nPlease Make a Selection.");
                System.out.println("1. Enter your Name");
                System.out.println("2. Get a Factorial");
                System.out.println("3. Exit the Application");
            }
/*_______________________________2. Input Handling____________________________*/
    private int getInput(){//1)TAKES INPUT I++NT, 2)CHECKS IF VALID INTEGER, 3)PASSES TO PERFORMACTION
        Scanner userIntReader = new Scanner(System.in);//Creates new scanner called userIntReader. (System.in means take input from user)
        int choice = 0; //This sets the choice to 0 (which is off the menu)
        while (choice < 1 || choice > 3)//Will do this by default, since default is 0
        {
            try {//tries below operation (parseInt)before passing input to performAction.
                System.out.print("\nEnter your Selection:");//prints this by default (0) and if selection is in integer greater than 3.
                choice = Integer.parseInt(userIntReader.nextLine());//reads (parses) the int
            }
            catch(NumberFormatException notNumber) {//Catches non-number and throws exception.
                System.out.println("That's not a number, pal. Please try again.");//Exception.
            }
        }
        return choice;//returns choice to next method only if it's an int between 1-3
         }
    private void performAction(int choice){//PERFORMS 1 OF 4 ACTIONS
        //String newName;
        switch(choice){//passes choice int
            case 3:
                exit = true;//boolean changes, stops Menu class running.
                System.out.println("\nThank you for using my program!\n");
                break;
            case 2://calls factorial method
                System.out.println("\nEnter an integer between 1 and 10,000 to calculate its factorial");//prints instructions to user.
                Scanner userinput = new Scanner(System.in);//prompts user for input, names that input 'userint'
                int n = userinput.nextInt();//assigns 'n' a value equal to 'userint'
                FactorialCall(n);//passes to FactorialCall
                displayFactorial(n);//passes to displayFactorial
                break;
            case 1://calls name method
                NameCall();
                break;
            default://should never occur.
                System.out.println("An unknown error has occured. But if I did this right, you will NEVER SEE THIS MESSAGE.");
        }
    }
/*_______________________________3. Functions_________________________________*/
    //Welcome Message Name Function
    private void welcomeName()//Declares method
    {
        Scanner namePrompt=new Scanner(System.in);//scanner initializes and asks name on initialize menu
        String newName;
        System.out.println("Welcome to my program! To start, please enter your name:");//prompts for name before displaying menu
        newName=namePrompt.next();
            if(!newName.matches("^[a-zA-Z]+ [a-zA-Z]+$"))//<----------------------------------------------------IT'S HERE COLIN------------------------------>
            {
                System.out.print("Please re-enter your name using only letters and spaces.\n");
                welcomeName();
            }else{
                System.out.print("Thank you, "+newName+"\n");
                    }       
    }
    //Name function
    private void NameCall()//Declares method
    {
       Scanner inputName=new Scanner(System.in);//new scanner asks for user input
       String firstName, lastName;//declares that there will be 2 strings, names them
       System.out.print("Enter your first and last name: ");//prints instructions for user
       firstName=inputName.next();//assigns first string to first name
       char firstInitial = firstName.charAt(0);
       lastName=inputName.next();//assigns second string to last name
       String fullName;//declares new string
       fullName=firstInitial+" "+lastName;//defines new string as combination of previous 2 strings.
       {
        if(!fullName.matches("[a-zA-Z ]+[a-zA-Z ]"))
            {
                System.out.print("Please re-enter your name using only letters and spaces.\n");
                NameCall();
            }else{       
                System.out.print("Hello there, " + fullName + "!");//prints message combining both strings.
            }
    }
    }
    //Factorial calculation function
    private int FactorialCall(int n) //Defines method, passes userinput value 'n' from menu
    {
        int c, fact = 1;//Declares 2 integers: c (undefined), and fact (defined). Sets fact value to 1.
        if (n>=0)//which it will be as it was checked in getInput
        {//if user number 'n' is greater than or equal to 0, do the following
            for(c = 1;c <= n;c++)//assigns c a value of 1, if c is less than or equal to 'n' user input, run operation. After operation is run, increment c and repeat operation.
            { fact = fact*c; }//reassigns fact to fact * c, which is incrimented until c is more than n.
        } else {
            System.out.println("You must enter a number greater than zero.");
        }
        return fact;
}
    private void displayFactorial (int n){  //Describes how the factorial calculation will be displayed.
        String equationSolved =""; //declares a string 'equationSolved' assigns blank string value.
        for (int fact = n; fact >= 1; fact--)//for loop assigning fact n value, then if fact is greater or equal to 1, runs operation. Then decriments fact.
        {
                if (fact !=1)//if fact isn't 1
                {
                equationSolved=equationSolved+fact+"*";//declares string equationSolved is itself + fact (which is n) and adds a * symbol.
                }
                else
                {
                equationSolved=equationSolved+fact+" = ";//meaning, if string is 1, add an equal sign to string.
                }
        }
                equationSolved = equationSolved + this.FactorialCall(n);
                System.out.println("Your Factorial is " + equationSolved + "\n\n");
 }
}


