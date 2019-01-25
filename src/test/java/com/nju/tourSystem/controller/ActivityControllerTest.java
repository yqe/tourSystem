//package com.nju.tourSystem.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.nju.tourSystem.entity.Activity;
//import com.nju.tourSystem.entity.TourRecord;
//import com.nju.tourSystem.entity.User;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpSession;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
///**
// * @author xjc
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@WebAppConfiguration
//public class ActivityControllerTest {
//    @Autowired
//    private WebApplicationContext wac;
//
//    private MockMvc mvc;
//
//    private ObjectMapper mapper = new ObjectMapper();
//
//
//    @Before
//    public void setupMockMvc(){
//        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
//    }
//
//    /**
//     * 测试根据ID获取出游信息
//     */
//    @Test
//    public void getArticleTest() throws Exception {
//        int id = 1;
//        mvc.perform(MockMvcRequestBuilders.get("/activity/activityInfo/"+id)
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    /**
//     * 测试获取出游信息列表
//     */
//    @Test
//    public void getActivityListTest() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/activity/activityList")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    /**
//     * 测试添加出游
//     */
//    @Test
//    public void addActivityTest() throws Exception {
//        Activity activity = new Activity();
//        activity.setCreatedTime("2018-01-01");
//        activity.setDeadline("2018-01-01");
//        activity.setDescription("测试");
//        activity.setMaxNum(20);
//        activity.setName("测试");
//        activity.setOrganizerId(1);
//        mvc.perform(MockMvcRequestBuilders.post("/activity/addActivity")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .content(mapper.writeValueAsString(activity))
//                .contentType("application/json; charset=UTF-8")
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    /**
//     * 测试更新出游信息
//     */
//    @Test
//    public void updateActivityTest() throws Exception {
//        Activity activity = new Activity();
//        activity.setCreatedTime("2018-01-01");
//        activity.setDeadline("2018-01-01");
//        activity.setDescription("测试");
//        activity.setMaxNum(20);
//        activity.setName("测试");
//        activity.setOrganizerId(1);
//        activity.setState(true);
//        activity.setPayment(20.1);
////        String json="{\"id\":\"1\",\"uid\":\"1\",\"title\":\"标题\",\"content\":\"内容\",\"publishTime\":\"2018-01-01\",\"readNum\":\"1\"";
//        mvc.perform(MockMvcRequestBuilders.post("/activity/updateActivity")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .content(mapper.writeValueAsString(activity))
//                .contentType("application/json; charset=UTF-8")
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//
//    /**
//     * 测试搜寻出游活动
//     */
//    @Test
//    public void searchActivityTest() throws Exception {
//        String keyword = "测试";
//        mvc.perform(MockMvcRequestBuilders.get("/activity/searchActivity/"+keyword)
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    /**
//     * 测试参加出游
//     */
//    @Test
//    public void joinActivityTest() throws Exception {
//        int uid = 1;
//        int aid = 1;
//        mvc.perform(MockMvcRequestBuilders.get("/activity/joinActivity/"+uid+","+aid)
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    /**
//     * 测试参加人数多的出游活动
//     */
//    @Test
//    public void hotActivityTest() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/activity/hotActivity")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    /**
//     * 测试同意出游申请
//     */
//    @Test
//    public void applicationAgreementTest() throws Exception {
//        int id = 1;
//        mvc.perform(MockMvcRequestBuilders.get("/activity/applicationAgreement/"+id)
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    /**
//     * 测试获取参加的出游列表
//     */
//    @Test
//    public void myActivityListTest() throws Exception {
//        int id = 1;
//        mvc.perform(MockMvcRequestBuilders.get("/activity/myActivityList/"+id)
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    /**
//     * 测试获取申请阶段的出游列表
//     */
//    @Test
//    public void myapplicationListTest() throws Exception {
//        int id = 1;
//        mvc.perform(MockMvcRequestBuilders.get("/activity/myapplicationList/"+id)
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//
//}
