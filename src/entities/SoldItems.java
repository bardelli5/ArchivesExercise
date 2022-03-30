package entities;

public class SoldItems {
    private String name;
    private Double price;
    private Integer quantity;

    public SoldItems() {
    }

    public SoldItems(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double totalValue() {
        return  price * quantity;
    }

    @Override
    public String toString() {
        return name + "," + String.format("%.2f", price) + "," + quantity;
    }
}
