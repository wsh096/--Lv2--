package 프로그래머스.Lv2파헤치기;
import java.util.Set;
import java.util.HashSet;
public class 방문길이 {

    private static int solution(String dirs) {
       Set<String> set = new HashSet<>();//방향 저장자.
        int x = 0, y = 0;
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};//방향지시자
        int idx = -1;
        for(char c : dirs.toCharArray()){
            if(c=='U') idx = 0;//상
            else if(c=='D') idx  = 1;//하
            else if(c=='L') idx = 2; //좌
            else if(c=='R') idx = 3; //우
        int nx = x + d[idx][0];//위치 조정
        int ny = y + d[idx][1];//위치 조정
            if(nx < -5 || ny < -5 || nx > 5 ||ny > 5){
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(x).append(y).append(nx).append(ny);
            set.add(sb.toString());//현재위치에서 가는 방향의 값 저장
            sb = new StringBuilder();
            sb.append(nx).append(ny).append(x).append(y);
            set.add(sb.toString());//역방향도 카운팅 한 것이기에 값 저장
            x = nx;
            y = ny; //현재 위치 갱신
        }
        return set.size()/2;//양방향을 넣었기 때문에 절반만
    }
    public static void main(String[] args) {
        System.out.println(solution("LULLLLLLU"));
    }
}

