package org.cloud.provide.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@TableName("subnet")
public class Subnet  extends BaseEntity{
	@TableId
	@JsonProperty("id")
	private String subnetId;
	@JsonProperty("name")
	private String subnetName;
	@JsonProperty("tenant_id")
	private String tenantId;//指示是否为子网启用了dhcp
	@JsonProperty("project_id")
	private String projectId;
	@JsonProperty("network_id")
	private String networkId;
	
	@JsonProperty("ip_version")
	private String ipVersion;
	
	@JsonProperty("gateway_ip")
	private String gatewayIp;
	private String cidr;//子网的CIDR


}	
