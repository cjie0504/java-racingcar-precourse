package racingGame.domain;

import racingGame.util.ValidateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars setNewCars(List<String> carNames){
        List<Car> cars = new ArrayList<>();
        for(String carName : carNames){
            ValidateUtil.chkCarNameEmpty(carName);
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars(int roundCnt){
        for(int i = 0; i<roundCnt; i++){
            moveCar();
            System.out.println();
        }
    }

    public void moveCar(){
        for(Car car : cars){
            int randomInt = ThreadLocalRandom.current().nextInt(10);
            if(randomInt>=4) car.movePosition();
        }
    }

}
