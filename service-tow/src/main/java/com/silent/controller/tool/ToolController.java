package com.silent.controller.tool;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * \* User: silent
 * \* Date: 19/01/19 Time: 14:35
 * \* Description:
 * \
 */
@Api(tags = {"Tool.工具类"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping(value = "api/tool/identifyCode")
public class ToolController {



}
