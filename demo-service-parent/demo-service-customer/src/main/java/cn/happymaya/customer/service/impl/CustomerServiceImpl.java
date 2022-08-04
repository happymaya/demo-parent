package cn.happymaya.customer.service.impl;

import cn.happymaya.customer.dao.CustomerDao;
import cn.happymaya.customer.entity.Customer;
import cn.happymaya.customer.exception.CustomerException;
import cn.happymaya.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * The implement of the customer service
 * @author fangang
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao dao;
    /**
     * @return the dao
     */
    public CustomerDao getDao() {
        return dao;
    }
    /**
     * @param dao the dao to set
     */
    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }
    @Override
    public void create(Customer customer) {
        if(customer.getId()==null) {
            throw new CustomerException("The 'id' is null!");
        }
        if(customer.getName()==null) {
            throw new CustomerException("The 'name' is null!");
        }
        dao.insert(customer);
    }
    @Override
    public void modify(Customer customer) {
        if(customer.getId()==null) throw new CustomerException("The 'id' is null!");
        if(customer.getName()==null) throw new CustomerException("The 'name' is null!");
        dao.update(customer);
    }
    @Override
    public void delete(String id) {
        dao.delete(id);
    }
    @Override
    public Collection<Customer> listOfAll() {
        return dao.list();
    }
    @Override
    public Customer get(String id) {
        return dao.get(id);
    }

}
