class Scorecard {
    private boolean[] results;
    private int count;

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.count = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (this.count < this.results.length) {
            this.results[this.count] = isCorrect;
            this.count++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.results[i]) {
                score++;
            }
        }
        return score;
    }
}

public class ScorecardMain {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println(sc.getScore());
    }
}