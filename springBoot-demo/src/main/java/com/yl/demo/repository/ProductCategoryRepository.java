package com.yl.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yl.demo.dataobject.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
	
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
