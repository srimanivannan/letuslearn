package com.manisrini.domain.java8.lamdas;

public class LambdaVsAnonymousClass {
    private String messageValue = "instance value";

    public Welcome getMessageFromAnonymousClass() {

        return new Welcome() {
            String messageValue = "Anonymous message";
            @Override
            public String message() {
                return this.messageValue;
            }
        };
    }

    public Welcome getMessageFromLambdaExpression() {
        String messageValue = "Anonymous message";
        Welcome wel = ()-> {
            return this.messageValue;
        };
        return wel;
    }

    public static void main(String[] args) {
        LambdaVsAnonymousClass t = new LambdaVsAnonymousClass();
        System.out.println(t.getMessageFromLambdaExpression().message());
        System.out.println(t.getMessageFromAnonymousClass().message());
    }
}
