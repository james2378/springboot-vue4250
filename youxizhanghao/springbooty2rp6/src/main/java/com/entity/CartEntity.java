package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 购物车表
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-08 09:39:22
 */
@TableName("cart")
public class CartEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CartEntity() {
		
	}
	
	public CartEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 账号表名
	 */
					
	private String tablename;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：账号表名
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	/**
	 * 获取：账号表名
	 */
	public String getTablename() {
		return tablename;
	}
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
