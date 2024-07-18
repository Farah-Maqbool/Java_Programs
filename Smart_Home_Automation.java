import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

//Smart Home Automation :
//o Create a class named Device with attributes for name, type (e.g., light, thermostat),
//o and a method to turn the device on/off.
//o Design a class named SmartHome that manages a collection of Device objects.
//o Implement functionalities in SmartHome to:
// Add a new device to the system with a unique identifier.
// Control individual devices (turn on/off) by name.
// Create schedules for specific devices (e.g., turn lights on at sunset).
//(Bonus: Simulate time-based actions using timers or external libraries)
// Allow remote access to the system using a simulated mobile app interface
//(text-based commands).
class Device{
    int id;
    String name, type;
    String on_off;
    Device(String name, String type, String on_off){
        this.name = name;
        this.type = type;
        if (on_off.equals("on")){
            this.on_off = "on";
        }else if (on_off.equals("off")){
            this.on_off = "off";
        }
    }
}
class SmartHome{
    ArrayList<Device> device = new ArrayList<>();

    void add(Device obj){
        device.add(obj);
        obj.id = device.getFirst().id+1;


    }
    void turnON_OFF(String name, String on_off){
        for (Device device : device){
            if (device.name.equals(name)){
                if (on_off.equals("on")){
                    device.on_off = "on";
                    System.out.println("Device ON");
                    break;
                }else if (on_off.equals("off")){
                    device.on_off = "off";
                    System.out.println("Device OFF");
                    break;
                }
            }
        }
    }
    void schedule(){
        LocalTime now = LocalTime.now();
        if (now.isAfter(LocalTime.of(6, 0)) || now.isAfter(LocalTime.of(12, 0)) || now.isAfter(LocalTime.of(17, 0))) {
            for (Device device : device){
                device.on_off = "on";
            }
        }else if ((now.isAfter(LocalTime.of(18, 0))) || now.isBefore(LocalTime.of(6, 0))){
            for (Device device1 : device){
                device1.on_off = "off";
            }
        }
    }

}
public class Smart_Home_Automation {
    public static void main(String[]args){
        SmartHome home = new SmartHome();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add device");
            System.out.println("2. Control device");
            System.out.println("3. Automatic Schedule");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                Scanner user = new Scanner(System.in);
                System.out.print("Enter device name: ");
                String name = user.nextLine();
                System.out.print("Enter device type (light, thermostat, etc.): ");
                String type = user.nextLine();
                System.out.print("On/Off: ");
                String on_off = user.next().toLowerCase();
                Device device = new Device(name, type, on_off);
                home.add(device);
            } else if (choice == 2) {
                System.out.print("Enter device name: ");
                String name = scanner.next();
                System.out.print("Enter action (on/off): ");
                String action = scanner.next();
                home.turnON_OFF(name, action);
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else if (choice== 4) {
                System.out.println("All devices on from  6:00 to 18:00");
                System.out.println("All devices off from 18:00 to 6:00");
                home.schedule();
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}

