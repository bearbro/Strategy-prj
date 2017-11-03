package discount;

public class DiscountNo implements DiscountStrategy {

    @Override
    public double getPrice(double price) {
        return price;
    }
}
