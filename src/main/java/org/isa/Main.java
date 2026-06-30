package org.isa;

import org.isa.discount.system.Discount;
import org.isa.discount.system.FixedDiscount;
import org.isa.discount.system.PercentageDiscount;
import org.isa.information.Order;
import org.isa.information.Product;
import org.isa.payments.CreditCard;
import org.isa.payments.PayPal;
import org.isa.payments.PaymentMethod;
import org.isa.services.OrderManagement;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Computador Portátil", 2500.0);
        Product p2 = new Product("Mouse Óptico", 50.0);
        Product p3 = new Product("Teclado Mecánico", 120.0);

        OrderManagement administrador = new OrderManagement();

        Order pedido1 = new Order();
        pedido1.addProduct(p1);
        pedido1.addProduct(p2);

        PaymentMethod tarjeta = new CreditCard("1234567812345678", "123");
        Discount descuentoFijo = new FixedDiscount(100.0);

        pedido1.setPaymentMethod(tarjeta);
        pedido1.setDiscount(descuentoFijo);


        administrador.saveOrder(pedido1);


        Order pedido2 = new Order();
        pedido2.addProduct(p2);
        pedido2.addProduct(p3);


        PaymentMethod paypal = new PayPal("isas@autonoma.edu.co");
        Discount descuentoPorcentaje = new PercentageDiscount(15.0);

        pedido2.setPaymentMethod(paypal);
        pedido2.setDiscount(descuentoPorcentaje);

        administrador.saveOrder(pedido2);

        System.out.println("PROCESANDO TODOS LOS PEDIDOS DE LA EMPRESA ");
        administrador.processAllOrders();
    }
}