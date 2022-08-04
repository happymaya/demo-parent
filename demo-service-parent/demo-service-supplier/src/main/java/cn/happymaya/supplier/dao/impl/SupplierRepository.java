/*
 * Created by 2021-01-04 09:18:06 
 */
package cn.happymaya.supplier.dao.impl;

import cn.happymaya.supplier.dao.SupplierDao;
import cn.happymaya.supplier.entity.Supplier;
import cn.happymaya.support.dao.BasicRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author fangang
 */
@Repository
public class SupplierRepository extends BasicRepository<Supplier, String> implements SupplierDao {

	public SupplierRepository() {
		setClazz(Supplier.class);
		initFactory("supplier.xml");
	}

	@Override
	public void insertSupplier(Supplier supplier) {
		super.save(supplier);
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		super.save(supplier);
	}

	@Override
	public Supplier getSupplier(String id) {
		return super.get(id);
	}

	@Override
	public Collection<Supplier> listOfSuppliers() {
		return super.list();
	}

}
