package com.entity.vo;

import com.entity.CartEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 购物车表
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-08 09:39:22
 */
public class CartVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户id
	 */
	
	private Long userid;
		
	/**
	 * 账号id
	 */
	
	private Long goodid;
		
	/**
	 * 账号名称
	 */
	
	private String goodname;
		
	/**
	 * 图片
	 */
	
	private String picture;
		
	/**
	 * 购买数量
	 */
	
	private Integer buynumber;
		
	/**
	 * 单价
	 */
	
	private Float price;
		
	/**
	 * 会员价
	 */
	
	private Float discountprice;
		
	/**
	 * 商户名称
	 */
	
	private String zhanghao;
		
	/**
	 * 账号类型
	 */
	
	private String goodtype;
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
				
	
	/**
	 * 设置：账号id
	 */
	 
	public void setGoodid(Long goodid) {
		this.goodid = goodid;
	}
	
	/**
	 * 获取：账号id
	 */
	public Long getGoodid() {
		return goodid;
	}
				
	
	/**
	 * 设置：账号名称
	 */
	 
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	
	/**
	 * 获取：账号名称
	 */
	public String getGoodname() {
		return goodname;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * 获取：图片
	 */
	public String getPicture() {
		return picture;
	}
				
	
	/**
	 * 设置：购买数量
	 */
	 
	public void setBuynumber(Integer buynumber) {
		this.buynumber = buynumber;
	}
	
	/**
	 * 获取：购买数量
	 */
	public Integer getBuynumber() {
		return buynumber;
	}
				
	
	/**
	 * 设置：单价
	 */
	 
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * 获取：单价
	 */
	public Float getPrice() {
		return price;
	}
				
	
	/**
	 * 设置：会员价
	 */
	 
	public void setDiscountprice(Float discountprice) {
		this.discountprice = discountprice;
	}
	
	/**
	 * 获取：会员价
	 */
	public Float getDiscountprice() {
		return discountprice;
	}
				
	
	/**
	 * 设置：商户名称
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：商户名称
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：账号类型
	 */
	 
	public void setGoodtype(String goodtype) {
		this.goodtype = goodtype;
	}
	
	/**
	 * 获取：账号类型
	 */
	public String getGoodtype() {
		return goodtype;
	}
			
}
