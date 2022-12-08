import java.util.*;

public class NumberGuess{

    public static int Generator(int end){
        Random rand = new Random();
        return rand.nextInt(end);
    }

    public static void game(){
        Scanner in = new Scanner(System.in);
        int round=1;
        int points=0;
        int boundary = 100;
        int number = Generator(boundary);
        int noOfGuesses = Math.max(3,(int)Math.log(number)+2);

        while(noOfGuesses>0){
            System.out.print("Guess the number in the range ::0-"+(boundary-1)+" (Remaining Guesses - "+noOfGuesses+" ):");
            int entry = in.nextInt();

            if(number==entry){
                points+=noOfGuesses;
                System.out.printf("Points earned in round %d are %d%n",round, noOfGuesses);
                round++;
                System.out.printf("-----------------Round-%d----------------%n",round);
                boundary*=5;
                number = Generator(boundary);
                noOfGuesses = Math.max(3,(int)Math.log(number)+2);
            }
            else{
                if(entry>number){
                    System.out.printf("The entered number %d is greater than Magic Number%n",entry);
                }
                else{
                    System.out.printf("The entered number %d is less than Magic Number%n",entry);
                }
                noOfGuesses--;
            }
        }

        System.out.printf("Total points earned in %d round(s) is(are) %d%n",round,points);
        System.out.printf("The magic number is %d%n",number);

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("1.Restart Game%n(Any Key).Quit%n");
        String option = in.next();
        if(option.equals("1")){
            game();
        }else{
            System.exit(0);
        }
        in.close();
    }

    public static void main(String[] args){
        System.out.printf("%n----------------------------------------Number Guesser-----------------------------------%n");
        game();
    }
}
