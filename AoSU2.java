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
    // Enter your code here.
    Hero[] members;
    Team(Hero[] members){
        if(is5MemberTeam(members)){
            if(isValid(members)){
                this.members = java.util.Arrays.copyOf(members, members.length);
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
}
public class AoSU2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Hero members[] = null;
        if(N > 0) {
            members = new Hero[N];
            for(int i = 0; i < N; ++i) {
                String name = scan.next();
                int hp = scan.nextInt();
                int attkType = scan.nextInt();
                int attkDmg = scan.nextInt();
                int phyDef = scan.nextInt();
                int magDef = scan.nextInt();
                members[i] = new Hero(name, hp, attkType,attkDmg, phyDef, magDef);
            }
        }
        Team t = new Team(members);
        System.out.println(t.is5MemberTeam(members));
        System.out.println(t.isValid(members));
    }
}
