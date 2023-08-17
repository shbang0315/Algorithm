package BOJ;

/* https://www.acmicpc.net/problem/2292
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int num = 1;
		
		if(N == 1) {
			System.out.println(1);
			return;
		}
		
		for(int i=1; ; i++) {
			num += 6*i;
			if(N <= num) {
				System.out.println(i+1);
				break;
			}
		}
	}
}
