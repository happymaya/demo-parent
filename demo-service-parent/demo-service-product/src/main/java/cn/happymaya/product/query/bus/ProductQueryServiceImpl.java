package cn.happymaya.product.query.bus;

import cn.happymaya.product.entity.Product;
import cn.happymaya.product.entity.Supplier;
import cn.happymaya.product.service.SupplierService;
import cn.happymaya.support.entity.ResultSet;
import cn.happymaya.support.service.impl.QueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Map;

/**
 * The implement of the query service for products.
 * @author superhsc
 */
public class ProductQueryServiceImpl extends QueryServiceImpl {
	@Autowired
	private SupplierService supplierService;

	@Override
	protected ResultSet afterQuery(Map<String, Object> params,
								   ResultSet resultSet) {
		@SuppressWarnings("unchecked")
		Collection<Product> list = (Collection<Product>)resultSet.getData();
		for(Product product : list) {
			String supplierId = product.getSupplierId();
			Supplier supplier = supplierService.loadSupplier(supplierId);
			product.setSupplier(supplier);
		}
		resultSet.setData(list);
		return resultSet;
	}
	
}
