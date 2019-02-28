package com.dmap.common.swagger;

import com.dmap.base.junit.BaseTestRoot;
import io.github.robwin.markup.builder.MarkupLanguage;
import io.github.robwin.swagger2markup.GroupBy;
import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import springfox.documentation.staticdocs.SwaggerResultHandler;

/**
 * \* User: silent
 * \* Date: 17/09/18 Time: 22:28
 * \* Description:
 * \
 */
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class SwaggerGenerateTest extends BaseTestRoot {

    private String snippetDir = "target/generated-snippets";
    private String outputDir  = "target/asciidoc";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void Test() throws Exception {
        // 得到swagger.json,写入outputDir目录中
        mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
                .andDo(SwaggerResultHandler.outputDirectory(outputDir).build())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // 读取上一步生成的swagger.json转成asciiDoc,写入到outputDir
        // 这个outputDir必须和插件里面<generated></generated>标签配置一致
        Swagger2MarkupConverter.from(outputDir + "/swagger.json")
                .withPathsGroupedBy(GroupBy.TAGS)// 按tag排序
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)// 格式
                .withExamples(snippetDir)
                .build()
                .intoFolder(outputDir);// 输出

    }
    @Test
    public void TestApi() throws Exception {}
}
