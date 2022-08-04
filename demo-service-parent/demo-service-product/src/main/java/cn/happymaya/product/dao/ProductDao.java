package cn.happymaya.product.dao;


import cn.happymaya.product.entity.Product;

import java.util.Collection;

/**
 * The dao of the product
 * @author superhsc
 */
public interface ProductDao {
	/**
	 * @param product
	 * @return
	 */
	public void save(Product product);
	/**
	 * @param listOfProducts
	 */
	public void save(Collection<Product> listOfProducts);
	/**
	 * @param id
	 */
	public void deleteProduct(String id);
	/**
	 * @param id
	 * @return product
	 */
	public Product getProduct(String id);
	/**
	 * @return list all of the products.
	 */
	public Collection<Product> listOfProducts();
}
