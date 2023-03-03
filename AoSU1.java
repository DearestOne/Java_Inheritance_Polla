import java.util.Scanner;
class Hero {
    // You can enter your code here, and only here.
    String name;
    int hp,attkDmg,attkType,phyDef,magDef;
    Hero(String name,int hp,int attkType,int attkDmg,int phyDef,int magDef){
        this.name = name;
        this.attkType = attkType;
        this.hp = hp;
        this.attkDmg = attkDmg;
        this.phyDef = phyDef;
        this.magDef = magDef;
        checkAndWarn();
    }
    void printInfo(){
        System.out.println("Name: " + name);
        System.out.println("HP: " + hp);
        System.out.print("Attack: " + attkDmg + " ");
        System.out.println(attkType == 1 ? "(physical)"  : "(magical)");
        System.out.println("Defense: " + phyDef + " (physical), " + magDef + " (magical)");
        checkAndWarn();
    }
    boolean checkAndWarn(){
        if(hp < 0 || attkDmg < 0 || phyDef < 0 || magDef < 0){
            System.out.println("warning: value cannot be negative");
            return false;
        }
        else{
            return true;
        }
    }
}
public class AoSU1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int hp = scan.nextInt();
        int attkType = scan.nextInt();
        int attkDmg = scan.nextInt();
        int phyDef = scan.nextInt();
        int magDef = scan.nextInt();

        Hero hero = new Hero(name, hp, attkType,attkDmg, phyDef, magDef);
        hero.printInfo();
        System.out.println(hero.checkAndWarn());
    }
}