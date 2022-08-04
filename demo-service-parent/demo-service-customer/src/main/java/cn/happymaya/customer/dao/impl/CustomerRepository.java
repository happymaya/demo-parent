package cn.happymaya.customer.dao.impl;

import cn.happymaya.customer.dao.CustomerDao;
import cn.happymaya.customer.entity.Customer;
import cn.happymaya.support.dao.BasicRepository;
import org.springframework.stereotype.Repository;

/**
 * @author fangang
 */
@Repository
public class CustomerRepository extends BasicRepository<Customer, String> implements CustomerDao {

    public CustomerRepository() {
        setClazz(Customer.class);
        initFactory("customer.xml");
    }

}