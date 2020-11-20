import java.util.*;
public class StateTester {
    
    public static void main(String[]args){
        State q0 = new State(0); // State q0 will be initial state and accepts 0 to go next
        // 0 at q0 pushes a #
        State q1 = new State(0); // State q1 accepts 0 to go next
        // 0 at q1 pushes a #
        State q2 = new State(1); // State q2 accepts 1 to go next
        // 1 at q2 pops a #
        State q3 = new State(1); // State q3 will loop back to itself and be accept state and accepts 1 to loop back
        // 1 at q2 pops a #
        q0.curr = true; // Set current state
        q1.curr = false;
        q2.curr = false;
        q3.curr = false;
        Stack myStack = new Stack(); // initialize stack
        ArrayList<Integer> inputArray = new ArrayList <>(); // create an ArrayList to store string
        boolean validString; // initialize validString
        Scanner input = new Scanner(System.in);
        int flag = 1; // input from keyboard
        while(flag != 2){ // keep track of current state
            if(q0.curr){
                System.out.println("Current state: q0");
            } else if(q1.curr){
                System.out.println("Current state: q1");
            } else if(q2.curr){
                System.out.println("Current state: q2");
            }
            else{
                System.out.println("Current state: q3");
            }
            System.out.println("Enter 0 or 1 to change state...2 to stop");
            flag = input.nextInt();
           
            inputArray.add(flag);
            switch(flag){ // update current state or go to isValid function
                case 1:
                    if(q0.curr){
                        validString = false;
                        isValid(validString, inputArray, myStack);
                        break;
                    }
                    if(q1.curr){
                        validString = false;
                        isValid(validString, inputArray, myStack);
                        break;
                    }
                    if(q2.curr){
                        q3.curr = true; // transition to next state
                        q2.curr = false;
                        myStack.pop();
                        break;
                    }
                    if(q3.curr){
                        myStack.pop();
                        break;
                    }
                case 0:
                    if(q0.curr){
                        q1.curr = true; // transition to next state
                        q0.curr = false;
                        myStack.push("#");
                        break;
                    }
                    if(q1.curr){
                        q2.curr = true; // transition to next state
                        q1.curr = false;
                        myStack.push("#");
                        break;
                    }
                    if(q2.curr){
                        validString = false;
                        isValid(validString, inputArray, myStack);
                        break;
                    }
                    if(q3.curr){
                        validString = false;
                        isValid(validString, inputArray, myStack);
                        break;
                    }
                case 2:
                    if(q3.curr){
                        validString = true;
                        isValid(validString, inputArray, myStack);
                        break;
                    }
            }
        }
    }
    public static void isValid(boolean validString, ArrayList inputArray, Stack myStack){
        // prints string and string's validity
        inputArray.remove(inputArray.size()-1);
        if(validString && myStack.isEmpty()){
            System.out.println(inputArray.toString() + " ACCEPTED AND STACK EMPTY");
        }
        else{
            System.out.println(inputArray.toString() + " NOT ACCEPTED AND STACK OPERATIONS NOT BALANCED");
        }
    }
}
