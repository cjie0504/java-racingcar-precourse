package racingGame.domain;

public class Position {
    private static final int CAR_MOVE_RANGE = 1;
    int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    public Position movePosition(){
        return new Position(this.position+CAR_MOVE_RANGE);
    }
}
