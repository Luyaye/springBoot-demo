package com.yl.demo.service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yl.demo.dataobject.ProductCategory;
import com.yl.demo.service.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
	
	@Autowired
	private CategoryService service;
	
	@Test
	public void testFindOne() {
		ProductCategory productCategory = service.findOne(1);
		Assert.assertNotNull(productCategory);
	}

	@Test
	public void testFindAll() {
		List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
		productCategories = service.findAll();
		Assert.assertNotEquals(0, productCategories.size());
	}

	@Test
	public void testFindByCategoryTypeIn() {
		List<Integer> categoryTypes = new ArrayList<Integer>();
		categoryTypes.add(1);
		categoryTypes.add(2);
		categoryTypes.add(3);
		List<ProductCategory> productCategories = service.findByCategoryTypeIn(categoryTypes);
		Assert.assertNotEquals(0, productCategories.size());
	}

	@Test
	public void testSave() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryId(4);
		productCategory.setCategoryName("旅游");
		productCategory.setCategoryType(3);
		Assert.assertNotNull(service.save(productCategory));
	}

}
