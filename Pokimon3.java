import java.util.Scanner;
class PokiStats {
    // Enter your code here and only here
    int[] hps,defends,attks;
    PokiStats(int[]hps, int[] attks, int[] defends){
        this.hps = new int[6];
        this.attks = new int[6];
        this.defends = new int[6];
        this.hps = java.util.Arrays.copyOf(hps,6);
        this.attks = java.util.Arrays.copyOf(attks,6);
        this.defends = java.util.Arrays.copyOf(defends,6);
    }
}

class Pokimon {
    PokiStats p;
    String name;
    int energy,level;
    Pokimon(PokiStats p,String name,int level){
        this.name = name;
        this.p = p;
        this.level = level;
        energy = p.hps[level];
    }
    int attack(){
        return p.attks[level];
    }
    int defend(){
        return p.defends[level];
    }
}
class WaterPokimon extends Pokimon{
    WaterPokimon(PokiStats p,String name,int level){
        super(p,name,level);
    }
    int attack(WaterPokimon water){
        return super.attack();
    }
    int attack(FirePokimon fire){
        return super.attack() * 2;
    }
    int attack(ElectricPokimon elec){
        return super.attack();
    }
}
class FirePokimon extends Pokimon{
    FirePokimon(PokiStats p,String name,int level){
        super(p,name,level);
    }
    int attack(WaterPokimon water){
        return super.attack();
    }
    int attack(FirePokimon fire){
        return super.attack();
    }
    int attack(ElectricPokimon elec){
        return super.attack() * 2;
    }
}
class ElectricPokimon extends Pokimon{
    ElectricPokimon(PokiStats p,String name,int level){
        super(p,name,level);
    }
    int attack(WaterPokimon water){
        return super.attack() * 2;
    }
    int attack(FirePokimon fire){
        return super.attack();
    }
    int attack(ElectricPokimon elec){
        return super.attack();
    }
}
public class Pokimon3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] hps = new int[6];
        int[] attks = new int[6];
        int[] defends = new int[6];
        WaterPokimon water = null;
        FirePokimon fire = null;
        ElectricPokimon electric = null;
        // Read PokiStats
        for(int t = 1; t <= 3; ++t) {
            for(int level = 1; level <= 5; ++level)
                hps[level] = scan.nextInt();
            for(int level = 1; level <= 5; ++level)
                attks[level] = scan.nextInt();
            for(int level = 1; level <= 5; ++level)
                defends[level] = scan.nextInt();
            PokiStats stats = new PokiStats(hps,attks,defends);
            // Name, level and object creation
            String name = scan.next();
            int level = scan.nextInt();
            if(t == 1)
                water = new WaterPokimon(stats, name, level);
            else if(t == 2)
                fire = new FirePokimon(stats, name, level);
            else if(t == 3)
                electric =
            new ElectricPokimon(stats, name, level);
        }

        // Write output
        System.out.println(water.attack(water) + " " + water.attack(fire) + " " + water.attack(electric));
        System.out.println(fire.attack(water) + " " + fire.attack(fire) + " " + fire.attack(electric));
        System.out.println(electric.attack(water) + " " + electric.attack(fire) + " " + electric.attack(electric));
    }
}
