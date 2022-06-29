/*
// Curso Egg FullStack
 */
package Services;

// @author JulianCVidal
import Constants.Constants;
import Domain.Manufacturer;
import Persistance.ManufacturerDAO;

public class ManufacturerService {

    private final ManufacturerDAO dao;

    public ManufacturerService() {
        this.dao = new ManufacturerDAO();
    }

    public void showAllManufacturers() throws Exception {
        dao.showAllManufacturers();
    }

    public void createManufacturer(String name) throws Exception {
        if (null == name || name.trim().isEmpty()) {
            throw new Exception(Constants.INVALID_NAME);
        }
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setName(name);
        dao.saveManufacturer(newManufacturer);
    }

    public void modifyManufacturer(Integer code, String name) throws Exception {
        validate(code, name);
        Manufacturer manufacturerToModify = searchById(code);
        dao.updateManufacturer(manufacturerToModify);
    }

    public Manufacturer searchById(int code) throws Exception {
        try {
            if (0 > code) {
                throw new Exception(Constants.INVALID_ID);
            }
            Manufacturer returnedManufacturer = dao.getManufacturerById(code);
            return returnedManufacturer;
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteManufacturer(int code) throws Exception {
        try {
            if (0 > code) {
                throw new Exception(Constants.INVALID_ID);
            }
            dao.deleteManufacturer(code);
        } catch (Exception e) {
            throw e;
        }
    }

    private void validate(Integer code, String name) throws Exception {
        if (null == code || 0 > code) {
            throw new Exception(Constants.INVALID_ID);
        }
        if (null == name || name.trim().isEmpty()) {
            throw new Exception(Constants.INVALID_NAME);
        }
    }

    public void enterManufacturer() throws Exception {
        String name = Input.askString(Constants.ASK_MANUFACTURER_NAME);
        createManufacturer(name);
    }

    public void getManufacturer() throws Exception {
        Manufacturer returnedManufacturer = getManufacturerById();
        System.out.println(returnedManufacturer);
    }

    private Manufacturer getManufacturerById() throws Exception {
        Integer id = Input.askInteger(Constants.ASK_MANUFACTURER_CODE);
        if (null == id || 0 >= id) {
            throw new Exception(Constants.INVALID_ID);
        }
        try {
            Manufacturer returnedManufacturer = dao.getManufacturerById(id);
            if (null == returnedManufacturer) {
                throw new Exception(Constants.NO_MANUFACTURER_FOUND);
            }
            return returnedManufacturer;
        } catch (Exception e) {
            throw e;
        }
    }
}
