package discount;

public interface DiscountStrategy {
    public double getPrice(double price);
    public String getName();
}
