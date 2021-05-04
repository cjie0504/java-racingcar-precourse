package racingGame.domain;

import racingGame.util.ValidateUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private static final String INPUT_CAR_NAMES_MSG = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분).";
    private static final String INPUT_ROUND_MSG = "시도할 회수는 몇회인가요?";
    private static final String INPUT_CAR_SPLIT_STR = ",";

    private String carNames;
    private int roundCnt;

    public void userInputInfo(){
        Scanner scanner = new Scanner(System.in);
        inputCarName(scanner);
        inputRoundCnt(scanner);
    }

    private void inputRoundCnt(Scanner scanner) {
        System.out.println(INPUT_ROUND_MSG);
        ValidateUtil.chkRacingRound(scanner.nextLine());
        this.roundCnt = scanner.nextInt();
    }

    public static void inputRoundCnt(String roundCnt) {
        ValidateUtil.chkRacingRound(roundCnt);
    }

    private void inputCarName(Scanner scanner) {
        System.out.println(INPUT_CAR_NAMES_MSG);
        this.carNames = scanner.nextLine();
    }

    public int getUserInput_roundCnt(){
        return roundCnt;
    }

    public List<String> carNameList(){
        List<String> carNameList = Arrays.asList(carNames.split(INPUT_CAR_SPLIT_STR));
        for(String carName : carNameList){
            ValidateUtil.chkCarName(carName.trim());
        }
        return carNameList;
    }
}
