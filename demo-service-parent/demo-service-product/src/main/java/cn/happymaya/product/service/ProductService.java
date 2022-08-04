package cn.happymaya.product.service;

import cn.happymaya.product.entity.Product;

import java.util.Collection;

/**
 * The service of products.
 * @author superhsc
 */
public interface ProductService {
	/**
	 * save a product.
	 * @param product
	 */
	public void save(Product product);
	/**
	 * save a list of products.
	 * @param listOfProducts
	 */
	public void saveAll(Collection<Product> listOfProducts);
	/**
	 * delete a product by id.
	 * @param id
	 */
	public void delete(String id);
	
	/**
	 * @param id
	 * @return the product with its id.
	 */
	public Product get(String id);
}
