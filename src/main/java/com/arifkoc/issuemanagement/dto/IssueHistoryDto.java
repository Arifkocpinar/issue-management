package com.arifkoc.issuemanagement.dto;

import com.arifkoc.issuemanagement.Entity.IssueStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "IssueHistory Data Transfer Object")
public class IssueHistoryDto {

    @ApiModelProperty(value = "Id of IssueHistory")
    private Long id;
    @ApiModelProperty(value = "issueDto of IssueHistory")
    private IssueDto issueDto;
    @ApiModelProperty(value = "description of IssueHistory")
    private String description;
    @ApiModelProperty(value = "date of IssueHistory")
    private Date date;
    @ApiModelProperty(value = "issueStatus of IssueHistory")
    private IssueStatus issueStatus;
    @ApiModelProperty(value = "details of IssueHistory")
    private String details;
    @ApiModelProperty(value = "userDto of IssueHistory")
    private UserDto userDto;

}
