package cn.flylinran.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

/**
 * author: huzunrong
 * date: 2017/6/8 0:33
 * description:
 * version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    public void bookList() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/book")
                .param("pn", "1")
                .param("pageSize", "2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String resultStr = mvcResult.getResponse().getContentAsString();
        System.out.println(resultStr);
    }

}