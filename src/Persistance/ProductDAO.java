/*
// Curso Egg FullStack
 */
package Persistance;

// @author JulianCVidal
import Constants.Constants;
import Constants.ProductQuerys;
import Domain.Product;
import java.sql.SQLException;
import java.util.ArrayList;

public final class ProductDAO extends DAO {

    public ArrayList<Product> getAllProducts() throws Exception {
        ArrayList<Product> productList = new ArrayList();
        try {
            consultInBase(ProductQuerys.GET_ALL_PRODUCTS);
            Product returnedProduct;
            while (result.next()) {
                returnedProduct = new Product();
                returnedProduct.setCode(result.getInt(1));
                returnedProduct.setName(result.getString(2));
                returnedProduct.setPrice(result.getDouble(3));
                returnedProduct.setManufacturerCode(result.getInt(4));
                productList.add(returnedProduct);
            }

            //productList.forEach((product) -> System.out.println(product.getName()));
            return productList;
        } catch (SQLException e) {
            throw e;
        } finally {
            disconnectToBase();
        }
    }

    public void showProductName() throws Exception {
        ArrayList<Product> productList = new ArrayList();
        try {
            consultInBase(ProductQuerys.GET_PRODUCT_NAMES);
            Product returnedProduct;
            while (result.next()) {
                returnedProduct = new Product();
                returnedProduct.setName(result.getString(1));
                productList.add(returnedProduct);
            }

            productList.forEach((product) -> System.out.println(product.getName()));
        } catch (SQLException e) {
            throw e;
        } finally {
            disconnectToBase();
        }
    }

    public void showNameAndPrice() throws Exception {
        ArrayList<Product> productList = new ArrayList();
        try {
            consultInBase(ProductQuerys.GET_PRODUCT_NAME_PRICE);
            Product returnedProduct;
            while (result.next()) {
                returnedProduct = new Product();
                returnedProduct.setName(result.getString(1));
                returnedProduct.setPrice(result.getDouble(2));
                productList.add(returnedProduct);
            }

            productList.forEach((product) -> System.out.println(product.getName() + ": $" + product.getPrice()));
        } catch (SQLException e) {
            throw e;
        } finally {
            disconnectToBase();
        }
    }

    public void showProductsBetweenPrices() throws Exception {
        ArrayList<Product> productList = new ArrayList();
        try {
            consultInBase(ProductQuerys.GET_PRODUCT_BETWEEN_PRICES);
            Product returnedProduct;
            while (result.next()) {
                returnedProduct = new Product();
                returnedProduct.setName(result.getString(1));
                returnedProduct.setPrice(result.getDouble(2));
                productList.add(returnedProduct);
            }

            productList.forEach((product) -> System.out.println(product.getName() + ": $" + product.getPrice()));
        } catch (SQLException e) {
            throw e;
        } finally {
            disconnectToBase();
        }
    }

    public void showPortableProducts() throws Exception {
        ArrayList<Product> productList = new ArrayList();
        try {
            consultInBase(ProductQuerys.GET_PORTABLE_PRODUCTS);
            Product returnedProduct;
            while (result.next()) {
                returnedProduct = new Product();
                returnedProduct.setName(result.getString(1));
                returnedProduct.setPrice(result.getDouble(2));
                productList.add(returnedProduct);
            }

            productList.forEach((product) -> System.out.println(product.getName() + ": $" + product.getPrice()));
        } catch (SQLException e) {
            throw e;
        } finally {
            disconnectToBase();
        }
    }

    public void showCheaperProduct() throws Exception {
        try {
            consultInBase(ProductQuerys.GET_PRODUCT_BETWEEN_PRICES);
            Product returnedProduct = new Product();
            while (result.next()) {
                returnedProduct.setName(result.getString(1));
                returnedProduct.setPrice(result.getDouble(2));
            }

            System.out.println(returnedProduct);
        } catch (SQLException e) {
            throw e;
        } finally {
            disconnectToBase();
        }
    }

    public Product getProductById(int id) throws Exception {
        try {
            consultInBase(ProductQuerys.GET_PRODUCT_BY_ID(id));
            Product returnedProduct = new Product();
            while (result.next()) {
                returnedProduct.setCode(result.getInt(1));
                returnedProduct.setName(result.getString(2));
                returnedProduct.setPrice(result.getDouble(3));
                returnedProduct.setManufacturerCode(result.getInt(4));
            }
            return returnedProduct;
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectToBase();
        }
    }

    public void saveProduct(Product product) throws Exception {
        System.out.println(ProductQuerys.ADD_PRODUCT(product));
        sendModifierQuery(ProductQuerys.ADD_PRODUCT(product));
    }

    public void updateProduct(Product product) throws Exception {
        try {
            if (null == product) {
                throw new Exception(Constants.NO_PRODUCT_INDICATED);
            }
            sendModifierQuery(ProductQuerys.UPDATE_PRODUCT(product));
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteProduct(int id) throws Exception {
        sendModifierQuery(ProductQuerys.DELETE_PRODUCT(id));
    }

    private void showProducts(ArrayList<Product> productList) {
        productList.forEach(System.out::println);
    }

}
