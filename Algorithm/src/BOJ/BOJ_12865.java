package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
	
/* 백준 - 평범한 배낭
 * https://www.acmicpc.net/problem/12865
4 7
6 13
4 8
3 6
5 12
*/
	
	static int N, K, answer;
	static int[] W, V;
	static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		W = new int[N+1];
		V = new int[N+1];
		
		DP = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			W[i] = Integer.parseInt(st.nextToken()); // 무게
			V[i] = Integer.parseInt(st.nextToken()); // 가치
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				
				DP[i][j] = DP[i-1][j];
				
				if(W[i] <= j) {
					DP[i][j] = Math.max(DP[i][j], V[i] + DP[i-1][j-W[i]]);
				}
			}
		}
		
		System.out.println(DP[N][K]);

	}
}