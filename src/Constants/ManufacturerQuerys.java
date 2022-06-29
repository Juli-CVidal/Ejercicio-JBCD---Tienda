/*
// Curso Egg FullStack
 */
package Constants;

// @author JulianCVidal
import Domain.Manufacturer;

public class ManufacturerQuerys {

    public static final String GET_ALL_MANUFACTURERS = "SELECT * FROM fabricante;";
  
   

    public static final String GET_MANUFACTURER_BY_ID(int id) {
        return "SELECT * FROM fabricante WHERE codigo = " + id + ";";
    }

    public static final String ADD_MANUFACTURER(Manufacturer manufacturer) {
        return "INSERT INTO fabricante(nombre) "
                + "VALUES ('"+ manufacturer.getName() + "');";
    }

    public static String UPDATE_MANUFACTURER(Manufacturer manufacturer) {
        return "UPDATE fabricante SET "
                + "nombre = '" + manufacturer.getName()
                + "' WHERE codigo = '" + manufacturer.getCode() + "';";
    }
    
    public static final String DELETE_MANUFACTURER(int id){
        return "DELETE FROM fabricante WHERE codigo = " + id + ";";
    }
}
