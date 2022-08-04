package cn.happymaya.product.service.impl;

import cn.happymaya.product.dao.ProductDao;
import cn.happymaya.product.entity.Product;
import cn.happymaya.product.entity.Supplier;
import cn.happymaya.product.service.ProductService;
import cn.happymaya.product.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * The implement of the product service.
 * @author superhsc
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	@Autowired
	private SupplierService supplierService;

	@Override
	public void save(Product product) {
		dao.save(product);
	}

	@Override
	public void saveAll(Collection<Product> listOfProducts) {
		dao.save(listOfProducts);
	}

	@Override
	public void delete(String id) {
		dao.deleteProduct(id);
	}

	@Override
	public Product get(String id) {
		Product product = dao.getProduct(id);
		String supplierId = product.getSupplierId();
		Supplier supplier = supplierService.loadSupplier(supplierId);
		product.setSupplier(supplier);
		return product;
	}
}
