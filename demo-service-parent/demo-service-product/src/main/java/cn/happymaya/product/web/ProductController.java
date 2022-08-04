package cn.happymaya.product.web;

import cn.happymaya.product.entity.Product;
import cn.happymaya.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * The controller of products.
 * @author fangang
 */
@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping("show")
	public String show() {
		return "product/index";
	}
	
	@PostMapping("save")
	@ResponseBody
	public void save(Product product) {
		service.save(product);
	}
	
	@PostMapping("saveAll")
	@ResponseBody
	public void saveAll(List<Product> listOfProducts) {
		service.saveAll(listOfProducts);
	}
	
	@PostMapping("delete")
	@ResponseBody
	public void deleteProduct(String id) {
		service.delete(id);
	}
	
	@GetMapping("get")
	@ResponseBody
	public Product get(String id) {
		return service.get(id);
	}
}
