package cn.happymaya.supplier.dao;

import cn.happymaya.supplier.dao.impl.SupplierRepository;
import cn.happymaya.support.dao.QueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

/**
 * @author superhsc
 */
@Repository
public class SupplierQueryDao implements QueryDao {
    @Autowired
    private SupplierRepository repository;

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
        // TODO Auto-generated method stub
        return null;
    }

}
