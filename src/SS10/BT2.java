package SS10;

abstract class Vehicle{
    protected String brand;

    public Vehicle(String brand){
        this.brand = brand;
    }
    public abstract void move();

    public String getBrand(){
        return brand;
    }
}

class Car extends Vehicle{
    public Car(String brand){
        super(brand);
    }
    @Override
    public void move(){
        System.out.println("Car is moving with motor");
    }
}

class Bike extends Vehicle{
    public Bike(String brand){
        super(brand);
    }
    @Override
    public void move(){
        System.out.println("Bike is moving with pedals");
    }
}

public class BT2{
    public static void main(String[] args) {
        Vehicle car =new Car("Toyota");
        Vehicle bike =new Bike("Ducati");

        System.out.println(car.getBrand()+ "- Moving Method: ");
        car.move();
        System.out.println(bike.getBrand()+ "- Moving Method: ");
        bike.move();
    }
}