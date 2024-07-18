import java.util.ArrayList;
import java.util.Scanner;

//Create a class named Product with details like product ID, name, description,
//        price, and stock quantity.
//o Design a class named InventoryManager to manage product stock.
//o Implement functionalities in InventoryManager to:
//         Add a new product to the inventory with a unique ID.
//         Update the stock quantity of an existing product (allow adding or
//        removing stock).
//         Search for a product by ID and display its details (if found).
//         Generate a report showing all products with their current stock levels and
//total value (price * quantity).
class ProductC{
    int id = 0, price, quantity;
    String name, description;

    ProductC(String name, String description, int price, int quantity){

        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
}
class InventoryManager{
    ArrayList<ProductC> product = new ArrayList<>();

    void add(ProductC obj){
        product.add(obj);
        obj.id = product.getFirst().id+1;
        System.out.println(obj.id);

    }
    void update(int add_remove, int quantity,String name){
        for (ProductC item : product){
            if (item.name.equals(name)){
                if (add_remove==-1){
                    item.quantity -= quantity;
                    return;
                } else if (add_remove==1) {
                    item.quantity += quantity;
                    return;
                }
            }
        }
        System.out.println("Not Found item");
    }
    void search(int id){
        for (ProductC item : product){
            if (item.id==id){
                System.out.println("Name: "+item.name);
                System.out.println("Description: "+item.description);
                System.out.println("Price: "+item.price);
                System.out.println("Quantity: "+item.quantity);
            }
        }
    }
    void report(){
        for (ProductC item : product){
            System.out.println("Name: "+item.name);
            System.out.println("Description: "+item.description);
            System.out.println("value: "+(item.price*item.quantity));
        }
    }
}
public class E_Commerce_Product_Inventory {
    public static void main(String[]args) {
        System.out.println("-----Inventory Manager-----");
        InventoryManager item = new InventoryManager();
        Scanner user = new Scanner(System.in);
        String end_program="";
        do {

                System.out.println("What do you want to do ?");
                System.out.println("b) Add item (Enter 'add')");
                System.out.println("a) Update item (Enter 'item')");
                System.out.println("c) Search Post (Enter 'search')");
                System.out.println("d) Report (Enter 'report')");
                System.out.print("Option: ");
                Scanner userItem = new Scanner(System.in);
                String user_choice = userItem.nextLine();

                switch (user_choice){
                    case "add":
                        Scanner add_item = new Scanner(System.in);
                        System.out.print("Name: ");
                        String name = add_item.nextLine();
                        System.out.print("Description: ");
                        String description = add_item.nextLine();
                        System.out.print("Price: ");
                        int price = add_item.nextInt() ;
                        System.out.print("Quantity: ");
                        int quantity = add_item.nextInt();
                        ProductC product = new ProductC(name, description,price,quantity);
                        item.add(product);
                        break;
                    case "update":
                        Scanner update = new Scanner(System.in);
                        System.out.print("Name: ");
                        String nameI = update.nextLine();
                        System.out.print("Add (Enter '1') or remove (Enter '-1'): ");
                        int add_remove = update.nextInt();
                        System.out.print("Quantity: ");
                        int quantityU = update.nextInt();
                        item.update(add_remove,quantityU,nameI);
                        break;
                    case "search":
                        Scanner search_item = new Scanner(System.in);
                        System.out.print("Id: ");
                        int itemID = search_item.nextInt();
                        item.search(itemID);
                        break;
                    case "report":
                        item.report();
                        break;
                    default:
                        System.out.println("Invalid Command");
                }
                System.out.print("Want to continue (y or n): ");
                end_program = userItem.nextLine();


        }while (end_program.equals("y"));
    }
}
