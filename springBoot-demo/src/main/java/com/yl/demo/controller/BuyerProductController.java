package com.yl.demo.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yl.demo.VO.ProductInfoVO;
import com.yl.demo.VO.ProductVO;
import com.yl.demo.VO.ResultVO;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
	
	@GetMapping("/list")
	public ResultVO list(){
		ResultVO resultVo = new ResultVO();
		ProductVO productVo = new ProductVO();
		ProductInfoVO productInfoVO = new ProductInfoVO();
		
		productVo.setProductInfoVOList(Arrays.asList(productInfoVO));
		resultVo.setData(Arrays.asList(productVo));
		resultVo.setCode(0);
		resultVo.setMsg("成功");
		return resultVo;
	}
}
