public class Solution {
    
    // 문제 분석
    // 각각이 정해진 패턴을 n번씩 반복한다.

    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] student1 = new int[]{1, 2, 3, 4, 5}; // 원소의 개수 : 5
        int[] student2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5}; // 원소의 개수 : 8
        int[] student3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 원소의 개수 : 10
        int[] score = new int[3]; // 수포자 세 명의 점수를 담을 배열을 선언한다.

        for (int i = 0; i < answers.length; i++ ) {
            if (answers[i] == student1[i % 5]) score[0]++;
            if (answers[i] == student2[i % 8]) score[1]++;
            if (answers[i] == student3[i % 10]) score[2]++;
        }

        // 세 번의 단순 brute-force
        int max = 0; // 최고점
        
        for (int i = 0; i < score.length; i++ ) {
            if (score[i] > max) {
                max = score[i]; // 순차적으로 값을 비교해서 점수의 최댓값 갱신.
            }
        }

        int maxCount = 0; // 최고점 득점자 수

        for (int i = 0; i < score.length; i++ ) {
            if (score[i] == max) {
                maxCount++;
            }
        }

        answer = new int[maxCount]; // 최고점 득점자 수 크기의 배열을 만들어서 가장 많은 문제를 맞힌 사람을 배열에 담는다.
        
        int index = 0;

        for (int i = 0; i < score.length; i++ ) {
            if (score[i] == max) {
                answer[index++] = i + 1; // 수포자 1, 2, 3번은 (배열의 위치 + 1)번째에 있다.
            }
        }
        return answer;
    }
}