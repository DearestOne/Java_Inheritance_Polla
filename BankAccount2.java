import java.util.Scanner;
class Account {
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
class Saving extends Account{
    // Enter Your Code Here.
    String id,tel;
    boolean promptPay;
    Saving(String name,String code,double balance){
        super(name,code,balance);
        promptPay = false;
        id = "";
        tel = "";
        System.out.println("Saving account");
    }
    @Override
    void printInfo(){
        super.printInfo();
        if(promptPay){
            System.out.print("PromptPay");
        }
        else{
            System.out.print("no PromptPay");
        }
        
        // id &| tel
        if(id.length() > 0){
            System.out.print(", " + id);
        }
        if(tel.length() > 0){
            System.out.print(", " + tel);
        }
        System.out.println("");
    }
    boolean openPromptPay(int type,String DATA){
        if(type == 1){
            if(DATA.length() == 13){
                promptPay = true;
                id = DATA;
            }
            else{
                return false;
            }
        }
        else{
            if(DATA.length() == 10){
                promptPay = true;
                tel = DATA;
            }
            else{
                return false;
            }
        }
        return promptPay;
    }
}
public class BankAccount2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String code = scan.nextLine();
        double money = scan.nextDouble();
        /* Your Code: create Account object*/
        Saving s = new Saving(name,code,money);
        int N = scan.nextInt();
        for(int i = 0; i < N; ++i) {
            int option = scan.nextInt();
            if(option == 1){
                s.printInfo();
            }
            else if(option == 2){
                System.out.println(s.checkBalance());
            }
            else if(option == 3){
                s.closeAccount();
            }
            else if(option == 4){
                double amount = scan.nextDouble();
                System.out.println(s.deposit(amount));
            }
            else if(option == 5){
                double amount = scan.nextDouble();
                System.out.println(s.withdrawn(amount));
            }
            else if(option == 6){
                int type = scan.nextInt();
                String data = scan.next();
                System.out.println(s.openPromptPay(type,data));
            }
        }
    }
}