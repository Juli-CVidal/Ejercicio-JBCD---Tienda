/*
// Curso Egg FullStack
 */
package Services;

// @author JulianCVidal
import Constants.Constants;
import Domain.Product;
import Persistance.ProductDAO;

public class ProductService {

    private final ProductDAO dao;

    public ProductService() {
        this.dao = new ProductDAO();
    }

    public void createProduct(String name, Double price, Integer manufacturerCode) throws Exception {
        if (null == manufacturerCode || 0 > manufacturerCode) {
            throw new Exception(Constants.INVALID_MANUFACTURER_CODE);
        }
        validate(name, price);
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setPrice(price);
        newProduct.setManufacturerCode(manufacturerCode);
        dao.saveProduct(newProduct);
    }

    public void enterProduct() throws Exception {
        String name = Input.askString(Constants.ASK_PRODUCT_NAME);
        Double price = Input.askPositiveDouble(Constants.ASK_PRODUCT_PRICE);
        Integer manufacturerCode = Input.askPositiveInteger(Constants.ASK_MANUFACTURER_CODE);
        createProduct(name, price, manufacturerCode);
    }

    public void modifyProduct() throws Exception {
        Integer code = Input.askPositiveInteger(Constants.ASK_PRODUCT_CODE);
        String name = Input.askString(Constants.ASK_PRODUCT_NAME);
        Double price = Input.askPositiveDouble(Constants.ASK_PRODUCT_PRICE);
        modifyProduct(code, name, price);
    }

    public void getProduct() throws Exception {
        Product returnedProduct = getProductById();
        System.out.println(returnedProduct);
    }

    public void deleteProduct() throws Exception {
        Integer code = Input.askPositiveInteger(Constants.ASK_PRODUCT_CODE);
        deleteProduct(code);
    }

    public void showProductName() throws Exception {
        dao.showProductName();
    }

    public void showNameAndPrice() throws Exception {
        dao.showNameAndPrice();
    }

    public void showProductsBetweenPrices() throws Exception {
        dao.showProductsBetweenPrices();
    }

    public void showPortableProducts() throws Exception {
        dao.showPortableProducts();
    }

    public void showCheaperProduct() throws Exception {
        dao.showCheaperProduct();
    }

    public Product getProductById() throws Exception {
        Integer id = Input.askInteger(Constants.ASK_PRODUCT_ID);
        if (null == id || 0 >= id) {
            throw new Exception(Constants.INVALID_ID);
        }
        try {
            Product returnedProduct = dao.getProductById(id);
            if (null == returnedProduct) {
                throw new Exception(Constants.NO_PRODUCT_FOUND);
            }
            return returnedProduct;
        } catch (Exception e) {
            throw e;
        }

    }

    public void modifyProduct(Integer code, String name, Double price) throws Exception {
        if (null == code || 0 > code) {
            throw new Exception();
        }
        validate(name, price);
        Product productToModify = searchById(code);
        dao.updateProduct(productToModify);
    }

    private void validate(String name, Double price) throws Exception {
        if (null == name || name.trim().isEmpty()) {
            throw new Exception(Constants.INVALID_NAME);
        }
        if (null == price || 0 > price) {
            throw new Exception(Constants.INVALID_PRICE);
        }
    }

    public Product searchById(int code) throws Exception {
        try {
            if (0 > code) {
                throw new Exception(Constants.INVALID_ID);
            }
            Product returnedProduct = dao.getProductById(code);
            if (null == returnedProduct) {
                throw new Exception(Constants.NO_PRODUCT_FOUND);
            }
            return returnedProduct;
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteProduct(int code) throws Exception {
        try {
            if (0 > code) {
                throw new Exception(Constants.INVALID_ID);
            }
            dao.deleteProduct(code);
        } catch (Exception e) {
            throw e;
        }
    }
}
