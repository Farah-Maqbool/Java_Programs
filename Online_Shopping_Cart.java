import java.util.ArrayList;
import java.util.Scanner;

class Product{
    String name;
    int price, quantity;
    Product(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class ShoppingCart{
    ArrayList<Product> Cart = new ArrayList<>();

    void add(Product obj){
        for (Product item: Cart){
            if (obj.name.equals(item.name)){
                System.out.println("Item Already Exist");
                return;
            }
        }
        Cart.add(obj);
        System.out.println("Item add Successfully");
    }

    void updateQuantity(String name, int quantity){
        for (Product item: Cart){
            if (name.equals(item.name)){
                item.quantity+=quantity;

            }
        }
        System.out.println("Quantity Update Successfully");
    }
    void remove(String name){
        for (Product item: Cart){
            if (name.equals(item.name)){
                Cart.remove(item);
            }
        }
        System.out.println("Item Remove Successfully");
    }
    void bill(){
        int totalBill = 0;
        for (Product item: Cart){
            totalBill+= (item.price* item.quantity);
        }
        System.out.println("Total Bill: "+totalBill);
    }
    void show(){
        System.out.println("Cart Items");
        for (Product item: Cart){
            System.out.println("Name: "+item.name);
            System.out.println("Price: "+item.price);
            System.out.println("Quantity: "+item.quantity);
        }
    }
}

public class Online_Shopping_Cart {
    public static void main(String[]args){
        System.out.println("------Shopping Cart------");
        ShoppingCart cart = new ShoppingCart();
        Scanner userExitProgram = new Scanner(System.in);
        String UserExit = "";
        do {
            System.out.println("What do you want to do ?");
            System.out.print("Add/Update/Remove/Bill/Show: ");
            Scanner choice = new Scanner(System.in);
            String userChoose = choice.next().toLowerCase();
            switch (userChoose){
                case "add":
                    Scanner user = new Scanner(System.in);
                    System.out.print("Item Name: ");
                    String name = user.nextLine();
                    System.out.print(name+ " Price: ");
                    int price = user.nextInt();
                    System.out.print(name+ " Quantity: ");
                    int quantity = user.nextInt();
                    Product item = new Product(name,price,quantity);
                    cart.add(item);
                    break;
                case "update":
                    Scanner userU = new  Scanner(System.in);
                    System.out.print("Item Name: ");
                    String nameU = userU.nextLine();
                    System.out.print(nameU+ " Quantity: ");
                    int quantityu = userU.nextInt();
                    cart.updateQuantity(nameU,quantityu);
                    break;
                case "remove":
                    Scanner userR = new  Scanner(System.in);
                    System.out.print("Item Name: ");
                    String nameR = userR.nextLine();
                    cart.remove(nameR);
                    break;
                case "bill":
                    cart.bill();
                    break;
                case "show":
                    cart.show();
                    break;
                default:
                    System.out.println("Invalid Command");
            }
            System.out.print("Do you want to continue (y or n) ? ");
            UserExit = userExitProgram.next();

        }while (UserExit.equals("y"));
        System.out.println("Thanks....");
    }
}
