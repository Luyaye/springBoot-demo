package com.yl.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yl.demo.dataobject.ProductInfo;

public interface ProductService {
	
	//根据商品id查询
	ProductInfo findOne(String productId);
	//查询上架商品
	List<ProductInfo> findUpAll();
	//查询全部商品(分页)
	Page<ProductInfo> findAll(Pageable pageable);
	//保存商品
	ProductInfo save(ProductInfo productInfo);
	//加库存
	//减库存
}
