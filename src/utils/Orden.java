package utils;

public class Orden {
    private int orderId;
    private double monto;

    // Constructor
    public Orden(int orderId, double monto) {
        this.orderId = orderId;
        this.monto = monto;
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public double getMonto() {
        return monto;
    }

    // Overriding toString para facilitar la visualización
    @Override
    public String toString() {
        return "Orden{" +
                "orderId=" + orderId +
                ", monto=" + monto +
                '}';
    }
}
