package org.isa.discount.system;

public class FixedDiscount extends Discount {
    private double discountDeducted;

    public FixedDiscount(double fixedDiscount) {
        this.discountDeducted = fixedDiscount;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return "Cupón de descuento fijo por: " + discountDeducted);
    }
}
