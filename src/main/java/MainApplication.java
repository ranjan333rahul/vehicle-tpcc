import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Bike;
import model.Car;

public class MainApplication {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TablePerClassPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        // Persisting entities
        transaction.begin();

        Car car = new Car();
        car.setManufacturer("Toyota");
        car.setNumberOfDoors(4);

        Bike bike = new Bike();
        bike.setManufacturer("Honda");
        bike.setHasBasket(true);

        entityManager.persist(car);
        entityManager.persist(bike);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();

        // Retrieving entities
     /*   EntityManagerFactory entityManagerFactory1 = Persistence.createEntityManagerFactory("TablePerClassPU");
        EntityManager entityManager1 = entityManagerFactory1.createEntityManager();
        Car retrievedCar = entityManager1.find(Car.class, car.getId());
        System.out.println("Retrieved Car: " + retrievedCar.getManufacturer());

        Bike retrievedBike = entityManager1.find(Bike.class, bike.getId());
        System.out.println("Retrieved Bike: " + retrievedBike.getManufacturer());
        entityManager1.close();
        entityManagerFactory.close();
      */
    }
}