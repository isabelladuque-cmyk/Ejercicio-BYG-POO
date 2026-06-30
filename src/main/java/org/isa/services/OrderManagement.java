package org.isa.services;

import org.isa.information.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderManagement {
    private List<Order> pendingOrders = new ArrayList<>();

    public void saveOrder(Order order) {
        if (order != null) {
            pendingOrders.add(order);
        }
    }

    public List<Order> getPendingOrders() {
        return pendingOrders;
    }

    public void processAllOrders() {
        if (pendingOrders.isEmpty()) {
            System.out.println("No hay pedidos pendientes por procesar.");
            return;
        }

        for (Order order : pendingOrders) {
            order.processOrder();
        }

        pendingOrders.clear();
        System.out.println("Todos los pedidos han sido procesados");
    }
}