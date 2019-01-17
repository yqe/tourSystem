package com.nju.tourSystem.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nju.tourSystem.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author yqe
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    }

    /**
     * 测试根据ID获取用户信息
     */
    @Test
    public void getUserTest() throws Exception {
        int userId = 1;
        mvc.perform(MockMvcRequestBuilders.get("/user/userinfo/"+userId)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 测试获取用户列表
     */
    @Test
    public void getUserListTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/userlist")
                .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 测试添加用户
     */
    @Test
    public void addUserTest() throws Exception {
//        String json="{\"username\":\"yhqqq\",\"password\":\"hapeyhqqq\",\"email\":\"1111111@qq.com\"}";
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setEmail("789456123@qq.com");
        user.setAge(21);
        user.setBalance(21);
        user.setPhone("13801234567");
        user.setDescription("我是张三");
        mvc.perform(MockMvcRequestBuilders.post("/user/addUser")
                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .content(json.getBytes())
                .content(mapper.writeValueAsString(user))
                .contentType("application/json; charset=UTF-8")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

//    /**
//     * 测试更新用户
//     */
//    @Test
//    public void updateUserTest() throws Exception {
//        String json="{\"id\":\"1\",\"username\":\"李四\",\"password\":\"panghu\",\"email\":\"1234567@qq.com\",\"balance\":\"60\"}";
//        mvc.perform(MockMvcRequestBuilders.post("/user/updateUser")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .content(json.getBytes())
//                .contentType("application/json; charset=UTF-8")
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }

    /**
     * 测试登录验证
     */
    @Test
    public void loginTest() throws Exception {
        String email = "542772747@qq.com";
        String password = "yhqqq";
        mvc.perform(MockMvcRequestBuilders.get("/user/login/"+email+","+password)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 测试查找用户
     */
    @Test
    public void searchUserTest() throws Exception {
        String keyword = "管";
        mvc.perform(MockMvcRequestBuilders.get("/user/searchUser/"+keyword)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}


