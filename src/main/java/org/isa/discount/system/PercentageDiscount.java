package org.isa.discount.system;

public class PercentageDiscount extends Discount {
    private double percentage;

    public PercentageDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new RuntimeException("El porcentaje de descuento debe estar entre 0 y 100.");
        }
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * (percentage / 100);
    }

    @Override
    public String getDescription() {
        return "Porcentaje del descuento " + this.percentage;
    }
}
