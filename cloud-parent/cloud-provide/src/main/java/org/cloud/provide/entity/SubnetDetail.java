package org.cloud.provide.entity;

import lombok.Data;

@Data
public class SubnetDetail extends BaseEntity{
    private String id;
    private String name;
    private String ip;
    private boolean enable_dhcp;
    private String network_id;//网络的端口安全状态
    private String project_id;//项目id
    private String ip_version;//ip协议版本
    private String gateway_id;//网关ip
    private String cidr;//子网CIDR
    private String description;
}
