package org.isa.discount.system;

public class FixedDiscount extends Discount {
    private double discountDeducted;

    public FixedDiscount(double fixedDiscount) {
        if (fixedDiscount < 0) {
            throw new RuntimeException("El descuento no puede ser negativo");
        }
        this.discountDeducted = fixedDiscount;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return Math.min(discountDeducted, totalAmount);
    }

    @Override
    public String getDescription() {
        return "Cupón de descuento fijo por: $" + discountDeducted;
    }
}