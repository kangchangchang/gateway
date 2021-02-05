package org.cloud.provide.entity;

import lombok.Data;

@Data
public class NetworkVo extends BaseEntity{

	
	
	private String networkId;
	private String networkName;
	private String shared;
	private String ipv4;
	private String description;
	private String status;	
	private String subnetName;
}
