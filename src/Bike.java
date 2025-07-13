public class Bike implements Vehicle{
    private String brand ;
    private int hour;

    public Bike( int hour) {
        this.hour = hour;
    }

    public Bike(String brand) {
        this.brand = brand;
    }

    public Bike(String brand, int hour) {
        this.brand = brand;
        this.hour = hour;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public double calculateRentalCost() {
        return hour * 10 ;
    }

    @Override
    public void displayDetails() {
        System.out.println("\nBike Details : ");
        System.out.println("Brand is : "+brand);
        System.out.println("Hour Rental Rate : 10$");
        System.out.println("Total Rental Rate : "+ calculateRentalCost()+"\n");

    }

    @Override
    public String toString() {
        return "Bike Details :{" +
                "brand='" + brand + '\'' +
                ", hour=" + hour +
                '}';
    }
}
