/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author captj_000
 */
public class Customer {
    private String customerName;
    private PreparedStatement selectAllCustomers;
    private PreparedStatement insertNewCustomer;
    private Connection connectionCust;
    
    public Customer() {
    }
    
    public Customer(String custName) {
        setCustomerName(custName);
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public List<Customer> getAllCustomer() {
        List<Customer> results = null;
        ResultSet resultSet = null;
        
        try
        {
            resultSet = selectAllCustomers.executeQuery();
            results = new ArrayList<Customer>();
            
            while (resultSet.next())
            {
                results.add(new Customer(resultSet.getString("CustomerName")));
            }
        }
        catch (SQLException sqlException1)
        {
            sqlException1.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException sqlException2)
            {
                sqlException2.printStackTrace();
                close();
            }
        }
        
        return results;
    }
    
    public int addCustomer(String name) {
        int result = 0;
        
        try
        {
            insertNewCustomer.setString(1, name);
            
            result = insertNewCustomer.executeUpdate();
        }
        catch (SQLException sqlException3)
        {
            sqlException3.printStackTrace();
            close();
        }
        
        return result;
    }
    
    public void close() {
        try
        {
            connectionCust.close();
        }
        catch (SQLException sqlException4)
        {
            sqlException4.printStackTrace();
        }
    }
}
