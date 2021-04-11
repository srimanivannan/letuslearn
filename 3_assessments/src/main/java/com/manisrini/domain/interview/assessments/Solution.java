package com.manisrini.domain.interview.assessments;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.pickApples(new int[]{12,54,54,1}, 2, 1));
  }

  public int pickApples(int[] A, int K, int L) {
    // write your code here

    if (K + L > A.length) {
      return -1;
    }

    // calculate prefix

    int[] prefixSum = new int[A.length + 1];

    for (int i = 0; i < A.length; i++) {
      prefixSum[i+1] = prefixSum[i] + A[i];
    }

    // first choose K, then L

    int max = 0;
    int maxSumK = 0;

    for (int i = 0; i + K + L <= A.length; i++ ) {

      maxSumK = Math.max(prefixSum[i + K] - prefixSum[i], maxSumK);

      max = Math.max(maxSumK + prefixSum[i + K + L] - prefixSum[i + K], max);
    }

    // first choose L then K

    int maxSumL = 0;
    for (int i = 0; i + K + L <= A.length; i++ ) {

      maxSumL = Math.max(prefixSum[i + L] - prefixSum[i], maxSumL);

      max = Math.max(maxSumL + prefixSum[i + K + L] - prefixSum[i + L], max);
    }

    return max;

  }
}