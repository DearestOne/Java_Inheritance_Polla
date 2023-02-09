import java.util.Scanner;
import java.util.ArrayList;
// this is superclass.
class product{
    String name,sku;
    int weight;
    double price;
    boolean valid;
    public product(String name,String sku,double price,int weight){
        this.name = name;
        this.price = price;
        this.sku = sku;
        this.weight = weight;
    }
    boolean checkValidity(){
        boolean check = true;
        if(name == null || name.length() == 0){
            System.out.println("name is invalid");
            check = false;
        }
        if(sku == null || sku.length() == 0){
            System.out.println("sku is invalid");
            check = false;
        }
        if(price < 0){
            System.out.println("price is invalid");
            check = false;
        }
        if(weight < 0){
            System.out.println("weight is invalid");
            check = false;
        }
        valid = check;
        return check;
    }
    void printInfo(){
        System.out.print(name + ", " + sku + ", " + price + ", " + weight);
        System.out.println(valid ? "" : ", Invalid");
    }
}
// this is subclass.
class Shoe extends product{
    int gender,type,size;
    String brand;
    public Shoe(String name,String sku,Double price,int weight,int gender,int size,int type,String brand){
        super(name,sku,price,weight);
        this.gender = gender;
        this.type = type;
        this.brand = brand;
        this.size = size;
    }
    @Override
    void printInfo(){
        System.out.print(name + ", " + sku + ", " + price + ", " + weight); // or you can replace this line with super.peintInfo();
        System.out.println(valid ? "" : ", Invalid");
        System.out.print(gender == 1 ? "female, " : "male, ");
        System.out.print(size + ", ");
        if(type == 1){
            System.out.print("sport, ");
        }
        else if(type == 2){
            System.out.print("formal, ");
        }
        else if(type == 3){
            System.out.print("casual, ");
        }
        System.out.println(brand);
    }
}
public class ProductStore2 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scan.nextInt();
        ArrayList<Shoe> Sh = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            scan.nextLine();
            String name = scan.nextLine();
            String sku = scan.nextLine();
            double price = scan.nextDouble();
            int weight = scan.nextInt();
            int gender = scan.nextInt();
            int size = scan.nextInt();
            int type = scan.nextInt();
            String brand = scan.next();
            Shoe s = new Shoe(name,sku,price,weight,gender,size,type,brand);
            Sh.add(s);
        }
        for(int i=0;i<n;i++){
            Sh.get(i).checkValidity();
            System.out.println(Sh.get(i).valid);
        }
        for(int i=0;i<n;i++){
            Sh.get(i).printInfo();
        }
    }
}
