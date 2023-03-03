import java.util.Scanner;
class Hero {
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
class Team {
    Hero[] members;
    Team(Hero[] members){
        if(is5MemberTeam(members)){
            if(isValid(members)){
                this.members = java.util.Arrays.copyOf(members, members.length);
                isBalanced(members);
            }
            else{
                return;
            }
        }
        else{
            return;
        }
    }
    boolean is5MemberTeam(Hero[] members){
        if(members.length == 5){
            System.out.println("full team");
            return true;
        }
        else if(members.length > 5){
            System.out.println("too many members");
            return false;
        }
        else{
            System.out.println("member is missing");
            return false;
        }
    }
    boolean isValid(Hero[] members){
        if(members.length != 5){
            return false;
        }
        for(int i=0;i<members.length;i++){
            for(int j=0;j<members.length;j++){
                if(i != j && members[i].name.equals(members[j].name)){
                    System.out.println("cannot select same hero: " + members[i].name);
                    return false;
                }
            }
        }
        System.out.println("valid hero selection");
        return true;
    }
    boolean isBalanced(Hero[] members){
        if(members.length != 5){
            return false;
        }
        boolean balance[] = new boolean[4];
        boolean notbalance = false; // find not balance
        for(int i=0;i<members.length;i++){
            if(members[i] instanceof Carry){ // Carry
                balance[0] = true;
            }
            else if(members[i] instanceof Fighter){ // Fighter
                balance[1] = true;
            }
            else if(members[i] instanceof Mage){ // Mage
                balance[2] = true;
            }
            else if(members[i] instanceof Tank){ // Tank
                balance[3] = true;
            }
        }

        // find notbalance
        for(int i=0;i<4;i++){
            if(!balance[i]){
                notbalance = true;
            }
        }
        if(!notbalance){
            System.out.println("balanced team");
            return true;
        }

        System.out.print("team needs ");
        if(!balance[0]){ //carry
            System.out.print("carry ");
        }
        if(!balance[1]){ //Fighter
            System.out.print("fighter ");
        }
        if(!balance[2]){ //mage
            System.out.print("mage ");
        }
        if(!balance[3]){ //thak
            System.out.print("tank ");
        }
        System.out.println();
        return false;
    }
}
class Carry extends Hero{
    Carry(String name,int hp,int attkType,int attkDmg,int phyDef,int magDef){
        super(name, hp, attkType, attkDmg, phyDef, magDef);
    }
}
class Fighter extends Hero{
    Fighter(String name,int hp,int attkType,int attkDmg,int phyDef,int magDef){
        super(name, hp, attkType, attkDmg, phyDef, magDef);
    }
}
class Mage extends Hero{
    Mage(String name,int hp,int attkType,int attkDmg,int phyDef,int magDef){
        super(name, hp, attkType, attkDmg, phyDef, magDef);
    }
}
class Tank extends Hero{
    Tank(String name,int hp,int attkType,int attkDmg,int phyDef,int magDef){
        super(name, hp, attkType, attkDmg, phyDef, magDef);
    }
}
class Support extends Hero{
    Support(String name,int hp,int attkType,int attkDmg,int phyDef,int magDef){
        super(name, hp, attkType, attkDmg, phyDef, magDef);
    }
}
class Assassin extends Hero{
    Assassin(String name,int hp,int attkType,int attkDmg,int phyDef,int magDef){
        super(name, hp, attkType, attkDmg, phyDef, magDef);
    }
}
// อย่าลืมคลาสฮีโร่อีก 5 ชนิดด้วยนะ
public class AoSU3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Hero[] members = null;
        if(N > 0) {
            members = new Hero[N];
            for(int i = 0; i < N; ++i) {
                int type = scan.nextInt();
                String name = scan.next();
                int hp = scan.nextInt();
                int attkType = scan.nextInt();
                int attkDmg = scan.nextInt();
                int phyDef = scan.nextInt();
                int magDef = scan.nextInt();
                if(type == 1){
                    members[i] = new Carry(name, hp, attkType,attkDmg, phyDef, magDef);
                }
                else if(type == 2){
                    members[i] = new Fighter(name, hp, attkType,attkDmg, phyDef, magDef);
                }
                else if(type == 3){
                    members[i] = new Mage(name, hp, attkType,attkDmg, phyDef, magDef);
                }
                else if(type == 4){
                    members[i] = new Tank(name, hp, attkType,attkDmg, phyDef, magDef);
                }
                else if(type == 5){
                    members[i] = new Support(name, hp, attkType,attkDmg, phyDef, magDef);
                }
                else if(type == 6){
                    members[i] = new Assassin(name, hp, attkType,attkDmg, phyDef, magDef);
                }
            }
        }
        Team t = new Team(members);
        System.out.println(t.is5MemberTeam(members));
        System.out.println(t.isValid(members));
        System.out.println(t.isBalanced(members));
    }
}