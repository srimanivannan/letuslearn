package com.manisrini.domain.completablefuture;



import com.manisrini.domain.CardMetaData;

import java.util.concurrent.CompletableFuture;

public class CommonUtilityForApiCall {

    public CompletableFuture<CardMetaData> callDownstream(String tokenType) {
        CompletableFuture<CardMetaData> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("tokenType:" + tokenType);
//            return null;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //throw new TechnicalException();
            CardMetaData cardMetaData = new CardMetaData();
            cardMetaData.setCardId("static card id");
            return cardMetaData;
        });
        return future;
    }

    public CompletableFuture<CardMetaData> callDownstream1(String tokenType) {
        CompletableFuture<CardMetaData> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("tokenType:" + tokenType);
//            return null;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
                throw new RuntimeException();
//            CardMetaData cardMetaData = new CardMetaData();
//            cardMetaData.setCardId("static card id");
//            return cardMetaData;
        });
        return future;
    }

}
