/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberGame;

import java.util.Random;
import java.util.Scanner;

class Range{
    public int generate(int maxRange,int minRange){
        Random random = new Random();
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        return randomNumber;
    }
}

public class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Range rng = new Range();
        int totalAttempts = 0;
        int win = 0;
        
        while(true){
            System.out.println("Enter a maximum number : ");
            int max = sc.nextInt();
            System.out.println("Enter a minimum number : ");
            int min = sc.nextInt();
            sc.nextLine();
            
            int randomNumber = rng.generate(max, min);
            int attempts =0;
            
            while (true) {
                System.out.println("Guess a number between "+max+" and "+min+" : ");
                int number = sc.nextInt();
                attempts++;

                if (number > randomNumber) {
                    System.out.println("Its Greater");
                } else if (number < randomNumber){
                    System.out.println("Its Lower");
                }else{
                    System.out.println("Correct Guess");
                    win++;
                    break;
                }
            }
            totalAttempts += attempts;
            System.out.println("Attempts = " + attempts);
            System.out.println("Wins = " + win);

            double winrate = (double) win / totalAttempts*100;
            System.out.printf("Your winrate is %.2f%%\n",winrate);

            System.out.println("Do you want to play again (yes/no)");
            String playAgain = sc.next();
            if(!playAgain.equalsIgnoreCase("yes")){
                sc.close();
                System.exit(0);
            }
            sc.nextLine();
        }
    }
}
