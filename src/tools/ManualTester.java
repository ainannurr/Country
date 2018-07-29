/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.CountryController;
import entities.Country;
import java.sql.Connection;

/**
 *
 * @author Ignatius
 */
public class ManualTester {

    public static void main(String[] args) {
        Connection connection = new MyConnection().getConnection();
        String countryId = "ID";
        String countryName = "Indonesia";
        int regionId = 2;
        CountryController countryController = new CountryController(connection);
//        System.out.println(countryController.save(countryId, countryName, region.getRegionId()));
//        System.out.println(countryController.edit(countryId, countryName, regionId));
        System.out.println(countryController.drop(countryId));
//        for (Object[] objects : countryController.binding()) {
//            System.out.println(objects.getClass() + "-" +objects.getClass());
//        }
//        System.out.println("===============SORTING=====================");
    }
}
