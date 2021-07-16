package com.te.productmanagement.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ProductResponse implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@XmlElement
	@JsonProperty
	private int statusCode;
	

	@XmlElement
	@JsonProperty
	private String msg;
	

	@XmlElement
	@JsonProperty
	private String description;
	
	@XmlElement
	@JsonProperty
	private ProductBean product;
	
	@XmlElement
	@JsonProperty
	List<ProductBean> products;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductBean getProduct() {
		return product;
	}

	public void setProduct(ProductBean product) {
		this.product = product;
	}

	public List<ProductBean> getProducts() {
		return products;
	}

	public void setProducts(List<ProductBean> products) {
		this.products = products;
	}
	
	

}

