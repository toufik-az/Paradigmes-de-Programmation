import java.util.Scanner;

public class lab1 {
    private boolean[] answers = new boolean[10];

    private String[] quest = {
        "I enjoy going to parties with lots of people.",
        "I find it easy to start conversations with strangers.",
        "I feel comfortable being the center of attention.",
        "I prefer working in a group rather than alone.",
        "I feel more energized after spending time with other people.",
        "I feel more energized after spending time alone.",
        "I prefer listening over talking in group discussions.",
        "I need quiet time to recharge after socializing.",
        "I prefer a quiet night in over a big social event.",
        "I think carefully before speaking in a group."
    };

    public void record(int i, boolean answer) {
        answers[i] = answer;
    }

    public void ask(Scanner sc) {
        for (int i = 0; i < quest.length; i++) {
            String answer;

            do {
                System.out.print((i + 1) + ". " + quest[i] + " (T/F): ");
                answer = sc.nextLine().trim().toLowerCase();
            } while (!answer.equals("t") && !answer.equals("f"));

            record(i, answer.equals("t"));
        }
    }

    public int count(int from, int to) {
        int cnt = 0;
        for (int i = from; i <= to; i++) {
            if (answers[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    public String decide() {
        int ext = count(0, 4);
        int intro = count(5, 9);

        if (ext > intro) {
            return "Extrovert";
        }
        if (intro > ext) {
            return "Introvert";
        }
        return "Balanced (Ambivert)";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lab1 test = new lab1();

        System.out.println("Personality Test\n");
        test.ask(sc);
        
        System.out.println("\nExtrovert score: " + test.count(0, 4));
        System.out.println("Introvert score: " + test.count(5, 9));
        System.out.println("Result: " + test.decide());

        sc.close();
    }
}
