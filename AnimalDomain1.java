import java.util.ArrayList;
import java.util.Scanner;
class Animal {
    // Enter Your Code Here.
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
}
public class AnimalDomain1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<Animal> animal = new ArrayList<>();
        // Your Code
        for(int i = 0; i < N; ++i) {
            int type = scan.nextInt();
            if(type == 1) {
                String name = scan.next();
                int lifeExpect = scan.nextInt();
                Animal A = new Animal(name, lifeExpect);
                animal.add(A);
            } else if(type == 2) {
                int id = scan.nextInt();
                int year = scan.nextInt();
                animal.get(id - 1).live(year);
            } else if(type == 3) {
                int id = scan.nextInt();
                animal.get(id - 1).isAlive();
            }
        }
    }
}
