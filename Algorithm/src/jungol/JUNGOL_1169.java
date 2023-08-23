package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 정올
 * https://jungol.co.kr/problem/1169
 * 주사위 던지기1
 * 순열 조합 문제
 */

//public class Main {
public class JUNGOL_1169 {
	static int N, M;
    static int[] temp;
    static boolean[] mask;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
         
        mask = new boolean[7];
        temp = new int[7];
        temp[0] = 1;
         
        if(M == 1) {
            dice1(1, 0);
        } else if(M == 2) {
            dice2(1, 0);
        } else if(M == 3) {
            dice3(1, 0);
        }
    }
     
    public static void dice1(int start, int depth) {
        if(depth == N) {
            for(int i=1; i<=depth; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=6; i++) {
            temp[start] = i;
            dice1(start+1, depth+1);
        }
    }
     
    public static void dice2(int start, int depth) {
        if(depth == N) {
            for(int i=1; i<=depth; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=temp[start-1]; i<=6; i++) {
            temp[start] = i;
            dice2(start+1, depth+1);
        }
    }
     
    public static void dice3(int start, int depth) {
        if(depth == N) {
            for(int i=1; i<=depth; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=6; i++) {
            if(mask[i]) continue;
            temp[start] = i;
            mask[i] = true;
            dice3(start+1, depth+1);
            mask[i] = false;
        }
    }
}
