package com.example.demo.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class CommonSearch {
    @Value("0")
    @ApiModelProperty(required = true, value = "Page index", example = "0")
    protected Integer page;

    @Value("20")
    @ApiModelProperty(required = true, value = "Page size", example = "20")
    protected Integer size;

    protected Long fromDate, toDate;

    @ApiModelProperty(value = "Keyword for query")
    protected String keyword;

    public Integer getPage() {
        return page == null || page < 0 ? 0 : page;
    }

    public Integer getSize() {
        return size == null ? 3 : size;
    }
}
