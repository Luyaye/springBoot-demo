package com.yl.demo.service;

import java.util.List;

import com.yl.demo.dataobject.ProductCategory;

public interface CategoryService {
	
	ProductCategory findOne(Integer categoryId);
	
	List<ProductCategory> findAll();
	
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
	
	ProductCategory save(ProductCategory productCategory);
	
}
