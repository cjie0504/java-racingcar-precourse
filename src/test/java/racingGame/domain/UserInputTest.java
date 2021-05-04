package racingGame.domain;

import org.junit.jupiter.api.Test;
import racingGame.exception.InputException;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputTest {


    @Test
    public void 레이싱_횟수_숫자_검증() {
        String input = "ㄱ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(
                () -> new UserInput().inputRoundCnt(scanner)
        ).isInstanceOf(InputException.class)
                .hasMessageContaining("시도할 횟수는 숫자만 입력해주세요.");
    }

    @Test
    public void 레이싱_자동차_이름_빈값_검증() {
        String input = " ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(
                () -> new UserInput().inputCarName(scanner)
        ).isInstanceOf(InputException.class)
                .hasMessageContaining("자동차 이름이 빈값입니다.");
    }

    @Test
    public void 레이싱_자동차_이름_빈값_검증_2() {
        String input = "TEST, ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(
                () -> new UserInput().inputCarName(scanner)
        ).isInstanceOf(InputException.class)
                .hasMessageContaining("자동차 이름이 빈값입니다.");
    }

    @Test
    public void 레이싱_자동차_이름_5글자이상() {
        String input = "TEST,TEST_CAR";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(
                () -> new UserInput().inputCarName(scanner)
        ).isInstanceOf(InputException.class)
                .hasMessageContaining("자동차 이름은 5자 아래로 입력하세요.");
    }


    @Test
    public void 레이싱_자동차_이름_2개이상() {
        String input = "TEST";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(
                () -> new UserInput().inputCarName(scanner)
        ).isInstanceOf(InputException.class)
                .hasMessageContaining("자동차는 2개이상 입력해주세요.");
    }
}
