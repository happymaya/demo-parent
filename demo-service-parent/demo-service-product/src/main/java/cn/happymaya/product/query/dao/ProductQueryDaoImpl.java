package cn.happymaya.product.query.dao;

import cn.happymaya.product.dao.impl.ProductRepository;
import cn.happymaya.support.dao.QueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

/**
 * The implement of the query dao for products.
 * @author superhsc
 */
@Repository("productQueryDao")
public class ProductQueryDaoImpl implements QueryDao {
	@Autowired
	private ProductRepository repository;
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
