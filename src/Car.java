public class Car implements Vehicle{
    private String model;
    private int days;

    Car(int days){
        this.days =days;

    }

    Car(String model){
        this.model = model;
    }

    Car(String model,int days){
        this.days =days;
        this.model = model;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public double calculateRentalCost() {
        return days*50;
    }

    @Override
    public void displayDetails() {
        System.out.println("\nCar Rental Details : ");
        System.out.println("model is : "+model);
        System.out.println("Daily Rental Rate : 50$");
        System.out.println("Total Rental Rate : "+ calculateRentalCost()+"\n");

    }

    @Override
    public String toString() {
        return "\nCar Rental Details : \"{" +
                "model='" + model + '\'' +
                ", days=" + days +
                '}';
    }
}
