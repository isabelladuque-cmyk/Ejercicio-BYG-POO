package org.isa.information;

import org.isa.discount.system.Discount;
import org.isa.payments.PaymentMethod;
import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products = new ArrayList<>();
    private PaymentMethod paymentMethod;
    private Discount discount;
    private boolean isCompleted = false;

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        }
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (Product p : products) {
            subtotal = subtotal + p.getPrice();
        }
        return subtotal;
    }

    public double calculateFinalTotal() {
        double total = calculateSubtotal();

        if (discount != null) {
            total = total - discount.applyDiscount(total);
        }

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    public void processOrder() {
        if (paymentMethod == null) {
            System.out.println("Error: No se puede procesar el pedido sin medio de pago.");
            return;
        }

        double finalAmount = calculateFinalTotal();
        paymentMethod.processPayment(finalAmount);
        this.isCompleted = true;
    }

    public void showOrderSummary() {
        System.out.println("Productos en el pedido:");
        for (Product p : products) {
            System.out.println("  - " + p.getName() + " ($" + p.getPrice() + ")");
        }

        System.out.println("Subtotal: $" + calculateSubtotal());

        if (discount != null) {
            System.out.println("Descuento: " + discount.getDescription());
        } else {
            System.out.println("Descuento: Ninguno");
        }

        System.out.println("Valor Final: $" + calculateFinalTotal());

        if (isCompleted) {
            System.out.println("Estado: Completado");
        } else {
            System.out.println("Estado: Pendiente");
        }
    }
}