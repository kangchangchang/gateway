package org.cloud.provide.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("network")
public class Network extends BaseEntity{
	
		
	@TableId
	@JsonProperty(value = "id")
	@ApiModelProperty(value="网络主键,创建时候不需要后台生成其他操作都需要",required = true)
	private String networkId;
	@JsonProperty(value = "admin_state_up")
	@ApiModelProperty(value="网络的管理状态，处于启动（true）或关闭（false）",required = false)
	private String adminStateUp;
	@ApiModelProperty(value="解决碎片的最大传输单位（MTU）值。对于IPv4，最小值是68；对于IPv6，最小值是1280",required = false)
	private Integer mtu;//解决碎片的最大传输单位（MTU）值。对于IPv4，最小值是68；对于IPv6，最小值是1280
	@ApiModelProperty(value="网络名",required = false)
	@JsonProperty(value = "name")
	private String networkName;
	@ApiModelProperty(value="网络的端口安全状态。有效值已启用（true）和已禁用（false）。此值用作port_security_enabled 新创建的端口的字段的默认值",required = false)
	@JsonProperty(value = "port_security_enabled")
	private String portSecurityEnabled;
	@ApiModelProperty(value="项目的ID，创建3cc19a94cd4945a89e59126a855b3283写死，",required = false)
	@JsonProperty(value = "project_id")
	private String projectId;
	@ApiModelProperty(value="指示网络是否具有不受网络服务管理的外部路由工具",required = false)
	@JsonProperty(value = "router:external")
	private String  routerType;
	@ApiModelProperty(value="是否共享",required = false)
	private String shared;
	@ApiModelProperty(value="目前只展示ip",required = false)
	@JsonProperty(value = "ipv4_address_scope")
	private String ipv4;
	@ApiModelProperty(value="描述信息",required = false)
	private String description;
//	@JsonProperty(value = "is_default")
//	@ApiModelProperty(value="默认值",required = false)
//	private String isDefault;//网络是否为默认池
//	
//	@ApiModelProperty(value="网络状态。值是ACTIVE，DOWN，BUILD或ERROR",required = false)
//	private String status;

	 
}
