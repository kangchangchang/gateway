package org.cloud.provide.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class NetworkDetail {
	
		
	@JsonProperty(value = "id")
	private String networkId;
	@JsonProperty(value = "admin_state_up")
	private String adminStateUp;
	private Integer mtu;//解决碎片的最大传输单位（MTU）值。对于IPv4，最小值是68；对于IPv6，最小值是1280
	@JsonProperty(value = "name")
	private String network_name;
	@JsonProperty(value = "port_security_enabled")
	private String portSecurityEnabled;
	@JsonProperty(value = "project_id")
	private String projectId;
	@JsonProperty(value = "router:external")
	private String  routerType;
	private String shared;
	private String description;
	 
	private String is_default;
	
	@JsonProperty(value = "availability_zone_hints")
	private String[] availabilityZzoneHints;
	@JsonProperty(value = "availability_zones")
	private String[] availabilityZones;
	@JsonProperty(value = "created_at")
	private String createdDate ;
	@JsonProperty(value = "updated_at")
	private String updateDate ;
	@JsonProperty(value = "dns_domain")
	private String dnsDomain;
	@JsonProperty(value = "ipv4_address_scope")
	private String ipv4;
	@JsonProperty(value = "ipv6_address_scope")
	private String ipv6;
	@JsonProperty(value = "l2_adjacency")
	private String adjacency;
	@JsonProperty(value = "qos_policy_id")
	private String qosPolicyId;
	private String status;
	@JsonProperty(value = "revision_number")
	private String revisionNumber;	
	private String[] subnets;
	private String []tags;
	@JsonProperty(value = "tenant_id")
	private String tenantId;
	@JsonProperty(value = "vlan_transparent")
	private String vlanTransparent;//表示网络的VLAN透明模式，为VLAN透明（true）或非VLAN透明（false）
	@JsonProperty(value = "provider:physical_network")
	private String physicalNetwork;
	@JsonProperty(value = "provider:segmentation_id")
	private String segmentationId;
	@JsonProperty(value = "provider:network_type")
	private String networkType;
}
