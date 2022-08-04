package cn.happymaya.customer.service;

import cn.happymaya.customer.entity.Customer;

import java.util.Collection;

/**
 * The service of customer
 * @author fangang
 */
public interface CustomerService {
    /**
     * create a customer.
     * @param customer
     */
    public void create(Customer customer);
    /**
     * modify a customer
     * @param customer
     */
    public void modify(Customer customer);
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
     * @return all the customers
     */
    public Collection<Customer> listOfAll();
}
