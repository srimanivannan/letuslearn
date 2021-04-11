package com.manisrini.domain._1_oops.variables;

public class Concept_1_Variables {

  public boolean a;//don't have to initialize the instance variables
  @SuppressWarnings("unused")
  private int b;//can be private modifier
  int c;//with no modifier
  protected int d;//can be protected
  final int e = 10;//can be final. but it must be Initialized
  static int f;//can be static.may not be finalized
  static final int g = 18;//can be static and final
  final String pancard;

  public Concept_1_Variables() {
    pancard = "number";
  }

  public void testInstanceVariables() {
    System.err.println("a value=>" + a);

  }

  public void localVariables() {
    final int a = 5;
    //must be declared with in a block of code
    //Must be initialized
    //no modifiers like public or private or protected or static
    // can be finalized
    System.err.println("local variable a value=>" + a);
  }

  /*
   * Instance variables
   * Local Variables
   * Final Variables
   * Static Variables
   * Reference Variables-> Example Concept_1_Variables concept_1_variables; is reference variable;
   */
  public static void main(String[] args) {
    Concept_1_Variables concept_1_variables = new Concept_1_Variables();
    concept_1_variables.testInstanceVariables();
    new Concept_1_Variables().localVariables();
  }

}
