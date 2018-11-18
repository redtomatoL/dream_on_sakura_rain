package com.example.springboothtml.controller;

import com.example.springboothtml.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licunzhi
 * @desc 产品销量和价钱统计控制层
 * @date 2018-11-17
 */
@RequestMapping("/products")
@RestController
@Api(value = "统计销量价格相关接口", tags = "暴露网页接口")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "抓取网页数据", notes = "抓取网页数据接口")//接口功能解释
    @ApiImplicitParams(value = {
                    @ApiImplicitParam(name = "query", value = "查询关键字", required = true, dataType = "String", paramType = "query"),
                    @ApiImplicitParam(name = "startPage", value = "起始页", required = true, dataType = "Integer", paramType = "query"),
                    @ApiImplicitParam(name = "endPage", value = "终止页", required = true, dataType = "Integer", paramType = "query"),
                    @ApiImplicitParam(name = "fileName", value = "文件名（不用定义文件后缀）", required = true, dataType = "String", paramType = "query")})
    @GetMapping("/list/html")
    public ResponseEntity scrapHtml(String query, Integer startPage, Integer endPage, String fileName) {
        return productService.scrapHtml(query, startPage, endPage, fileName);
    }
}
