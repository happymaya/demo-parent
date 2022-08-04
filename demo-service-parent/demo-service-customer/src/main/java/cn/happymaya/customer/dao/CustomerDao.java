package cn.happymaya.customer.dao;

import cn.happymaya.customer.entity.Customer;

import java.util.Collection;

/**
 * The dao of customer
 * @author fangang
 */
public interface CustomerDao {
    /**
     * insert a customer
     * @param customer
     */
    public void insert(Customer customer);
    /**
     * update a customer
     * @param customer
     */
    public void update(Customer customer);
    /**
     * delete a customer
     * @param id
     */
    public void delete(String id);
    /**
     * @param id
     * @return the customer with the id
     */
    public Customer get(String id);
    /**
     * @return all of the customers
     */
    public Collection<Customer> list();
}
