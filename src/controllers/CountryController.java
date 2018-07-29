/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import entities.Country;
import entities.Region;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author AINAN-Gaul
 */
public class CountryController {
    
    private final CountryDAO cdao;

    public CountryController(Connection connection) {
        this.cdao = new CountryDAO(connection);
    }
    
    public boolean save(String countryId, String countryName, Region regionId){
        return this.cdao.insert(new Country(countryId, countryName, regionId));
    }
    
    public boolean edit(String countryId, String countryName, Region regionId){
        return this.cdao.update(new Country(countryId, countryName, regionId));
    }
    
    public boolean drop(String countryId){
        return this.cdao.delete(countryId);
    }
    
    public List<Object[]> binding(){
        return this.cdao.getAll();
    }
    
    public List<Object[]> bindingSort(String category, String sort){
        return this.cdao.getAllSort(category, sort);
    }
    
    public List<Object[]> find(String category, String data){
        return this.cdao.search(category, data);
    }
    
    public Object findById(String countryId){
        return this.cdao.getById(Integer.parseInt(countryId));
    }
}
