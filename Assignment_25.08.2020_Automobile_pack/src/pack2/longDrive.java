package pack2;

import pack1.Car;

public class longDrive {

	public static void main(String[] args) {
		
		Car car = new Car(1947,"Q3",40,160,"sedan");
		
		System.out.println(car.start());
		
		if (car.increaseSpeed(160)==-1)
			System.out.println("Stop the car......");
				
		System.out.println(car.increaseSpeed(160));
			
		System.out.println(car.stop());
	}

}
