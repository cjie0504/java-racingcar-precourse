package racingGame.service;

import racingGame.domain.Car;
import racingGame.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private int roundCnt;
    private Cars cars;
    public static List<String> winCars = new ArrayList<>();


    public Racing(List<String> carNames , int roundCnt){
        this.roundCnt = roundCnt;
        this.cars = Cars.setNewCars(carNames);
        this.cars.moveCars(this.roundCnt);
    }


    public static List<String> findWinCar(List<Car> cars, int maxPosition) {
        for(Car car : cars) {
            setRacingResult(car.getCarName(), Integer.compare(car.getPosition(),maxPosition));
        }
        return winCars;
    }

    public static void setRacingResult(String carName, int comparePosition) {
        if (comparePosition == 0) {
            winCars.add(carName);
        }
    }
}
