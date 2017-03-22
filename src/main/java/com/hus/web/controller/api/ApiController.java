package com.hus.web.controller.api;

import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhh on 2017/3/3.
 */
@Api(value = "hus", description = "测试API", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ApiController {
    @ApiOperation(value = "线上订单列表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 0, message = "线上订单列表", response = String.class)})
    @RequestMapping(value = "test/api", method = RequestMethod.POST)
    public Object orderListForMall( @ApiParam("页码") @RequestParam(defaultValue = "1") Integer pageNo,
                                    @ApiParam("日期类型（-1：全部，0：今天，1：一周内，2：一个月内，3：三个月内，4：半年内，5：一年内）")
                                    @RequestParam(defaultValue = "-1") String dateType,
                                    @ApiParam("订单状态（-1：全部，1：待付款，2：未发货，4：已发货，5：交易完成）")
                                    @RequestParam(defaultValue = "-1") Integer status,
                                    @ApiParam("商品ID") @RequestParam(defaultValue = "-1") String productId,
                                    @ApiParam("门店ID") @RequestParam(defaultValue = "-1") Integer storeId) {
        return "success";
    }
}
