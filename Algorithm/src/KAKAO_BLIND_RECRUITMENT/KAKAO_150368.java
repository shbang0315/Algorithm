package KAKAO_BLIND_RECRUITMENT;

/* 2023 카카오 블라인드 - 개인정보 수집 유효기간
 * https://school.programmers.co.kr/learn/courses/30/lessons/150368
 */

//public class Solution {
public class KAKAO_150368 {
	
	static int[] sales_per = { 40, 30, 20, 10 };
	static int[] temp;
	static int N, M, maxMember, maxMoney;

	public static void main(String[] args) {
//		int[][] users = { { 40, 10000 }, { 25, 10000 } };
//		int[] emoticons = { 7000, 9000 };
		int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
		int[] emoticons = { 1300, 1500, 1600, 4900 };

		solution(users, emoticons);
	}

	public static int[] solution(int[][] users, int[] emoticons) {
		int[] answer = new int[2];

		N = emoticons.length;
		M = sales_per.length;

		temp = new int[N];
		recur(users, emoticons, 0, 0);
		
//		System.out.println(maxMember + " " + maxMoney);
		answer[0] = maxMember;
		answer[1] = maxMoney;
		
		return answer;
	}

	public static void recur(int[][] users, int[] emoticons, int start, int depth) {
		if (depth == N) {

			int regist = 0;
			int[] sumList = new int[users.length];
			int totalSum = 0;
			
			for(int i=0; i<users.length; i++) {
				for(int j=0; j<temp.length; j++) {
					if(sales_per[temp[j]] >= users[i][0]) {
						sumList[i] += emoticons[j] * (100-sales_per[temp[j]]) * 0.01;
					}
				}
			}
			
			for(int i=0; i<sumList.length; i++) {
				// 이모티콘 구매 비용이 사용자 기준 이상이 된다면, 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입한다.
				if(users[i][1] <= sumList[i]) {
					regist += 1;
					sumList[i] = 0;
				}
				
				totalSum += sumList[i];
			}
			
//			System.out.println("regist : " + regist + ", totalSum :  " + totalSum);
			
			if(maxMember < regist) {
				maxMember = Math.max(maxMember, regist);
				maxMoney = totalSum;
			} else if(maxMember == regist) {
//				System.out.println("maxMoney : " + maxMoney + ", totalSum : " + totalSum);
				maxMoney = Math.max(maxMoney, totalSum);
			} else {
				
			}

			return;
		}

		for (int i = 0; i < M; i++) {
			temp[start] = i;
			recur(users, emoticons, start + 1, depth + 1);
		}
	}
}
