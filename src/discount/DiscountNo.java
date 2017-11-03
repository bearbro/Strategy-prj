package discount;

public class DiscountNo implements DiscountStrategy {

    private String name;

    @Override
    public double getPrice(double price) {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
