package com.yl.demo.utils;

import com.yl.demo.VO.ResultVO;

/**
 * 返回方法
 * */
public class ResultVOUtil {
	
	public static ResultVO success(Object object) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		resultVO.setData(object);
		return resultVO;
	}
	
	public static ResultVO success() {
		Object object = null;
		return success(object);
	}
	
	public static ResultVO error(Integer code,String msg) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(code);
		resultVO.setMsg(msg);
		return resultVO;
	}
	
}
