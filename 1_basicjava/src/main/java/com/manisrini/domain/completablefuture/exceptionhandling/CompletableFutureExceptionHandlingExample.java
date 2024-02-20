package com.manisrini.domain.completablefuture.exceptionhandling;

import com.manisrini.domain.CardMetaData;
import com.manisrini.domain.completablefuture.CommonUtilityForApiCall;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;


public class CompletableFutureExceptionHandlingExample {


    private String multiTokenSave() {
        CommonUtilityForApiCall commonUtilityForApiCall = new CommonUtilityForApiCall();
        CompletableFuture<CardMetaData> cloud = commonUtilityForApiCall.callDownstream("CLOUD");
        CompletableFuture<CardMetaData> aStatic = commonUtilityForApiCall.callDownstream1("STATIC");
        System.out.println(" before cloud.isCompletedExceptionally():" +  cloud.isCompletedExceptionally());
        System.out.println(" before aStatic.isCompletedExceptionally():" +  aStatic.isCompletedExceptionally());

        CompletableFuture.allOf(aStatic, cloud)
            .handle((result, ex) -> {
                System.out.println("classname in handle method:" + ex.getCause().getClass().getSimpleName());
                return result;
            }).join();
        System.out.println(" after cloud.isCompletedExceptionally():" +  cloud.isCompletedExceptionally());
        System.out.println(" after aStatic.isCompletedExceptionally():" +  aStatic.isCompletedExceptionally());
//        if (cloud.isCompletedExceptionally() && !aStatic.isCompletedExceptionally()) {
//            deleteToken(aStatic, "static");
//        }else if (!cloud.isCompletedExceptionally() && aStatic.isCompletedExceptionally()) {
//            deleteToken(cloud, "cloud");
//        }
        CardMetaData cloudCardMetaData = cloud.whenComplete((res, err) -> {
            if (Objects.nonNull(err) && !aStatic.isCompletedExceptionally()) {
                deleteToken(aStatic, "static");
            }
        }).join();
        System.out.println("why is it success");
        CardMetaData staticCardMetaData = aStatic.whenComplete((res, err) -> {
            if (Objects.nonNull(err) && !cloud.isCompletedExceptionally()) {
                deleteToken(cloud, "cloud");
            }
        }).join();

        return "tokenwrapper";
    }

    private void deleteToken(CompletableFuture<CardMetaData> future, String type) {
        CardMetaData join = future.join();
        System.out.println("delete token called:" + type);
    }


    public static void main(String[] args) {
        CompletableFutureExceptionHandlingExample example = new CompletableFutureExceptionHandlingExample();
        example.multiTokenSave();
    }
}
