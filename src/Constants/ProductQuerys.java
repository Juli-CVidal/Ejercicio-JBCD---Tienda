/*
// Curso Egg FullStack
 */
package Constants;

// @author JulianCVidal
import Domain.Product;

public class ProductQuerys {
    public static final String GET_ALL_PRODUCTS = "SELECT * FROM producto;";

    public static final String GET_PRODUCT_BY_ID(int id) {
        return "SELECT * FROM producto where codigo = " + id + ";";
    }

    public static final String GET_PRODUCT_NAMES = "SELECT p.nombre FROM producto p;";

    public static final String GET_PRODUCT_NAME_PRICE = "SELECT p.nombre, p.precio FROM producto p;";

    public static final String GET_PRODUCT_BETWEEN_PRICES = "SELECT p.nombre, p.precio FROM producto p"
            + " WHERE 120 <= p.precio and  202 >= p.precio;";

    public static final String GET_PORTABLE_PRODUCTS = "SELECT p.nombre, p.precio FROM producto p WHERE p.nombre LIKE '%portátil%';";

    public static final String GET_CHEAPER_PRODUCT = "SELECT p.nombre,min(p.precio) FROM producto p;";

    public static String ADD_PRODUCT(Product product) {
        return "INSERT INTO producto(nombre, precio, codigo_fabricante)"
                + " VALUES('" + product.getName() + "', "
                + product.getPrice() + ", "
                + product.getManufacturerCode() + ");";
    }

    public static final String UPDATE_PRODUCT(Product product) {
        return "UPDATE producto SET "
                + "nombre = '" + product.getName()
                + "', precio = " + product.getPrice()
                + ", codigo_fabricante = " + product.getManufacturerCode()
                + " WHERE codigo = '" + product.getCode() + "';";
    }

    public static final String DELETE_PRODUCT(int id) {
        return "DELETE FROM producto WHERE codigo = " + id + ";";
    }
}
