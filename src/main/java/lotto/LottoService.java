package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {
    static final int START_NUMBER = 1;
    static final int END_NUMBER = 45;
    static final int COUNT_NUMBER = 6;

    int getInput() {
        int parsedInput;

        String input = Console.readLine();

        while (true) {
            try {
                parsedInput = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
        }

        return parsedInput;
    }

    List<Integer> getInputForNumbers() {

        String input = Console.readLine();

        List<String> seperatedInput = Arrays.asList(input.split(","));
        List<Integer> parsedInput = new ArrayList<>();

        for (int i = 0; i < seperatedInput.size(); i++) {
            parsedInput.add(Integer.parseInt(seperatedInput.get(i)));
        }

        return parsedInput;
    }

    int getTicket(int cash) {
        int ticket;

        if (cash % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        ticket = cash / 1000;

//        while (true) {
//            try {
//                ticket = validator.validateCash(parsedInput);
//                break;
//            } catch (IllegalArgumentException e) {
//                System.out.println("[ERROR] 구입금액은 1000원 단위이여야 합니다.");
//            }
//        }

        return ticket;
    }

    List<Integer> getRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT_NUMBER);

        return randomNumbers;
    }

    Lotto getLotto() {
        List<Integer> randomNumbers = getRandomNumbers();

        Lotto lotto = new Lotto(randomNumbers);

        return lotto;
    }

    List<Lotto> getLottoBundle(int ticket) {
        List<Lotto> lottoBundle = new ArrayList<>();

        for (int i = 0 ; i < ticket; i++) {
            Lotto lotto = getLotto();
            lottoBundle.add(lotto);
        }

        return lottoBundle;
    }


}
