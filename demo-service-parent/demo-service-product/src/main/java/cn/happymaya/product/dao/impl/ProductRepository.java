package cn.happymaya.product.dao.impl;

import cn.happymaya.product.dao.ProductDao;
import cn.happymaya.product.entity.Product;
import cn.happymaya.support.dao.BasicRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author superhsc
 */
@Repository
public class ProductRepository extends BasicRepository<Product, String> implements ProductDao {
    public ProductRepository() {
        setClazz(Product.class);
        initFactory("product.xml");
    }

    @Override
    public void save(Product product) {
        super.save(product);
    }

    @Override
    public void save(Collection<Product> listOfProducts) {
        for (Product product : listOfProducts) save(product);
    }

    @Override
    public void deleteProduct(String id) {
        super.delete(id);
    }

    @Override
    public Product getProduct(String id) {
        return super.get(id);
    }

    @Override
    public Collection<Product> listOfProducts() {
        return super.list();
    }

}
