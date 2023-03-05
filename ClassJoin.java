import java.util.Scanner;
class Component{
    // Enter your code here.
    String model;
    public int socket,memType;
    public boolean valid;
    Component(String model,int socket,int memType){
        this.model = model;
        this.socket = socket;
        this.memType = memType;
        valid = isValidSpec(model, socket, memType);
    }
    boolean isValidSpec(String model,int socket,int memType){
        boolean result = true;
        if(model == null || model.length() == 0){
            result = false;
        }
        if(socket <= 0){
            result = false;
        }
        if(memType <= 0 || memType > 10){
            result = false;
        }
        return result;
    }
    void printInfo(){
        System.out.println(valid);
        System.out.println(model);
        System.out.println(socket);
        System.out.println(memType);
    }
}
class CPU2 extends Component{
    // Enter your code here.
    int clocks;
    CPU2(String model,int clocks,int socket,int memType){
        super(model, socket, memType);
        this.clocks = clocks;
        valid = isValidSpec(model, clocks, socket, memType);
    }
    @Override
    void printInfo() {
        super.printInfo();
        System.out.println(clocks);
    }
    boolean isValidSpec(String model,int clocks,int socket,int memType){
        if(isValidSpec(model, socket, memType) && clocks > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
class MainBoard2 extends Component{
    // Enter your code here.
    MainBoard2(String model,int socket,int memType){
        super(model, socket, memType);
    }
}
public class ClassJoin {
    //Do not change the main method.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String model = scan.nextLine();
        int clocks = scan.nextInt();
        int socket = scan.nextInt();
        int memType = scan.nextInt();

        if(model.length() == 0 && socket % 2 == 0)
            model = null;
        Component cpu = new CPU2(model, clocks, socket, memType);
        cpu.printInfo();

        scan.nextLine(); // skip new line Character
        model = scan.nextLine();
        socket = scan.nextInt();
        memType = scan.nextInt();
        if(model.length() == 0 && socket % 2 == 0)
            model = null;
        Component mb = new MainBoard2(model,socket,memType);
        mb.printInfo();
    }
}
