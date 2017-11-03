package discount;

public class DiscountANumber implements DiscountStrategy {
    private double num;
    private String name;

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    @Override
    public double getPrice(double price) {
        return price-num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
