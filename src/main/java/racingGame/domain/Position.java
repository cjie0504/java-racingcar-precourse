package racingGame.domain;

public class Position {
    int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    public Position movePosition(){
        return new Position(this.position+1);
    }
}
