package com.githhub.vincent9101.zhihu_crawler;


import com.githhub.vincent9101.zhihu_crawler.SpiderUtil.Spider;
import org.junit.jupiter.api.Test;

public class QuestionTest {

    @Test
    public  void testQuestion(){
       System.out.println(Spider.getQuestions( Spider.sendGet("https://www.zhihu.com/explore/recommendations")));
    }
}