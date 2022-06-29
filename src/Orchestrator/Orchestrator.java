/*
// Curso Egg FullStack
 */
package Orchestrator;

// @author JulianCVidal
import Constants.Constants;
import Services.Input;
import Services.ManufacturerService;
import Services.ProductService;
import java.util.Objects;


public class Orchestrator {
    public static void mainMenu() throws Exception {
        Integer opc;
        do {
            System.out.println(Constants.MAIN_MENU_OPTIONS);
            opc = Input.askInteger(Constants.ASK_OPTION);

            if (!validateOption(opc, 3)) {
                continue;
            }
            System.out.println();
            switch (opc) {
                case 1: //Product options
                    productOptions();
                    break;
                    
                case 2://Manufacturer options
                    manufacturerOptions();
                    break;
            }
        } while (3 != opc);
    }

    public static void productOptions() throws Exception {
        ProductService productService = new ProductService();
        int opc;
        do {
            System.out.println(Constants.PRODUCT_OPTIONS);
            opc = Input.askInteger(Constants.ASK_OPTION);

            if (!validateOption(opc, 10)) {
                continue;
            }
            System.out.println();

            switch (opc) {
                case 1: //show name of all products
                    productService.showProductName();
                    break;

                case 2: //show name and price of products
                    productService.showNameAndPrice();
                    break;

                case 3: //show all product between prices
                    productService.showProductsBetweenPrices();
                    break;

                case 4: //show portable products
                    productService.showPortableProducts();
                    break;

                case 5: //show the cheapest product
                    productService.showCheaperProduct();
                    break;

                case 6: //enter a product
                    productService.enterProduct();
                    break;

                case 7: //modify a product
                    productService.modifyProduct();
                    break;

                case 8: //get a product
                    productService.getProduct();
                    break;

                case 9: //delete a product
                    productService.deleteProduct();
                    break;
            }

        } while (10 != opc);

    }

    private static void manufacturerOptions() throws Exception {
        ManufacturerService manufacturerService = new ManufacturerService();
        int opc;
        do {
            System.out.println(Constants.MANUFACTURER_OPTIONS);
            opc = Input.askInteger(Constants.ASK_OPTION);
            if (!validateOption(opc, 4)) {
                continue;
            }
            System.out.println();

            switch (opc) {
                case 1: //show all manufacturers
                    manufacturerService.showAllManufacturers();
                    break;
                
                case 2: //enter a manufacturer
                    manufacturerService.enterManufacturer();
                    break;
                case 3:
                    manufacturerService.getManufacturer();
                    break;
            }

        } while (4 != opc);
    }

    private static boolean validateOption(Integer option, Integer lastOption) {
        if (null == option) {
            return false;
        }
        if (1 > option || lastOption < option) {
            System.out.println(Constants.INVALID_OPTION);
            return false;
        }
        if (Objects.equals(option, lastOption)) {
            System.out.println(Constants.EXIT);
            return false;
        } else {
        }
        return true;
    }
}
