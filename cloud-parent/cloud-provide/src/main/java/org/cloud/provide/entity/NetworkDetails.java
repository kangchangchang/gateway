package org.cloud.provide.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "响应返回值", description = "网络详情的响应返回数据")
public class NetworkDetails extends BaseEntity{
	
    @ApiModelProperty(value = "网络id")
    private String id;
    @ApiModelProperty(value = "网络名")
    private String name;
    @ApiModelProperty(value = "ip")
    @JsonProperty("ipv4_address_scope")
    private String ip;
    @ApiModelProperty(value = "碎片的最大传输单位")
    private Integer mtu;
    @ApiModelProperty(value = "网络的端口安全状态")
    private boolean port_security_enabled;//网络的端口安全状态
    @ApiModelProperty(value = "项目id")
    private String project_id;//项目id
    @ApiModelProperty(value = "网络物理类型")

    private String netwrok_type;//网络物理类型
    @ApiModelProperty(value = "网络关联的QoS策略的ID")
    private String qos_policy_id;//与网络关联的QoS策略的ID
    @ApiModelProperty(value = "网络是否具有不受网络服务管理的外部路由工具")
    @JsonProperty("router:external")
    private boolean routerType;
    @ApiModelProperty(value = "状态")

    private String status;//状态
    @ApiModelProperty(value = "关联子网id")

    private String[] subnets;//关联子网id
    @ApiModelProperty(value = "描述")

    private String description;
    @ApiModelProperty(value = "是否为默认网池")
    @JsonProperty("is_default")

     private boolean isDefault;//是否为默认网池
}
