package com.manisrini.domain.interview.myworkouts;

class SendDocument {
  {
    System.out.println("In SendDocument");
  }
  public SendDocument() {
    System.out.println("start to send document");
  }
}
class EmailDocument extends SendDocument {
  static {
    System.out.println("In Email doc");
  }
}

public class Cool {

}
