package com.yl.demo.service.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yl.demo.dataobject.ProductInfo;
import com.yl.demo.service.Imp.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
	
	@Autowired
	private ProductServiceImpl service;
	
	@Test
	public void testFindOne() {
		ProductInfo productInfo = service.findOne("PD20180513000002");
		Assert.assertEquals("PD20180513000002", productInfo.getProductId());
	}

	@Test
	public void testFindUpAll() {
		List<ProductInfo> productInfoList = service.findUpAll();
		System.out.println(productInfoList.size());
		Assert.assertNotEquals(0, productInfoList.size());
	}

	@Test
	public void testFindAll() {
		PageRequest pageable = new PageRequest(0, 10);
		Page<ProductInfo> productInfoPage = service.findAll(pageable);
		System.out.println(productInfoPage.getNumberOfElements());
		Assert.assertNotEquals(0, productInfoPage.getNumberOfElements());
	}

	@Test
	public void testSave() {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductId("PD20180513000002");
		productInfo.setProductName("玉竹牌凉席");
		productInfo.setProductPrice(new BigDecimal(248.0));
		productInfo.setProductStock(256);
		productInfo.setProductDescription("夏天必备佳品");
		productInfo.setProductIcon("http://xxxxxxxx.jpg");
		productInfo.setProductStatus(1);
		productInfo.setCategoryType(4);
		ProductInfo result = service.save(productInfo);
		Assert.assertNotNull(result);
	}

}
