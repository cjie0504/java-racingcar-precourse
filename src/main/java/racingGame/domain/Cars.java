package racingGame.domain;

import racingGame.util.ValidateUtil;

import java.util.ArrayList;
import java.util.List;

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
}
