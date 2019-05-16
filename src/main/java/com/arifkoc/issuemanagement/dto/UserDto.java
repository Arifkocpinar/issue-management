package com.arifkoc.issuemanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "User Data Transfer Object")
public class UserDto {
    @ApiModelProperty(value = "Id of User")
    private Long id;
    @ApiModelProperty(value = "nameSurname of User")
    private String nameSurname;

}
