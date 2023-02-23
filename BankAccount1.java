import java.util.Scanner;
class Account {
// Enter Your Code Here.
    String name,code;
    double balance;
    boolean active;
    Account(String name,String code,double balance){
        this.balance = balance;
        this.name = name;
        this.code = code;
        active = true;
        System.out.println("Open account");
    }
    void printInfo(){
        System.out.print(name + ", " + code + ", " + balance + ", ");
        System.out.println(active ? "active" : "inactive");
    }
    double checkBalance(){
        return balance;
    }
    void closeAccount(){
        active = false;
        printInfo();
    }
    boolean deposit(double amount){
        if(active){
            balance += amount;
            System.out.print(balance + " ");
            return true;
        }
        else{
            return false;
        }
    }
    boolean withdrawn(double amount){
        if(active && balance - amount >= 0){
            balance -= amount;
            System.out.print(balance + " ");
            return true;
        }
        else{
            return false;
        }
    }
}
public class BankAccount1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String code = scan.nextLine();
        double money = scan.nextDouble();
        /* Your Code: create Account object*/
        Account a = new Account(name,code,money);
        int N = scan.nextInt();
        for(int i = 0; i < N; ++i) {
            int option = scan.nextInt();
            if(option == 1){
                a.printInfo();
            }
            else if(option == 2){
                System.out.println(a.checkBalance());
            }
            else if(option == 3){
                a.closeAccount();
            }
            else if(option == 4){
                double amount = scan.nextDouble();
                System.out.println(a.deposit(amount));
            }
            else if(option == 5){
                double amount = scan.nextDouble();
                System.out.println(a.withdrawn(amount));
            }
        }
    }
}