package cn.happymaya.customer.query.dao;

import cn.happymaya.customer.dao.impl.CustomerRepository;
import cn.happymaya.support.dao.QueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

/**
 * The implement of the query dao for customers.
 * @
 */
@Repository("customerQueryDao")
public class CustomerQueryDaoImpl implements QueryDao {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Collection<?> query(Map<String, Object> params) {
        return repository.list();
    }

    @Override
    public long count(Map<String, Object> params) {
        return repository.list().size();
    }

    @Override
    public Map<String, Object> aggregate(Map<String, Object> params) {
        return null;
    }

}
