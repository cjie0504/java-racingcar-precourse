package racingGame.util;

import racingGame.exception.InputException;

import java.util.regex.Matcher;

public class ValidateUtil {

    private static final String INPUT_CHK_CAR_NAME_DOWN_5 = "자동차 이름은 5자 아래로 입력하세요.";
    private static final String INPUT_CHK_CAR_NAME_EMPTY = "자동차 이름이 빈값입니다.";
    private static final String INPUT_CHK_RACING_ROUND_ONLY_NUM = "시도할 횟수는 숫자만 입력해주세요.";
    private static final String INPUT_CHK_CARS_LIST_SIZE = "자동차는 2개이상 입력해주세요.";
    private static final int MIN_CARS_LIST_SIZE = 2;


    public static void chkCarName(String carName) {
        chkCarNameEmpty(carName);
        chkCarNameSize(carName);
    }

    public static void chkCarNameEmpty(String carName) {
        if (carName.length() < 1) {
            throw new InputException(INPUT_CHK_CAR_NAME_EMPTY);
        }
    }

    public static void chkCarNameSize(String carName) {
        if (carName.length() > 5) {
            throw new InputException(INPUT_CHK_CAR_NAME_DOWN_5);
        }
    }

    public static void chkRacingRound(String roundCnt) {
        Matcher matcher = RegexUtil.pattern.matcher(roundCnt);
        if (!matcher.find()) {
            throw new InputException(INPUT_CHK_RACING_ROUND_ONLY_NUM);
        }
    }

    public static void chkCarsSize(int size) {
        if (size < MIN_CARS_LIST_SIZE) {
            throw new InputException(INPUT_CHK_CARS_LIST_SIZE);
        }
    }
}
