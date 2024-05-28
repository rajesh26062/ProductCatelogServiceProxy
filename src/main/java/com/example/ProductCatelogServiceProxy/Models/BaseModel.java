package com.example.ProductCatelogServiceProxy.Models;

import com.example.ProductCatelogServiceProxy.Models.constants.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private Date lastUpdatedBy;
    private Status status;
}
