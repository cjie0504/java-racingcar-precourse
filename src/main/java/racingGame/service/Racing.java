package racingGame.service;

import racingGame.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    public static List<String> winCars = new ArrayList<>();

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
