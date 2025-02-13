import java.lang.Math;
public class Hero {
    private String name;
    private int hitPoints;
    public Hero(String name){
        this.name = name;
        hitPoints = 100;
    }
    public String getName(){
        return name;
    }
    public int getHitPoints(){
        return hitPoints;
    }
    public String toString(){
        return "Hero{" + "name='" + name + '\'' + ", hitPoints=" + hitPoints + '}';
    }
    public void attack(Hero opponent){
        if(Math.random()<0.5){
            opponent.hitPoints -= 10;
        }
        else{
            hitPoints -= 10;
        }
    }
    public void senzuBean(){
        hitPoints = 100;
    }
    private void fightUntilTheDeathHelper(Hero opponent){
        while(hitPoints > 0 && opponent.hitPoints>0){
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "\n" + opponent.name + ": " + opponent.hitPoints;
    }
    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int selfwin = 0;
        int oppwin = 0;
        while(n>0){
            senzuBean();
            opponent.senzuBean();
            fightUntilTheDeathHelper(opponent);
            if(hitPoints == 0){
                oppwin++;
            }
            else{
                selfwin++;
            }
            n--;
        }
        int[] wins = {selfwin, oppwin};
        return wins;
    }
    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] wins = nFightsToTheDeathHelper(opponent, n);
        if (wins[0] > wins[1]) {
            return name + ": " + wins[0] + " wins\n" + opponent.name + ": " + wins[1] + " wins\n" + name + " wins!";
        } else if (wins[1] > wins[0]) {
            return name + ": " + wins[0] + " wins\n" + opponent.name + ": " + wins[1] + " wins\n" + opponent.name + " wins!";
        } else {
            return name + ": " + wins[0] + " wins\n" + opponent.name + ": " + wins[1] + " wins\nOMG! It was actually a draw!";
        }
    }
    public void dramaticFightUntilTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();
        while(hitPoints > 0 && opponent.hitPoints>0){
            attack(opponent);
            System.out.println(toString() + opponent.toString());
        }
        if(hitPoints > opponent.hitPoints){
            System.out.println(name + " wins!");
        }
        else{
            System.out.println(opponent.name + " wins!");
        }
    }
}
