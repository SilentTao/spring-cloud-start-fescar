package com.dmap.common.api;

import com.dmap.base.junit.BaseTestRoot;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

/**
 * \* User: silent
 * \* Date: 29/05/18 Time: 15:12
 * \* Description:
 * \
 */
public class WeatherControllerTest extends BaseTestRoot {

    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();

//    @Resource
//    private WeatherController weatherController;

    private String baseUrl = "/api/dmap-common-server/v1/weather";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
//        mvc = MockMvcBuilders.standaloneSetup(weatherController).build();
    }

    @Test
    public void getWeatherInfo() throws Exception {
//        mvc.perform(
//                MockMvcRequestBuilders.get(baseUrl + "/get/info")
//                        .param("cityName", "聊城")
//                        .param("countryName", "34252345234")
//                        .param("province", "山东")
//                        .param("district", "东昌")
//                        .param("time", "1527691769")
//                        .param("type", "1")
//        ).andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print()).andReturn();
//

    }
}
