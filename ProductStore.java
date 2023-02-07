import java.util.Scanner;
import java.util.ArrayList;
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
public class ProductStore {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scan.nextInt();
        ArrayList<product> Pro = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            scan.nextLine();
            String name = scan.nextLine();
            String sku = scan.nextLine();
            double price = scan.nextDouble();
            int weight = scan.nextInt();
            product p = new product(name,sku,price,weight);
            Pro.add(p);
        }
        for(int i=0;i<n;i++){
            Pro.get(i).checkValidity();
            System.out.println(Pro.get(i).valid);
        }
        for(int i=0;i<n;i++){
            Pro.get(i).printInfo();
        }
    }
}