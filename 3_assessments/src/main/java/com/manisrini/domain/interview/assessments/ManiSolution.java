package com.manisrini.domain.interview.assessments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class ManiSolution {

  public static void main(String[] args) {
    ManiSolution texst = new ManiSolution();
    System.out.println(texst.maxSumTwoNoOverlap(new int[]{6,1,4,6,3,2,7,4}, 3, 2));
    //System.out.println(texst.maxSumTwoNoOverlap(new int[]{12,54,54,1}, 2, 1));
  }
  public int maxSumTwoNoOverlap(int[] A, int K, int L) {
//      int alice = Arrays.stream(A).limit(K).sum(); //13
//      System.out.println("alice:" + alice);
//      int bob = Arrays.stream(A).skip(K).limit(L).sum();
//      System.out.println("bob:" + bob);
//      return alice+bob;
    int alice = Arrays.stream(A).boxed().sorted(Comparator.reverseOrder()).limit(K)
        .reduce(Integer::sum).orElse(0);
    System.out.println("alice:" + alice);
    int bob = Arrays.stream(A).boxed()
        .sorted(Comparator.reverseOrder())
        .skip(K).distinct().limit(L).reduce(Integer::sum).orElse(0);
    return alice + bob;
  }
}
