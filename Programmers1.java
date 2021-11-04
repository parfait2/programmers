import java.util.LinkedList;
import java.util.Queue;

public class Programmers1 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] temp = new int[progresses.length];
        int[] leftProg = new int[progresses.length]; // 남은 진도
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 0; i < progresses.length; i++) {
            leftProg[i] = 100 - progresses[i];

            if (leftProg[i] % speeds[i] == 0) {
                queue.add(leftProg[i] / speeds[i]);
            } else {
                queue.add((leftProg[i] / speeds[i]) + 1);
            }
            
        }

        int size = 0;

        while(!queue.isEmpty()) {
            int count = 1;
            int day = queue.poll();

            while(!queue.isEmpty() && day >= queue.peek()) {
                count++;
                queue.poll();
            }
            temp[size] = count;
            size++;
        }


        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
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
