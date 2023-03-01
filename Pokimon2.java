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
    // Enter your new code here and only here
}
// Do not modify the code below this line. 
public class Pokimon2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] hps = new int[6];
        int[] attks = new int[6];
        int[] defends = new int[6];
        // Read PokiStats
        for(int level = 1; level <= 5; ++level)
            hps[level] = scan.nextInt();
        for(int level = 1; level <= 5; ++level)
            attks[level] = scan.nextInt();
        for(int level = 1; level <= 5; ++level)
            defends[level] = scan.nextInt();
        PokiStats stats = new PokiStats(hps, attks, defends);

        // Name, level and object creation
        String name = scan.next();
        int level = scan.nextInt();
        Pokimon mon = new Pokimon(stats, name, level);

        // Write output
        System.out.println(mon.name);
        System.out.println(mon.energy);
        System.out.println(mon.attack());
        System.out.println(mon.defend());
    }
}