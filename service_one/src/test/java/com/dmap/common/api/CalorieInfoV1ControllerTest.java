package com.dmap.common.api;

import com.dmap.base.junit.BaseTestRoot;
import com.silent.common.controller.api.CalorieInfoV1Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

/**
 * \* User: silent
 * \* Date: 29/05/18 Time: 15:12
 * \* Description:
 * \
 */
public class CalorieInfoV1ControllerTest extends BaseTestRoot {

    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Resource
    private CalorieInfoV1Controller calorieInfoV1Controller;

    private String baseUrl = "/api/dmap-common-server/calorie";

    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mvc = MockMvcBuilders.standaloneSetup(calorieInfoV1Controller).build();
    }

    @Test
    public void getWeatherInfo() throws Exception {
//        mvc.perform(
//                MockMvcRequestBuilders.get(baseUrl + "/get/info/1243")
//        ).andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print()).andReturn();
    }
}
