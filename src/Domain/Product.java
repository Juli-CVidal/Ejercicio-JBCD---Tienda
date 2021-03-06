/*
// Curso Egg FullStack
 */

package Domain;

// @author JulianCVidal


public class Product {
    private int code;
    private String name;
    private double price;
    private Manufacturer manufacturer; //product.getManufacturer().getId();
    private int manufacturerCode;

    public Product() {
    }

    public Product(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(int manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    @Override
    public String toString() {
        return name + ",code: " + code + "," +  " $" + price
               + "\nfabricantCode: " + manufacturerCode;
    }
}
