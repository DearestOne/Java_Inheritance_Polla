import java.util.ArrayList;
import java.util.Scanner;
class Animal {
    String name;
    int lifeExpect,age;
    Animal(String name,int lifeExpect){
        this.name = name;
        this.lifeExpect = lifeExpect;
        age = 0;
        System.out.println(name + " was born with life expectancy " + lifeExpect + " year(s)");
    }
    void live(int year){
        if(age == lifeExpect){
            System.out.println(name + " died earlier");
            return;
        }
        else if(age + year <= lifeExpect){
            System.out.print(name + " lived " + year + " more year");
            age += year;
            if(year != 1){
                System.out.print("s");
            }
        }
        else{
            System.out.print(name + " lived " + (lifeExpect-age) + " more year");
            if((lifeExpect-age) != 1){
                System.out.print("s");
            }
            age = lifeExpect;
        }

        if(age == lifeExpect){
            System.out.println(" and died");
        }
        else{
            System.out.println();
        } 
    }
    boolean isAlive(){
        if(age == lifeExpect){
            System.out.println(name  + " is dead");
            return true;
        }
        else{
            System.out.println(name + " is alive");
            return false;
        }
    }
    void vaccine(){
        System.out.println(name + "'s life expectancy is now " + lifeExpect + " year(s)");
    }
}
class Dog extends Animal{
    boolean isvaccine;
    Dog(String name){
        super(name,8);
        isvaccine = false;
    }
    @Override
    void vaccine() {
        if(!isvaccine){
            lifeExpect += lifeExpect - age;
            isvaccine = true;
        }
        super.vaccine();
    }
}
class Turtle extends Animal{
    Turtle(String name){
        super(name,50);
    }
}
class Salmon extends Animal{
    Salmon(String name){
        super(name,4);
    }
}
public class AnimalDomain2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<Animal> animal = new ArrayList<>();
        // Your Code
        for(int i = 0; i < N; ++i) {
            int option = scan.nextInt();
            if(option == 1){
                int type = scan.nextInt();
                String name = scan.next();
                if(type == 1){
                    Dog d = new Dog(name);
                    animal.add(d);
                }
                else if(type == 2){
                    Turtle t = new Turtle(name);
                    animal.add(t);
                }
                else if(type == 3){
                    Salmon s = new Salmon(name);
                    animal.add(s);
                }
            }
            else if(option == 2){
                int p = scan.nextInt();
                int k = scan.nextInt();
                animal.get(p - 1).live(k);
            }
            else if(option == 3){
                int p = scan.nextInt();
                animal.get(p - 1).isAlive();
            }
            else if(option == 4){
                int p = scan.nextInt();
                animal.get(p - 1).vaccine();
            }
        }
    }
}
