public class Solution {
    public int[] solution(int brown, int yellow) {
        // 문제 분석
        // 노란 격자의 개수 : yellow
        // 노란색 가로 격자의 개수 : yWidth
        // 노란색 세로 격자의 개수 : yHeight
        // yellow = yWidth * yHeight 

        // 갈색 격자의 개수 : brown
        // 카펫의 가로 길이 : width
        // 카펫의 세로 길이 : height
        // 테두리 1줄은 갈색으로 칠해져 있다.
        // width = yWidth + 2
        // height = yHeight + 2
        // brown = 2 * width + 2 * (height - 2)

        // total = width * height = yellow + brown
        // height = 2 * (total - 2) / (brown - 2)
        // width = yellow / (height - 2) + 2

        int[] answer = new int[2];
        int total = brown + yellow; // 전체 격자의 개수
        
        for (int i = 3; i < total; i++) { // 카펫의 가로, 세로 길이는 최소 3 이상이다.
            int j = total / i; // j는 카펫의 세로 길이
            
            if (total % i == 0 && j >= 3) {
                // 가로*세로가 격자의 개수이므로 가로, 세로는 total의 약수이다.
                // 제한사항 : 가로는 세로와 같거나 길다.
                int col = Math.max(i, j); // 가로 길이
                int row = Math.min(i, j); // 세로 길이
                // 약수의 집합 중에서 노란색의 가로, 세로가 카펫의 가로, 세로 길이보다 2만큼 작은지 확인한 후 조건이 맞으면 answer 배열에 담는다.
                int center = (col - 2) * (row - 2);
                
                if (center == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }
}