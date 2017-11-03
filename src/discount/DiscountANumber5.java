package discount;

public class DiscountANumber5 implements DiscountStrategy {
    @Override
    public double getPrice(double price) {
        return price-5;
    }
}
