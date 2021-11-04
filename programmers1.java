public class programmers1 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] temp = new int[progresses.length];
        int[] leftDay = new int[progresses.length]; // 남은 일수
        int[] leftProg = new int[progresses.length]; // 남은 진도율
        
        for (int i = 0; i < progresses.length; i++) {
            leftProg[i] = 100 - progresses[i];

            if (leftProg[i] % speeds[i] == 0) {
                leftDay[i] = leftProg[i] / speeds[i];
            } else {
                leftDay[i] = (leftProg[i] / speeds[i]) + 1;
            }
            
        }

        int count = 1;
        int k = 0;
        
        for (int i = 0; i < leftDay.length; i++) {
            if (i == leftDay.length - 1) {
                temp[k] = count;
            } else if (leftDay[i] >= leftDay[i+1]) {
                count++;
            }
            else {
                temp[k] = count;
                count++;
                k++;
                count = 1;
            }
        }

        int[] answer = new int[k+1];

        for (int i = 0; i <= k; i++) {
            answer[i] = temp[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] temp = solution(progresses, speeds);

        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }
}
