package racingGame.domain;

import racingGame.util.ValidateUtil;

public class Car {

    private static final int CAR_START_POSITION = 0;
    public final CarName carName;
    public Position position;

    public Car(String carName) {
        ValidateUtil.chkCarName(carName.trim());
        this.carName = new CarName(carName);
        this.position = new Position(CAR_START_POSITION);
    }

    public Car(String carName, int position) {
        ValidateUtil.chkCarName(carName.trim());
        this.carName = new CarName(carName);
        this.position = new Position(position);
    }

    public int getPosition(){
        return this.position.getPosition();
    }

    public String getCarName(){
        return this.carName.getCarName();
    }

    public int movePosition(){
        this.position = position.movePosition();
        return getPosition();
    }
}
