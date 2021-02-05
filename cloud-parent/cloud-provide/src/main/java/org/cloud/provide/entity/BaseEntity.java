package org.cloud.provide.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7471800894832934999L;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@JsonProperty("updated_at")
	@JSONField( format  = "yyyy-MM-dd HH:mm:ss" )
	public Date updateDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@JsonProperty("created_at")
	public Date createDate;
}
