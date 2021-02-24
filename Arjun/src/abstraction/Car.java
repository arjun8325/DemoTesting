package abstraction;

abstract class Vehicle
{
   public abstract void engine();
   
   void ad() {
	   System.out.println("amit");
   }
}
public class Car extends Vehicle {

    public void engine()
    {
        System.out.println("Car engine");
        // car engine implementation
    }

    public static void main(String[] args)
    {
        Car v = new Car();
        v.engine();
        v.ad();
        
        
    }
}

