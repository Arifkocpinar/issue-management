package com.arifkoc.issuemanagement.dto;

import com.arifkoc.issuemanagement.Entity.IssueStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "Issue Data Transfer Object")
public class IssueDto {
    @ApiModelProperty(value = "Id of Issue")
    private Long id;
    @ApiModelProperty(value = "description of Issue")
    private String description;
    @ApiModelProperty(value = "details of Issue")
    private String details;
    @ApiModelProperty(value = "date of Issue")
    private Date date;
    @ApiModelProperty(value = "issueStatus of Issue")
    private IssueStatus issueStatus;
    @ApiModelProperty(value = "assignee of Issue")
    private UserDto assignee;
    @ApiModelProperty(value = "project of Issue")
    private ProjectDto project;

}
