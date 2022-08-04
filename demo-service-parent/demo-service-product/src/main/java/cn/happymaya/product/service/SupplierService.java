package cn.happymaya.product.service;

import cn.happymaya.product.entity.Supplier;
import cn.happymaya.product.service.impl.SupplierServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The service of supplier.
 * @author superhsc
 */
@Service
@FeignClient(value="service-supplier",fallback= SupplierServiceHystrixImpl.class)
public interface SupplierService {
	/**
	 * load a supplier by id.
	 * @param id
	 * @return the supplier
	 */
	@GetMapping("orm/supplier/loadSupplier")
	public Supplier loadSupplier(@RequestParam(value="id") String id);
}
