package com.yl.demo.dataobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@Data
@DynamicUpdate
public class ProductCategory {
	
	/**类目id*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	
	/**类目名称*/
	private String categoryName;
	
	/**类目编号*/
	private Integer categoryType;
	
	
	public ProductCategory(String categoryName,Integer categoryType){
		this.categoryName = categoryName;
		this.categoryType = categoryType;
	}
	
	public ProductCategory() {
	}	
	
}
