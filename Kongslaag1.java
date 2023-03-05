import java.util.Scanner;
class SlaagOffice {
    // Enter your code here
    int[] allprice;
    SlaagOffice(int num,int[] nums){
        allprice = new int[3];// [0] = 1 num , [1][2] = 2 num
        allprice[0] = num;
        allprice[1] = nums[0];
        allprice[2] = nums[1];
    }
    void checkPrize(Lottery L){
        if(L.lott[0] == allprice[0]){
            L.oneFront = true;
        }
        if(L.lott[3] == allprice[0]){
            L.oneBack = true;
        }
        if(L.lott[0] == allprice[1] && L.lott[1] == allprice[2]){
            L.twoFront = true;
        }
        if(L.lott[2] == allprice[1] && L.lott[3] == allprice[2]){
            L.twoBack = true;
        }
    }
}
class Lottery {
    // Enter your code here
    int[] lott;
    boolean oneFront,oneBack,twoFront,twoBack;
    Lottery(int[] lott){
        this.lott = java.util.Arrays.copyOf(lott,4);
        oneBack = false;
        oneFront = false;
        twoBack = false;
        twoFront = false;
    }
    void reportPrize(){
        if(!oneFront && !oneBack && !twoFront && !twoBack){
            System.out.println("Sorry, no prize");
        }
        if(oneFront){
            System.out.println("You got one front prize");
        }
        if(oneBack){
            System.out.println("You got one back prize");
        }
        if(twoFront){
            System.out.println("You got two front prize");
        }
        if(twoBack){
            System.out.println("You got two back prize");
        }
    }
}
public class Kongslaag1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        // Create a 2-number array from user inputs.
        int[] b = {scan.nextInt(), scan.nextInt()};
        SlaagOffice office = new SlaagOffice(a, b);

        final int Q = scan.nextInt();
        for(int i = 0; i < Q; ++i) {
            // Create a 4-number array from user inputs.
            int[] nums = {scan.nextInt(), scan.nextInt(),scan.nextInt(), scan.nextInt()};
            Lottery lotto = new Lottery(nums);
            office.checkPrize(lotto);;
            lotto.reportPrize();;
        }
    }
}