import java.util.Scanner;
class SlaagOffice {
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
class SlaagOffice2 extends SlaagOffice {
    // Enter your code here
    int[][] numss;
    SlaagOffice2(int num,int[] nums,int[][] numss){
        super(num, nums);
        this.numss = numss;
    }
    @Override
    void checkPrize(Lottery L) {
        boolean isfound = false;
        for(int i=0;i<numss.length;i++){
            boolean iswin = true;
            for(int j=0;j<4;j++){
                if(numss[i][j] != L.lott[j]){
                    iswin = false;
                }
            }
            if(iswin){
                System.out.println("You got exact-match prize");
                isfound = true;
                break;
            }
        }
        if(!isfound){
            System.out.println("No exact-match prize");
        }
        super.checkPrize(L);
    }
}
class Lottery {
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
public class Kongslaag2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        // Create a 2-number array from user inputs.
        int[] b = {scan.nextInt(), scan.nextInt()};
        final int R = scan.nextInt();
        int[][] exactPrizes = new int[R][];
        for(int i = 0; i < R; ++i) {
            int[] temp = {scan.nextInt(), scan.nextInt(),
            scan.nextInt(), scan.nextInt()};
            exactPrizes[i] = temp;
        }
        SlaagOffice2 office = new SlaagOffice2(a, b, exactPrizes);

        final int Q = scan.nextInt();
        for(int i = 0; i < Q; ++i) {
            // Create a 4-number array from user inputs.
            int[] nums = {scan.nextInt(), scan.nextInt(),scan.nextInt(), scan.nextInt()};
            Lottery lotto = new Lottery(nums);
            office.checkPrize(lotto);
            lotto.reportPrize();
        }
    }
}