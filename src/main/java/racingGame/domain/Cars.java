package racingGame.domain;

import racingGame.util.ValidateUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Cars {
    private StringBuffer sb = new StringBuffer();
    private static final String CARS_NAME_DELIMITER = " : ";
    private static final String CARS_MOVE_MARK = "-";
    private static final int RANDOM_BOUND = 10;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars setNewCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            ValidateUtil.chkCarNameEmpty(carName);
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars(int roundCnt) {
        for (int i = 0; i < roundCnt; i++) {
            moveCar();
            System.out.println();
        }
    }

    public void moveCar() {
        for (Car car : cars) {
            int randomInt = ThreadLocalRandom.current().nextInt(RANDOM_BOUND);
            carMovePosition(randomInt, car);
            drawRacing(car.getCarName(), car.getPosition());
        }
    }

    public void carMovePosition(int randomInt, Car car) {
        if (randomInt >= 4) car.movePosition();
    }

    private void drawRacing(String carName, int position) {
        sb.setLength(0);
        sb.append(carName);
        sb.append(CARS_NAME_DELIMITER);
        for (int i = 0; i < position; i++) {
            sb.append(CARS_MOVE_MARK);
        }
        System.out.println(sb.toString());
    }


    public int getMaxPosition() {
        List<Integer> positionList = new ArrayList();
        for (Car car : cars) {
            positionList.add(car.getPosition());
        }
        return Collections.max(positionList);
    }
}
