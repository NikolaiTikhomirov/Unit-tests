package test.seminars.second.hw;

import main.seminars.second.hw.Car;
import main.seminars.second.hw.Motorcycle;
import main.seminars.second.hw.Vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VehicleTest {
    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setup (){
        car = new Car("Lada", "Sedan",1980);
        motorcycle = new Motorcycle("Jawa", "Classic", 1990);
    }
    
    @Test
    void checkObjectClass() {
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    @Test
    void checkCarWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void checkMotorcycleWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    void checkCarTestDrive() {
        car.testDrive();

        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void checkMotorcycleTestDrive() {
        motorcycle.testDrive();

        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void checkCarPark() {
        car.testDrive();
        car.park();

        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void checkMotorcyclePark() {
        motorcycle.testDrive();
        motorcycle.park();

        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }

}