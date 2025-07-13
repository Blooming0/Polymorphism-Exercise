public class Truck implements Vehicle {
    private String type;
    private int week ;


    public Truck( int week) {
        this.week = week;
    }

    public Truck(String type) {
        this.type = type;
    }

    public Truck(String type, int week) {
        this.type = type;
        this.week = week;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Override
    public double calculateRentalCost() {
        return week * 500;
    }

    @Override
    public void displayDetails() {
        System.out.println("\nTruck Details : ");
        System.out.println("Type is : "+type);
        System.out.println("Week Rental Rate : 500$");
        System.out.println("Total Rental Rate : "+ calculateRentalCost()+"\n");

    }

    @Override
    public String toString() {
        return "Truck Details :{" +
                "type='" + type + '\'' +
                ", week=" + week +
                '}';
    }
}
