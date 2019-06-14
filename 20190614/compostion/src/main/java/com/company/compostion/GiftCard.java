package com.company.compostion;

public class GiftCard {
    private String cardNum;
    private double currentBalance;
    private double originalBalance;
    private String exprDate;
    private String issuer;

    public GiftCard(String cardNum, double originalBalance, String exprDate, String issuer) {
        this.cardNum = cardNum;
        this.originalBalance = originalBalance;
        this.currentBalance = originalBalance;
        this.exprDate = exprDate;
        this.issuer = issuer;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getExprDate() {
        return exprDate;
    }

    public void setExprDate(String exprDate) {
        this.exprDate = exprDate;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public double getOriginalBalance() {
        return originalBalance;
    }

    public void setOriginalBalance(double originalBalance) {
        this.originalBalance = originalBalance;
    }
}
