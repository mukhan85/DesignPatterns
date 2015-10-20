package kz.designpatterns.adapter;

import kz.designpatterns.adapter.newversion.PayD;
import kz.designpatterns.adapter.oldversion.Xpay;

/**
 * Created on 19/10/2015.
 */

public class XpayToPayDAdapter implements PayD {
    private String custCardNo;
    private String cardOwnerName;
    private String cardExpMonthDate;
    private Integer cVVNo;
    private Double totalAmount;

    private final Xpay xpay;

    public XpayToPayDAdapter(Xpay xpay) {
        this.xpay = xpay;
        setProp();
    }

    public String getCustCardNo() {
        return custCardNo;
    }

    public String getCardOwnerName() {
        return cardOwnerName;
    }

    public String getCardExpMonthDate() {
        return cardExpMonthDate;
    }

    public Integer getCVVNo() {
        return cVVNo;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setCustCardNo(String custCardNo) {
        this.custCardNo = custCardNo;
    }

    public void setCardOwnerName(String cardOwnerName) {
        this.cardOwnerName = cardOwnerName;
    }

    public void setCardExpMonthDate(String cardExpMonthDate) {
        this.cardExpMonthDate = cardExpMonthDate;
    }

    public void setCVVNo(Integer cVVNo) {
        this.cVVNo = cVVNo;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    private void setProp() {
        setCardOwnerName(this.xpay.getCustomerName());
        setCustCardNo(this.xpay.getCreditCardNo());
        setCardExpMonthDate(this.xpay.getCardExpMonth() + "/" + this.xpay.getCardExpYear());
        setCVVNo(this.xpay.getCardCVVNo().intValue());
        setTotalAmount(this.xpay.getAmount());
    }

}
