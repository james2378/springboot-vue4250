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
 * 订单
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-08 09:39:22
 */
@TableName("orders")
public class OrdersEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public OrdersEntity() {
		
	}
	
	public OrdersEntity(T t) {
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
	 * 订单编号
	 */
					
	private String orderid;
	
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
	 * 账号图片
	 */
					
	private String picture;
	
	/**
	 * 购买数量
	 */
					
	private Integer buynumber;
	
	/**
	 * 价格
	 */
					
	private Float price;
	
	/**
	 * 折扣价格
	 */
					
	private Float discountprice;
	
	/**
	 * 总价格
	 */
					
	private Float total;
	
	/**
	 * 折扣总价格
	 */
					
	private Float discounttotal;
	
	/**
	 * 支付类型
	 */
					
	private Integer type;
	
	/**
	 * 状态
	 */
					
	private String status;
	
	/**
	 * 地址
	 */
					
	private String address;
	
	/**
	 * 电话
	 */
					
	private String tel;
	
	/**
	 * 收货人
	 */
					
	private String consignee;
	
	/**
	 * 备注
	 */
					
	private String remark;
	
	/**
	 * 物流
	 */
					
	private String logistics;
	
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
	 * 设置：订单编号
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderid() {
		return orderid;
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
	 * 设置：账号图片
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * 获取：账号图片
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
	 * 设置：价格
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public Float getPrice() {
		return price;
	}
	/**
	 * 设置：折扣价格
	 */
	public void setDiscountprice(Float discountprice) {
		this.discountprice = discountprice;
	}
	/**
	 * 获取：折扣价格
	 */
	public Float getDiscountprice() {
		return discountprice;
	}
	/**
	 * 设置：总价格
	 */
	public void setTotal(Float total) {
		this.total = total;
	}
	/**
	 * 获取：总价格
	 */
	public Float getTotal() {
		return total;
	}
	/**
	 * 设置：折扣总价格
	 */
	public void setDiscounttotal(Float discounttotal) {
		this.discounttotal = discounttotal;
	}
	/**
	 * 获取：折扣总价格
	 */
	public Float getDiscounttotal() {
		return discounttotal;
	}
	/**
	 * 设置：支付类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：支付类型
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：收货人
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	/**
	 * 获取：收货人
	 */
	public String getConsignee() {
		return consignee;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：物流
	 */
	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}
	/**
	 * 获取：物流
	 */
	public String getLogistics() {
		return logistics;
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
