package kz.designpatterns.adapter.newversion;

/**
 * Created on 19/10/2015.
 */

public interface PayD {
    String getCustCardNo();
    String getCardOwnerName();
    String getCardExpMonthDate();
    Integer getCVVNo();
    Double getTotalAmount();

    void setCustCardNo(String custCardNo);
    void setCardOwnerName(String cardOwnerName);
    void setCardExpMonthDate(String cardExpMonthDate);
    void setCVVNo(Integer cVVNo);
    void setTotalAmount(Double totalAmount);
}
