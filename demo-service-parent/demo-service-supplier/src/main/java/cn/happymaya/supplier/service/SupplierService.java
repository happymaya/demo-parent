package cn.happymaya.supplier.service;

import cn.happymaya.supplier.entity.Supplier;

import java.util.Collection;

/**
 * The service of suppliers.
 * @author superhsc
 */
public interface SupplierService {
	/**
	 * create a supplier
	 * @param supplier
	 */
	public void createSupplier(Supplier supplier);
	/**
	 * modify a certain supplier
	 * @param supplier
	 */
	public void modifySupplier(Supplier supplier);
	/**
	 * @param id
	 * @return the supplier
	 */
	public Supplier loadSupplier(String id);
	
	/**
	 * @return the list of suppliers
	 */
	public Collection<Supplier> listOfSuppliers();
}
