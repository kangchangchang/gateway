package org.cloud.provide.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@TableName("router")
public class Router extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@TableId
	@JsonProperty("id")
	private String routerId;
	@JsonProperty("tenant_id")
	private String tenantId;
	@JsonProperty("project_id")
	private String projectId;
	@JsonProperty("name")
	private String routerName;
	private String description;
	@JsonProperty("admin_state_up")
	private String adminStateUp;
	
}
