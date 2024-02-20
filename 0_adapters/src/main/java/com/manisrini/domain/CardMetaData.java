package com.manisrini.domain;

import java.time.Instant;

import lombok.Data;

@Data
public class CardMetaData {
    private String cardId;
    private String tokenRequestorId;
    private String hashedPan;
    private String expiryDate;
    private String consumerId;
    private String primaryAccountNumberSource;
    private String primaryAccountNumberSuffix;
    private String cardIdStatus;
    private String encryptedCardCriticalData;
    private String cardArtUrl;
    private String cardUniqueReference;
    private String hashedToken;
    private String programId;
    private Boolean isVerified;

    private Instant cardCreatedTimestamp;

    private Instant lastUsedTimestamp;

    private Boolean isAuthRequired;
    private String primaryAccountNumberPrefix;
    private String correlationId;

    private String pushAccReceipt;

    private String avsResponseCode;
    private Boolean authenticated;
    private String paymentCardType;
    private String issuerCountryCode;
    private String issuerCustomerId;

    private Instant lastUpdatedTimestamp;

    private String sourceCardId;
    private String sourceProgramId;
    private Boolean isAddressVerificationRequired;
    private String enrollmentSourceReference;
}
