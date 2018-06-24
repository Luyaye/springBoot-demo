package com.yl.demo.service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yl.demo.dataobject.ProductCategory;
import com.yl.demo.dataobject.ProductInfo;
import com.yl.demo.service.CategoryService;
import com.yl.demo.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
	
	@Autowired
	private CategoryService service;
	
	@Test
	public void testFindOne() {
		
	}

	@Test
	public void testFindAll() {
		List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
		productCategories = service.findAll();
		Assert.assertNotEquals(0, productCategories.size());
	}

	@Test
	public void testFindByCategoryTypeIn() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

}
