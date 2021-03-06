package com.yl.demo.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yl.demo.dataobject.ProductInfo;
import com.yl.demo.enums.ProductStatusEnum;
import com.yl.demo.repository.ProductInfoRepository;
import com.yl.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductInfoRepository repository;
	
	@Override
	public ProductInfo findOne(String productId) {
		return repository.findById(productId).get();
	}

	@Override
	public List<ProductInfo> findUpAll() {
		return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public Page<ProductInfo> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public ProductInfo save(ProductInfo productInfo) {
		return repository.save(productInfo);
	}

}
