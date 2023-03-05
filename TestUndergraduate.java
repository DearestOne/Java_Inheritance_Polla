import java.util.Scanner;
class Student {
    public String firstname,lastname;
    private int[] stepScore;
    public Student(String firstname,String lastname){
        stepScore = new int[4];
        this.firstname = firstname;
        this.lastname = lastname;
    }
    int getTestScore(int num){
        return stepScore[num];
    }
    void setTestScore(int num,int amount){
        stepScore[num] = amount;
    }
    int computeTotal(){
        int Total = 0;
        for(int i=0;i<4;i++){
            Total += stepScore[i];
        }
        return Total;
    }
    void printInfo(){
        System.out.println(firstname + " " + lastname + " " + computeTotal());
    }
}
class Undergraduate extends Student {
    // Enter Your Code Here
    public int id;
    private String stepLevel;
    private boolean engPass;
    Undergraduate(int id,String firstname,String lastname){
        super(firstname,lastname);
        this.id = id;
        stepLevel = "";
        engPass = false;
    }
    String computeLevel(){
        if(computeTotal() >= 1 && computeTotal() <= 25){
            stepLevel = "A1";
        }
        else if(computeTotal() >= 26 && computeTotal() <= 50){
            stepLevel = "A2";
        }
        else if(computeTotal() >= 51 && computeTotal() <= 75){
            stepLevel = "B1";
        }
        else if(computeTotal() >= 76 && computeTotal() <= 100){
            stepLevel = "B2";
        }
        else if(computeTotal() >= 101 && computeTotal() <= 120){
            stepLevel = "C1";
        }
        else{// out of range 1-120
            for(int i=0;i<4;i++){ // set all score to 0
                setTestScore(i, 0);
            }
            stepLevel = "NA";
        }
        return stepLevel;
    }
    @Override
    void printInfo() {
        System.out.print(id + " ");
        super.printInfo();
        if(computeTotal() >= 1 && computeTotal() <= 75){
            System.out.print("Not pass ");
        }
        else if(computeTotal() >= 75 && computeTotal() <= 120){
            System.out.print("Pass ");
        }
        else{
            System.out.print("Invalid score ");
        }
        System.out.println(computeLevel());
    }
}
public class TestUndergraduate {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Undergraduate[] roster = new Undergraduate[N];
        for (int i = 0; i < N; i++) {
            int id = scan.nextInt();
            String fname = scan.next();
            String lname = scan.next();
            // Your code: create Undergraduate object
            roster[i] = new Undergraduate(id, fname, lname);
            for (int j = 1; j <= 4; j++) {
                int score = scan.nextInt();
                roster[i].setTestScore(j-1, score);
            }
        }
        boolean found = false;
        int rosterId = scan.nextInt();
        for (int i = 0; i < N; i++) {
            if (rosterId == roster[i].id) {
                roster[i].printInfo();
                for (int j = 1; j <= 4; j++) {
                    System.out.print(roster[i].getTestScore(j-1) + " ");
                }
                found = true;
            }
        }
        if(!found){
            System.out.println("Not found");
        }
    }
}