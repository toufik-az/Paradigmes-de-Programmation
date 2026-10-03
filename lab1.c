#include <stdio.h>
#include <stdbool.h>
#define N 10

int count(bool answers[], int from, int to) {
    int cnt = 0;
    for (int i = from; i <= to; i++) {
        if (answers[i]) {
            cnt++;
        }
    }
    return cnt;
}

void decide(int ext, int intro) {
    if (ext > intro) {
        printf("Result: Extrovert\n");
    } else if (intro > ext) {
        printf("Result: Introvert\n");
    } else {
        printf("Result: Balanced (Ambivert)\n");
    }
}

int main() {
    bool answers[N];
    char answer;

    char quest[N][100] = {
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

    printf("Personality Test\n\n");

    for (int i = 0; i < N; i++) {
        printf("%d. %s (T/F): ", i + 1, quest[i]);

        bool valid = false;

        while (!valid) {
            if (scanf(" %c", &answer) != 1) {
                return 1;
            }

            if (answer == 't' || answer == 'T' ||
                answer == 'f' || answer == 'F') {
                valid = true;
            } else {
                printf("Please enter T or F: ");
            }
        }

        answers[i] = (answer == 't' || answer == 'T');
    }

    int ext = count(answers, 0, 4);
    int intro = count(answers, 5, 9);

    printf("\nExtrovert score: %d\n", ext);
    printf("Introvert score: %d\n", intro);
    decide(ext, intro);

    return 0;
}
