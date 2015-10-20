package kz.designpatterns.adapter;

import kz.designpatterns.adapter.newversion.PayD;
import kz.designpatterns.adapter.oldversion.Xpay;
import kz.designpatterns.adapter.oldversion.XpayImpl;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 20/10/2015.
 */

public class XpayToPayDAdapterTest {
    @Test
    public void shouldConvertToPayDObject() {
        Xpay xpay = new XpayImpl();
        xpay.setCreditCardNo("4789565874102365");
        xpay.setCustomerName("Max Warner");
        xpay.setCardExpMonth("09");
        xpay.setCardExpYear("25");
        xpay.setCardCVVNo((short) 235);
        xpay.setAmount(2565.23);

        PayD payD = new XpayToPayDAdapter(xpay);
        assertThat("Should have same cardNumber", xpay.getCreditCardNo(), is(payD.getCustCardNo()));
    }
}