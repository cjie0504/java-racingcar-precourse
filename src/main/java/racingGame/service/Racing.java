package racingGame.service;

import racingGame.domain.Car;
import racingGame.domain.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Racing {
    private static final String WINCAR_RESULT_MSG = "가 최종 우승했습니다.";
    private static final String WINCAR_MSG_DELIMITER = ",";

    private int roundCnt;
    private Cars cars;
    public static List<String> winCars = new ArrayList<>();


    public Racing(List<String> carNames , int roundCnt){
        this.roundCnt = roundCnt;
        this.cars = Cars.setNewCars(carNames);
        this.cars.moveCars(this.roundCnt);
        findWinCar(this.cars.getCars(), this.cars.getMaxPosition());
        printResultMsg();
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

    public void printResultMsg(){
        StringJoiner sj = new StringJoiner(WINCAR_MSG_DELIMITER);
        for(String carName : winCars){
            sj.add(carName);
        }
        System.out.println(sj.toString()+WINCAR_RESULT_MSG);
    }
}
