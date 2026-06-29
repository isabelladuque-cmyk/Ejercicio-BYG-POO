package org.isa.payments;

public class CreditCard extends PaymentMethod {
    private String number;
    private String cvv;

    public CreditCard(String number, String cvv) {
    this.number = number;
    this.cvv = cvv;


    @Override
    public void processPayment(double amount) {
        System.out.println("Cobrando " + amount + " a la tarjeta de crédito con el código " + cvv);


    }
}
