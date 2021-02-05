package org.cloud.provide.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;

@TableName("port")
public class Port extends BaseEntity{
	@TableId
	@JsonProperty("id")
	private String portId;
	@JsonProperty("name")
	private String portName;
	@JsonProperty("device_id")
	private String deviceId;
	private String description;
	@JsonProperty("mac_address")
	private String macAddress;
	@JsonProperty("network_id")
	private String networkId;
	@JsonProperty("project_id")
	private String projectId;
	@JsonProperty("tenant_id")
	private String tenantId;
	/*
	 * 使用此端口的实体类型。例如，compute:nova（服务器实例），network:dhcp （DHCP代理）
	 * 或network:router_interface（路由器接口）
	 */
	@JsonProperty("device_owner")
	private String deviceOwner;
	@JsonProperty("data_plane_status")
	private String dataPlaneStatus;//端口的基础数据平面的状态。
	@JsonProperty("qos_network_policy_id")
	private String qos_network_policy_id;//插入此端口的网络的QoS策略的ID。
	@JsonProperty("qos_policy_id")
	private String qosPolicyId;//与端口关联的QoS策略的ID。



}
