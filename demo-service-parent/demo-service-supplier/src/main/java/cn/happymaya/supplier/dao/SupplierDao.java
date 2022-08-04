package cn.happymaya.supplier.dao;

import cn.happymaya.supplier.entity.Supplier;

import java.util.Collection;

/**
 * The interface of supplier dao.
 * @author superhsc
 */
public interface SupplierDao {
	/**
	 * insert a supplier
	 * @param supplier
	 */
	public void insertSupplier(Supplier supplier);
	/**
	 * update a supplier
	 * @param supplier
	 */
	public void updateSupplier(Supplier supplier);
	/**
	 * @param id
	 * @return
	 */
	public Supplier getSupplier(String id);
	
	/**
	 * @return
	 */
	public Collection<Supplier> listOfSuppliers();
}
