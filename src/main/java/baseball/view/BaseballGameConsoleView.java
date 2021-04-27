package baseball.view;


public class BaseballGameConsoleView implements BaseballGameView {

    @Override
    public void showBallCountMessage(int[] result) {
        StringBuilder sb = new StringBuilder();
        int strike = result[0];
        int ball = result[1];
        if (hasNonCount(strike, ball)) {
            System.out.println(sb.append("낫씽"));
            return;
        }

        appendMessageIfExists(strike, ball, sb, strike + " 스트라이크");
        appendMessageIfExists(ball, sb, ball + " 볼");

        System.out.println(sb);
    }

    @Override
    public void showAskingForInputMessage() {
        System.out.print("숫자를 입력해주세요:");
    }

    @Override
    public boolean showFinishMessage(boolean roundFinished) {
        if (roundFinished) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료.");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        return roundFinished;
    }

    private void appendMessageIfExists(int strike, int ball, StringBuilder sb, String str) {
        if (isNotZero(strike)) {
            sb.append(str);
            appendMessageIfExists(ball, sb, " ");
        }
    }

    private void appendMessageIfExists(int ball, StringBuilder sb, String message) {
        if (isNotZero(ball)) {
            sb.append(message);
        }
    }

    private boolean isNotZero(int num) {
        return num != 0;
    }

    private boolean hasNonCount(int strike, int ball) {
        return strike == 0 && ball == 0;
    }


}