import discount.DiscountStrategy;

public class Printer {
    private String brand;
    private String version;
    private double price;
    DiscountStrategy discountStrategy;
    public void setDiscountStrategy(DiscountStrategy discountStrategy){
        this.discountStrategy=discountStrategy;
    }
    public double getdisPrice(){
        return  discountStrategy.getPrice(price);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Printer(String brand, String version, double price) {
        this.brand = brand;
        this.price = price;
        this.version = version;
    }

    public Printer() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
