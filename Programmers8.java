public class Solution {
    int answer;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        answer = 51;
        visited = new boolean[words.length];
        dfs(begin, target, 0, words);
        return answer == 51 ? 0 : answer;
    }
    
    public void dfs(String str, String target, int count, String[] words) {
        if(str.equals(target)) {
            answer = (answer > count) ? count : answer;
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && check(str, words[i])) {
                visited[i] = true;
                dfs(words[i], target, count + 1, words);
                visited[i] = false;
            }
        }
    }
    
    public boolean check(String str1, String str2) {
        int count = 0;
        
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}