package discount;

public class DiscountPercent5 implements DiscountStrategy {
    @Override
    public double getPrice(double price) {
        return price*(1-5*0.01);
    }
}
