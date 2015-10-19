package kz.designpatterns.adapter;

import kz.designpatterns.adapter.newversion.PayD;
import kz.designpatterns.adapter.oldversion.Xpay;
import kz.designpatterns.adapter.oldversion.XpayImpl;

/**
 * Created on 19/10/2015.
 */

public class RunAdapterExample {

    public static void main(String[] args) {
        Xpay xpay = new XpayImpl();
        xpay.setCreditCardNo("4789565874102365");
        xpay.setCustomerName("Max Warner");
        xpay.setCardExpMonth("09");
        xpay.setCardExpYear("25");
        xpay.setCardCVVNo((short) 235);
        xpay.setAmount(2565.23);

        PayD payD = new XpayToPayDAdapter(xpay);
        print(payD);
    }

    private static void print(PayD payD) {
        System.out.println(payD.getCardOwnerName());
        System.out.println(payD.getCustCardNo());
        System.out.println(payD.getCardExpMonthDate());
        System.out.println(payD.getCVVNo());
        System.out.println(payD.getTotalAmount());
    }
}