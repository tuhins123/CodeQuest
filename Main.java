import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sn=new Scanner(System.in);
        Random random=new Random();

        String [] enemies={"Skeleton", "Zombie", "Giant Spider", "Witch"};
        int maxEnemyHealth= 75;
        int enemyAttackDamage=25;

        int health=100;
        int attackDmg=50;
        int numHealthPots=3;
        int healthPotionHealAmt=30;
        //int healthPotionDropChance=50;

        boolean running=true;

        System.out.println("Welcom to the Adventure");
        System.out.println("You are a distant family member of a rich millionaire who just move to the other country, leaving this mansion to you.");
        System.out.println("As the newfound owner, you decide to pay a visit to the mansion.");
        System.out.println("The house is dated, creaky, and falling apart. You walk in the front door.");

        while(running){
            System.out.println("-------------------------------------------------");

            int enemyHealth= random.nextInt(maxEnemyHealth);
            String enemy= enemies[random.nextInt(enemies.length)];

            System.out.println("\t#" + enemy + "has appeared! #");
            
            GAME:
            while(enemyHealth>0){
                System.out.println("\t your HP: "+ health);
                System.out.println("\t"+ enemy+"'s HP:"+enemyHealth);
                System.out.println("\n\t What would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health solution");
                System.out.println("\t3. Run");

                String input= sn.nextLine();
                if(input.equals("1")){
                    int DamageDealt= random.nextInt(attackDmg);
                    int DamageTaken= random.nextInt(enemyAttackDamage);

                    enemyHealth-=DamageDealt;
                    health-=DamageTaken;

                    System.out.println("\t> You Strike the "+enemy+" for "+DamageDealt+" damage");
                    System.out.println("\t> You recieve "+ DamageTaken+" in retaliation.");

                    if(health<1){
                        System.out.println("\t You have taken too much damage, you are too weak to continue");
                        break;
                    }

                }else if(input.equals("2")){
                    if(numHealthPots>0){
                        health+=healthPotionHealAmt;
                        numHealthPots--;
                        System.out.println("\t> You Drink a Healt solution, healed for "+healthPotionHealAmt
                        +"\n\t> You now have "+health+" HP."
                        +"\n\t> You now have "+ numHealthPots+" health Solutions left \n");
                    }else{
                        System.out.println("\t> You have no health Solutions left, defeat enemies for chance to get one");
                    }
                }else if(input.equals("3")){
                    System.out.println("\t> You run away from "+enemy);
                    continue GAME;
                }else{
                    System.out.println("\tInvalid Input");
                }

            }
            if(health<1){
                System.out.println("You are out of the Game, Weak from battle. ");
                break;
            }
            System.out.println("--------------------------------------------------");
            System.out.println(" # "+enemy+" was defeated! #");
            System.out.println(" # you have "+health+" HP left #");

            if(random.nextInt(100)<50){
                numHealthPots++;
                //if random number is less than 50, the enemy drops health solution (if defeated)
                System.out.println(" # The "+enemy+" dropped a health solution. #");
                System.out.println(" # You now have "+ numHealthPots+" health solutons");
            }

            System.out.println("-----------------------------------------------");
            System.out.println("what would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Leave Mansion");
            String input=sn.nextLine();
            while(!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid Command");
                input=sn.nextLine();
            }

            if(input.equals("1")){
                System.out.println("You Continue your adventure");
            }else if(input.equals("2")){
                System.out.println(" You exit the Adventure");
                break;
            }
        }

        sn.close();
        System.out.println("** Thank you for Playing **");
        

    }
}
