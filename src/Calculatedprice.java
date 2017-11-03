import discount.DiscountStrategy;

public class Calculatedprice {
    DiscountStrategy discountStrategy;
    public void setDiscountStrategy(DiscountStrategy discountStrategy){
        this.discountStrategy=discountStrategy;
    }
    public double getPrice(double price){
        return  discountStrategy.getPrice(price);
    }

}
