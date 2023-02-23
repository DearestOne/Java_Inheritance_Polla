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
class FixedDeposit extends Account{
    // Enter Your Code Here.
    double fixedAmount;
    FixedDeposit(String name,String code,double balance,double fixedAmount){
        super(name, code, balance);
        this.fixedAmount = fixedAmount;
        System.out.println("FixedDeposit account with " + fixedAmount);
    }
    @Override
    boolean deposit(double amount) {
        if(amount >= fixedAmount){
            return super.deposit(amount);
        }
        else {
            System.out.print("deposit less than " + fixedAmount + " ");
            return false;
        }
    }
}
class CurrentAccount extends Account{
    // Enter Your Code Here.
    double overDraft;
    CurrentAccount(String name,String code,double balance,double overDraft){
        super(name, code, balance);
        this.overDraft = overDraft;
        System.out.println("Current account with overdraft " + overDraft);
    }
    @Override
    boolean withdrawn(double amount) {
        boolean result;
        if(balance - amount >= -overDraft && active){
            balance -= amount;
            System.out.print(balance + " ");
            if(balance < 0){
                System.out.print("overdraft ");
            }
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }
}
public class BankAccount3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Saving sAcc = null;
        FixedDeposit fAcc = null;
        CurrentAccount cAcc = null;
        for (int t = 1; t <= 3; t++) {
            String name = scan.nextLine();
            String code = scan.nextLine();
            double money1 = scan.nextDouble();
            if (t == 1) {
                scan.nextLine();
                sAcc = new Saving(name, code, money1);
            } else if (t == 2) {
                double money2 = scan.nextDouble();
                scan.nextLine(); //Skip the remainder of the double line.
                fAcc = new FixedDeposit(name, code, money1, money2);

            } else if (t == 3) {
                double money2 = scan.nextDouble();
                scan.nextLine(); // Skip the remainder of the double line.
                cAcc = new CurrentAccount(name, code, money1, money2);
            }
        }
        int N = scan.nextInt();
        for (int i = 0; i < N; ++i) {
            double amount;
            int type = scan.nextInt();
            int menu = scan.nextInt();
            // your code to scan input
            switch(menu) {
                case 1:{
                    switch(type){
                        case 1:{
                            sAcc.printInfo();
                            break;
                        }
                        case 2:{
                            fAcc.printInfo();
                            break;
                        }
                        case 3:{
                            cAcc.printInfo();
                            break;
                        }
                    }
                    break;
                }
                case 2:{
                    switch(type){
                        case 1:{
                            System.out.println(sAcc.checkBalance());
                            break;
                        }
                        case 2:{
                            System.out.println(fAcc.checkBalance());
                            break;
                        }
                        case 3:{
                            System.out.println(cAcc.checkBalance());
                            break;
                        }
                    }
                    break;
                }
                case 3:{
                    switch(type){
                        case 1:{
                            sAcc.closeAccount();
                            break;
                        }
                        case 2:{
                            fAcc.closeAccount();
                            break;
                        }
                        case 3:{
                            cAcc.closeAccount();
                            break;
                        }
                    }
                    break;
                }
                case 4:{
                    amount = scan.nextDouble();
                    switch(type){
                        case 1:{
                            System.out.println(sAcc.deposit(amount));
                            break;
                        }
                        case 2:{
                            System.out.println(fAcc.deposit(amount));
                            break;
                        }
                        case 3:{
                            System.out.println(cAcc.deposit(amount));
                            break;
                        }
                    }
                    break;
                }
                case 5:{
                    amount = scan.nextDouble();
                    switch(type){
                        case 1:{
                            System.out.println(sAcc.withdrawn(amount));
                            break;
                        }
                        case 2:{
                            System.out.println(fAcc.withdrawn(amount));
                            break;
                        }
                        case 3:{
                            System.out.println(cAcc.withdrawn(amount));
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}