package model;


public class TeaOrder {
    private String customerName;
    private String teaName;
    private String topping;
    private String sweetness;
    private double price;

    // Constructor
    public TeaOrder(String customerName, String teaName, String topping, String sweetness, double price) {
        this.customerName = customerName;
        this.teaName = teaName;
        this.topping = topping;
        this.sweetness = sweetness;
        this.price = price;
    }

    // Getter and Setter methods
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getSweetness() {
        return sweetness;
    }

    public void setSweetness(String sweetness) {
        this.sweetness = sweetness;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
