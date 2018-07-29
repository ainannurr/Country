/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Country;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author AINAN-Gaul
 */
public class CountryDAO {
    
    private final FunctionDAO fdao;

    public CountryDAO(Connection connection) {
        this.fdao = new FunctionDAO(connection);
    }
    
    public boolean insert(Country country) {
        return this.fdao.executeDML("INSERT INTO COUNTRIES VALUES('" +country.getCountryId()+ "' ,'" +country.getCountryName()+ "', " +country.getRegionId());
    }

    public boolean update(Country country) {
        return this.fdao.executeDML("UPDATE COUNTRIES SET COUNTRY_NAME='" +country.getCountryName()+ "' WHERE COUNTRY_ID=" +country.getCountryId());
    }

    public boolean delete(String countryId) {
        return this.fdao.executeDML("DELETE FROM COUNTRIES WHERE COUNTRY_ID='" +countryId+ "'");
    }

    public List<Object[]> getAll() {
        return this.fdao.getAll("SELECT * FROM COUNTRIES");
    }

    public List<Object[]> getAllSort(String category, String sort) {
        return this.fdao.getAll("SELECT * FROM COUNTRIES ORDER BY " +category+ " " +sort);
    }

    public List<Object[]> search(String category, String data) {
        return this.fdao.getAll("SELECT * FROM COUNTRIES WHERE " +category+ " LIKE '%" +data+ "%'");
    }
    
    public Object getById(int countryId){
        return this.fdao.getDataByID("SELECT * FROM COUNTRIES WHERE COUNTRY_ID=" +countryId);
    }   
}
