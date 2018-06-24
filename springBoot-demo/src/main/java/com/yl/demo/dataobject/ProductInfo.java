package com.yl.demo.dataobject;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@Data
@DynamicUpdate
public class ProductInfo {
	
	/**商品编号 */
	@Id
	private String productId;
	
	/**商品名称*/
	private String productName;
	
	/**商品单价*/
	private BigDecimal productPrice;
	
	/**库存*/
	private Integer productStock;
	
	/**描述*/
	private String productDescription;
	
	/**图标*/
	private String productIcon;
	
	/**状态，0正常 1下架*/
	private Integer productStatus;
	
	/**类目编号*/
	private Integer categoryType;
}
