import java.util.ArrayList;
import java.util.Scanner;

class Dish{
    String name, description, category;
    int price;

    Dish(String name, int price,String description, String category){
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

}

class RestaurantMenu{
    ArrayList<Dish> dish = new ArrayList<>();
    ArrayList<String> listcategory = new ArrayList<>();
    void add(Dish obj){
        for (Dish item : dish){
            if (obj.name.equals(item.name)){
                System.out.println("Item already exists");
                return;
            }
        }
        dish.add(obj);
        for (String item : listcategory){
            if (item.equals(obj.category)){
                return;
            }
        }
        listcategory.add(obj.category);

    }
    void show(){
        System.out.println("run");
        for (String item : listcategory){
            System.out.println("Category: "+item);
            for (Dish item2 : dish){
                if (item2.category.equals(item)){
                    System.out.println("Name: "+item2.name);
                    System.out.println("Price: "+item2.price);
                    System.out.println("Description: "+item2.description);
                }
            }
        }
    }
    void search(String name){
        for (Dish item : dish){
            if (item.name.equals(name)){
                System.out.println("Category: "+item.category);
                System.out.println("Name: "+item.name);
                System.out.println("Price: "+item.price);
                System.out.println("Description: "+item.description);
            }
        }
    }
    void modify(String name, String description, int price){
        for (Dish item : dish){
            if (item.name.equals(name)){
                item.price=price;
                item.description=description;
            }
        }
    }
}

public class RestaurantMenu_Management {
    public static void main(String[]args){
        System.out.println("------Restaurant Menu Management-----");
        Scanner  num = new Scanner(System.in);
        int  fact = num.nextInt();
        if (fact<=1){
            System.out.println("Number greater than 1");
        }else {
            int i = 2;
            System.out.println(2);
            while (i<fact){
                if (i%2!=0){
                    System.out.println(i);
                }
                i++;
            }
        }


        System.out.println("Hey!!!!!!!");
        RestaurantMenu menu = new RestaurantMenu();
        String choice = "";
        do {
            Scanner user = new Scanner(System.in);
            System.out.println("What you want to do ?");
            System.out.print("Add/Show/Search/Modify: ");
            String userChoose = user.nextLine();
            switch (userChoose){
                case "add":
                    Scanner addU = new Scanner(System.in);
                    System.out.print("Food Name: ");
                    String name = addU.nextLine();
                    System.out.print("Category: ");
                    String category = addU.nextLine();
                    System.out.print("Description: ");
                    String desc = addU.nextLine();
                    System.out.print("Price: ");
                    int price = addU.nextInt();
                    Dish item = new Dish(name,price,desc,category);
                    menu.add(item);
                    break;
                case "show":
                    menu.show();
                    break;
                case "search":
                    Scanner searchU = new Scanner(System.in);
                    System.out.print("Food Name: ");
                    String nameS = searchU.nextLine();
                    menu.search(nameS);
                    break;
                case "modify":
                    Scanner modifyU = new Scanner(System.in);
                    System.out.print("Food Name: ");
                    String nameM = modifyU.nextLine();
                    System.out.print("New Description: ");
                    String descM = modifyU.nextLine();
                    System.out.print("New Price: ");
                    int priceM = modifyU.nextInt();
                    menu.modify(nameM,descM,priceM);
                    break;
                default:
                    System.out.println("Invalid Command");

            }
            System.out.print("Do you want to continue ? (y or n)  ");
            choice = user.next();
        } while (choice.equals("y"));
    }
}
