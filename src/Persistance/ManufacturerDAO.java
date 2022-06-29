/*
// Curso Egg FullStack
 */
package Persistance;

// @author JulianCVidal
import Constants.Constants;
import Constants.ManufacturerQuerys;

import Domain.Manufacturer;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManufacturerDAO extends DAO {

    public ArrayList<Manufacturer> getAllManufacturers() throws Exception {
        ArrayList<Manufacturer> manufacturerList = new ArrayList();
        try {
            consultInBase(ManufacturerQuerys.GET_ALL_MANUFACTURERS);
            Manufacturer returnedManufacturer;
            while (result.next()) {
                returnedManufacturer = new Manufacturer();
                returnedManufacturer.setCode(result.getInt(1));
                returnedManufacturer.setName(result.getString(2));
                manufacturerList.add(returnedManufacturer);
            }
            return manufacturerList;
        } catch (SQLException e) {
            throw e;
        } finally {
            disconnectToBase();
        }
    }

    public void saveManufacturer(Manufacturer manufacturer) throws Exception {
        sendModifierQuery(ManufacturerQuerys.ADD_MANUFACTURER(manufacturer));
    }

    public Manufacturer getManufacturerById(int id) throws Exception {
        try {
            consultInBase(ManufacturerQuerys.GET_MANUFACTURER_BY_ID(id));
            Manufacturer returnedManufacturer = new Manufacturer();
            while (result.next()) {
                returnedManufacturer.setCode(result.getInt(1));
                returnedManufacturer.setName(result.getString(2));
            }
            return returnedManufacturer;
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectToBase();
        }
    }

    public void updateManufacturer(Manufacturer manufacturer) throws Exception {
        try {
            if (null == manufacturer) {
                throw new Exception(Constants.NO_MANUFACTURER_INDICATED);
            }
            sendModifierQuery(ManufacturerQuerys.UPDATE_MANUFACTURER(manufacturer));
        } catch (Exception e) {
            throw e;
        }
    }

    public void showAllManufacturers() throws Exception{
        getAllManufacturers().forEach(System.out::println);
    }
    public void deleteManufacturer(int id) throws Exception {
        sendModifierQuery(ManufacturerQuerys.DELETE_MANUFACTURER(id));
    }
}
