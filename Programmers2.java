import java.util.LinkedList;
import java.util.Queue;

public class Programmers2 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> tempQueue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(priorities[i]);
        }
        for (int i = 0; i < priorities.length; i++) {
            tempQueue.offer(priorities[i]);
        }

        int indexValue = tempQueue.poll();
        int count = 0;
        int temp = 0;
        int request = 0;

        while(!tempQueue.isEmpty()) {
            System.out.println("indexValue : " + indexValue);


            while(!tempQueue.isEmpty()) {


                if (indexValue < tempQueue.peek()) {
                    System.out.println("tempQueue.peek() : " + tempQueue.peek());
                    queue.poll();
                    queue.offer(indexValue);
                    System.out.print(queue.peek() + " ");

                    if (location > 0) {
                        location--;
                    } else {
                        location = queue.size() - 1;
                    }
                    System.out.println("location : " + location);


                    break;
                } else {
                    int temp1 = tempQueue.poll();
                    System.out.println("tempQueue.poll() : " + temp1);
                }
            }



            indexValue = queue.peek();

            
            System.out.println("indexValue : " + indexValue);

                
        }
        answer = location + 1;
        System.out.println("answer : " + answer);

        return answer;
    }
    public static void main(String[] args) {
        int[] priorities = {5,4,2,7,5}; // {1,2,9,3,2,2,1,3,2,3};
        int location = 4;
        int ans = solution(priorities, location);
        System.out.println("답 : " + ans);
    }
}
