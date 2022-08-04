package cn.happymaya.product.service.impl;

import cn.happymaya.product.entity.Supplier;
import cn.happymaya.product.service.SupplierService;
import org.springframework.stereotype.Component;

/**
 * The implement of the supplier service for hystrix fallback method.
 * @author superhsc
 */
@Component
public class SupplierServiceHystrixImpl implements SupplierService {

	@Override
	public Supplier loadSupplier(String id) {
		Supplier supplier = new Supplier();
		supplier.setId(id);
		supplier.setName("默认供应商");
		return supplier;
	}

}
