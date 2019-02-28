package com.silent.auth.api;

import com.silent.controller.api.deprecated.VisitorManageController;
import com.dmap.base.junit.BaseTestRoot;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

/**
 * \* User: silent
 * \* Date: 19/05/18 Time: 11:41
 * \* Description:
 * \
 */
public class BindAccountFlowTest extends BaseTestRoot {
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

//        mvc.perform(MockMvcRequestBuilders.post(baseUrl+"register")
//               // .content(mapper.writeValueAsString(param))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print()).andReturn();
    }

}
