import java.util.*;
class NumberGame 
{
    private static final int MAX_ATTEMPTS=10; // Maximum number of attempts
    private static int score=100;

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        Random rand=new Random();

        String playAgain;
        do 
        {
            int randomNumber=rand.nextInt(100)+1; // Generate a random number between 1 and 100
            int attempts=0;
            boolean guessedCorrectly=false;

            System.out.println("=================== Number Guessing Game ===================");
            do 
            {
                System.out.print("Guess the number between 1 and 100: ");
                int guess=sc.nextInt();
                sc.nextLine();

                attempts++;

                if(guess==randomNumber) 
                {
                    System.out.println("Congratulations! Your guess is correct.");
                    guessedCorrectly=true;
                    break;
                } 
                else if(guess<randomNumber) 
                {
                    System.out.println("Your guess is too low.");
                } 
                else 
                {
                    System.out.println("Your guess is too high.");
                }
                score-=10;
                if 
                (attempts==MAX_ATTEMPTS) 
                {
                    System.out.println("You have used all your attempts. The number was "+randomNumber);
                    System.out.println("Your Score is: "+score);
                    break;
                }
            }while(!guessedCorrectly);

            if(guessedCorrectly) 
            {
                System.out.println("You guessed the number in "+attempts+" attempts.");
                System.out.println("Your Score is: "+score);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain=sc.nextLine().toLowerCase();
            score=100;
        }while(playAgain.equals("yes"));

        System.out.println("Thanks for playing! Goodbye.");
    }
}