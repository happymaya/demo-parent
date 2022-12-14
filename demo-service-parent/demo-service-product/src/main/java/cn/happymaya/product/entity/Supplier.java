package cn.happymaya.product.entity;


import cn.happymaya.support.entity.Entity;

/**
 * @author superhsc
 */
public class Supplier extends Entity<String> {
	private static final long serialVersionUID = 6701114321174621284L;
	private String id;
	private String name;
	
	public Supplier() {}
	public Supplier(String id, String name) {
		this.id = id;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
