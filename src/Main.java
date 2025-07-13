import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    final String Rented_VEHICLES = "C:\\Users\\LENOVO\\Desktop\\Exercises&Labs\\Polymorphism-Exercise\\src\\vehicles\\rented-vehicles\\rented.txt";
    public static void main(String[] args) {
        final String AVAILABLE_VEHICLES = "C:\\Users\\LENOVO\\Desktop\\Exercises&Labs\\Polymorphism-Exercise\\src\\vehicles\\available-vehiles";

        ArrayList<Vehicle> rentedVehicles = new ArrayList<>();
        ArrayList<Vehicle> availableVehicles = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        int userSelect = 0;
        while(userSelect != 5){
            menu_Driven_Interface();
            System.out.println("Enter your choice : ");
            userSelect = in.nextInt();
            Vehicle v;//no more than One reference Object from each subclass , it's vehicle refrence and from it i am going to see the subclasses
            switch(userSelect){
                case 1 :
                    System.out.println("How many Days ? ");
                    int days = in.nextInt();
                    v = new Car(days);
//                    in.nextLine(); // Consume the leftover newline
                    //عرض البيانات للسيارة
                    availableVehicles = setAvailableVehicles(AVAILABLE_VEHICLES,"\\cars.txt");//جبتها من الفايل
                    System.out.println("Enter the number of Car Model you want : ");
                    int modelNumber = printArrayList(availableVehicles);//هنا تعرض الأجهزه كلها بالاضافه الى انك تجيب اختيار اليوزر
                    availableVehicles = UpdateRentalFile(modelNumber,availableVehicles);
                    UpdateVehicleFile(availableVehicles,"cars.txt");
                    break;


                case 2 :
                    System.out.println("How many hours ? ");
                    int hours = in.nextInt();
                    v = new Bike(hours);
//                    in.nextLine(); // Consume the leftover newline
                    //عرض البيانات الدراجه
                    availableVehicles = setAvailableVehicles(AVAILABLE_VEHICLES,"\\bikes.txt");//جبتها من الفايل
                    System.out.println("Enter the number of Bike brand you want : ");
                    int brandNumber = printArrayList(availableVehicles);//هنا تعرض الأجهزه كلها بالاضافه الى انك تجيب اختيار اليوزر
                    availableVehicles = UpdateRentalFile(brandNumber,availableVehicles);
                    UpdateVehicleFile(availableVehicles,"bikes.txt");
                    break;
                case 3 :
                    System.out.println("How many weeks ? ");
                    int weeks = in.nextInt();
                    v = new Truck(weeks);
//                    in.nextLine(); // Consume the leftover newline
                    //عرض البيانات الشاحنة
                    availableVehicles = setAvailableVehicles(AVAILABLE_VEHICLES,"\\trucks.txt");//جبتها من الفايل
                    System.out.println("Enter the number of Truck type you want : ");
                    int typeNumber = printArrayList(availableVehicles);//هنا تعرض الأجهزه كلها بالاضافه الى انك تجيب اختيار اليوزر
                    availableVehicles = UpdateRentalFile(typeNumber,availableVehicles);
                    UpdateVehicleFile(availableVehicles,"trucks.txt");
                    break;
                case 4 :
                    rentedVehicles();
                    break;
                case 5 :
                    System.out.println("Thank you for using the Vehicle Rental System!");
            }
        }
    }
    public static void menu_Driven_Interface(){
        System.out.println("Vehicle Rental System   \n" +
                "1. Rent a Car   \n" +
                "2. Rent a Bike   \n" +
                "3. Rent a Truck   \n" +
                "4. View Rented Vehicles   \n" +
                "5. Exit  ");
    }

    public static void rentedVehicles() {
        ArrayList<String> vehicles = new ArrayList<>();
        String filePath = "C:\\Users\\LENOVO\\Desktop\\Exercises&Labs\\Polymorphism-Exercise\\src\\vehicles\\rented-vehicles\\rented.txt";

        File file = new File(filePath);

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                vehicles.add(line);
            }

            // Print the rented vehicles
            System.out.println("List of Rented Vehicles:");
            for (String v : vehicles) {
                System.out.println(v);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Rented file not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error reading rented vehicles: " + e.getMessage());
        }
    }

    public static ArrayList<Vehicle> setAvailableVehicles(String parentPath, String branchPath){
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            String wholePath = parentPath + branchPath;

            File file = new File(wholePath);

            try{
                Scanner reader = new Scanner(file);
            if(branchPath.equals("\\cars.txt")){
                while(reader.hasNext()){
                    String firstVehicle = reader.next();
                    Vehicle v = new Car(firstVehicle);
                    vehicles.add(v);
                }
            } else if (branchPath.equals("\\bikes.txt")) {
                while(reader.hasNext()){
                    String firstVehicle = reader.next();
                    Vehicle v = new Bike(firstVehicle);
                    vehicles.add(v);
                }
            }else{//trucks path
                while(reader.hasNext()){
                    String firstVehicle = reader.next();
                    Vehicle v = new Truck(firstVehicle);
                    vehicles.add(v);
                }
            }
                reader.close();//close the Scanner Reader
            }catch (FileNotFoundException e){
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println("File Error : "+e.getMessage());
            }

            return vehicles;
    }

    public static int printArrayList(ArrayList<Vehicle> availableVehicles){
        for (int i = 0 ; i < availableVehicles.size();i++ ){
            System.out.println(i+1 + " : "+availableVehicles.get(i));
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Number Rental vehicle you want : ");
        return in.nextInt();
    }

    public static ArrayList<Vehicle> UpdateRentalFile(int vehicleRentedNumber, ArrayList<Vehicle> vehicles){
        int vRentedNumber = vehicleRentedNumber - 1;

        if (vRentedNumber >= 0 && vRentedNumber < vehicles.size()) {
            Vehicle rented = vehicles.get(vRentedNumber);
            assignIntoRentedVehicles(rented);
            System.out.println("Vehicle to be Rented is :");
            rented.displayDetails();
            vehicles.remove(vRentedNumber);
            System.out.println("Vehicle Rented successfully.");
            return vehicles;//New Array without the Vehicle Rented.
        }else {
                System.out.println("Invalid vehicle number.");
                return vehicles;
            }

        }


    public static void assignIntoRentedVehicles(Vehicle rented){
        String filePath = "C:\\Users\\LENOVO\\Desktop\\Exercises&Labs\\Polymorphism-Exercise\\src\\vehicles\\rented-vehicles\\rented.txt";

        try {

            // true = append mode
            PrintWriter writer = new PrintWriter(new FileWriter(filePath, true));

            //vehicle Details
            writer.println(rented.toString());
            writer.close();


            System.out.println("Vehicle added to rented.txt successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void UpdateVehicleFile(ArrayList<Vehicle> availableVehicles, String branchPath) {
        String filePath = "C:\\Users\\LENOVO\\Desktop\\Exercises&Labs\\Polymorphism-Exercise\\src\\vehicles\\available-vehiles"+branchPath;

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            for (Vehicle vehicle : availableVehicles) {
//                writer.println(vehicle.getNameOnly());
                if(vehicle instanceof Car c){
                    writer.println(c.getModel());
                } else if (vehicle instanceof Bike b) {
                    writer.println(b.getBrand());
                }else if(vehicle instanceof Truck t) {
                    writer.println(t.getType());
                }
            }
            System.out.println(branchPath + " has been updated successfully.");
        } catch (IOException e) {
            System.out.println("Error updating "+branchPath +" " + e.getMessage());
        }
    }


}

