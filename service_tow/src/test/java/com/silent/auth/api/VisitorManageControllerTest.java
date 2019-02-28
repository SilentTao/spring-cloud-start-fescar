package com.silent.auth.api;

import com.silent.controller.api.deprecated.VisitorManageController;
import com.silent.controller.api.param.VisitorInfoParam;
import com.dmap.base.junit.BaseTestRoot;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

/**
 * \* User: silent
 * \* Date: 23/04/18 Time: 15:47
 * \* Description:
 * \
 */
public class VisitorManageControllerTest extends BaseTestRoot {
    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Resource
    private VisitorManageController visitorManageController;

    private String baseUrl = "/api/dmap-auth-server/v1/visitor/";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(visitorManageController).build();
    }

    @Test
    public void registerVisitor() throws Exception {
        VisitorInfoParam param = new VisitorInfoParam();
        param.setDeviceId("sdafasdfa");
        param.setProjectId("ap007");
        param.setAppVersion("4.7");
        mvc.perform(MockMvcRequestBuilders.post(baseUrl+"register")
                .content(mapper.writeValueAsString(param))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }

    @Test
    public void updateVisitorInfo() throws Exception {
        VisitorInfoParam param = new VisitorInfoParam();
        param.setDeviceId("sdafasdfa");
        param.setProjectId("ap007");
        param.setAppVersion("4.7");
        mvc.perform(MockMvcRequestBuilders.post(baseUrl + "bind/equipment")
                .content(mapper.writeValueAsString(param))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }

}
