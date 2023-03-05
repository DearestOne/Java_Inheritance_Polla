import java.util.Scanner; 

class GameCharacter{
  String name;
  int attack,defense,level;
  
  void stat(){
      System.out.println(name + " " + level + " " + attack + " " + defense);
  }
}
class Hero extends GameCharacter{
    Hero(String name){ 
        attack = 10;
        defense = 5;
        level = 1;
        this.name = name;
    }
    void hit(Monster x){
        level += x.score / 100;
        attack = 10 + ((level-1) * 3);
        defense = 5 + ((level-1) * 2);
    }
}
class Monster extends GameCharacter{
    int score;
    Monster(String name, int level, int score){
        this.score = score;
        this.level = level;
        this.name = name;
        attack = 2 * level;
        defense = 3 * level;
    }
}
public class RolePlayingGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        Hero[] heroes = new Hero[M];
        for(int i=0;i<M;i++){
          String name = scan.next();
          heroes[i] = new Hero(name);
        }
        int N = scan.nextInt();
        Monster[] monster = new Monster[N];
        boolean[] alive = new boolean[N];
        for(int i=0;i<N;i++){
          int level = scan.nextInt();
          int score = scan.nextInt();
          monster[i] = new Monster(Integer.toString(i+1),level,score);
        }
        int K = scan.nextInt();
        for(int i=0;i<K;i++){
          int iHero = scan.nextInt()-1;
          int iMonster = scan.nextInt()-1;
          if (!alive[iMonster]){
            heroes[iHero].hit(monster[iMonster]);
            alive[iMonster] = !alive[iMonster];
          }
        }
        for(int i=0;i<M;i++){
          heroes[i].stat();
        }
    }
}