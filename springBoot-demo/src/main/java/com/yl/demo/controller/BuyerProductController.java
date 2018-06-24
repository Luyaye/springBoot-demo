package com.yl.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yl.demo.VO.ProductInfoVO;
import com.yl.demo.VO.ProductVO;
import com.yl.demo.VO.ResultVO;
import com.yl.demo.dataobject.ProductCategory;
import com.yl.demo.dataobject.ProductInfo;
import com.yl.demo.service.CategoryService;
import com.yl.demo.service.ProductService;
import com.yl.demo.utils.ResultVOUtil;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list")
	public ResultVO list() {

		// 1.搜索所有上架商品
		List<ProductInfo> productInfos = productService.findUpAll();
		// 2.查讯类目（一次性查询）
		// 传统方法
		/*
		 * List<Integer> categoryTypeList = new ArrayList<Integer>(); for(ProductInfo
		 * productInfo : productInfos) {
		 * categoryTypeList.add(productInfo.getCategoryType()); }
		 */
		// 精简方法（Java8，lambda）
		List<Integer> categoryTypeList = productInfos.stream().map(e -> e.getCategoryType())
				.collect(Collectors.toList());
		List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryTypeList);

		// 3.数据拼装
		List<ProductVO> productVOs = new ArrayList<ProductVO>();
		for (ProductCategory productCategory : productCategories) {
			ProductVO productVO = new ProductVO();
			productVO.setCategoryName(productCategory.getCategoryName());
			productVO.setCategoryType(productCategory.getCategoryType());

			List<ProductInfoVO> productInfoVOs = new ArrayList<ProductInfoVO>();
			for (ProductInfo productInfo : productInfos) {
				if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
					ProductInfoVO productInfoVO = new ProductInfoVO();
					BeanUtils.copyProperties(productInfo, productInfoVO);
					productInfoVOs.add(productInfoVO);
				}
			}
			productVO.setProductInfoVOList(productInfoVOs);
			productVOs.add(productVO);
		}
		
		return ResultVOUtil.success(productVOs);
	}
}
