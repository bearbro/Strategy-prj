package discount;

public class DiscountPercent implements DiscountStrategy {
    private double percent;
    private String name;

    @Override
    public double getPrice(double price) {
        return price*(1-percent);
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
