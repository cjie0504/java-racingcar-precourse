package racingGame.service;

import racingGame.domain.UserInput;

public class GameService {

    public static void start() {
        UserInput userInput = new UserInput();
        userInput.userInputInfo();
        new Racing(userInput.getCarNameList(), userInput.getUserInput_roundCnt());
    }
}
