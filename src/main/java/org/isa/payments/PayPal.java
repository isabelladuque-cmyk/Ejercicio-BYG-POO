package org.isa.payments;

public class PayPal extends PaymentMethod {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Cobrando "+ amount+ " a la cuenta PayPal con el email "+ email);
    }
}
