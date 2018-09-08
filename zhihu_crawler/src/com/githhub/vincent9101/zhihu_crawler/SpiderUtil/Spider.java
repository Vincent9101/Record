package com.githhub.vincent9101.zhihu_crawler.SpiderUtil;

import com.githhub.vincent9101.zhihu_crawler.entity.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>爬虫工具类</p>
 */
public class Spider {


    /**
     * 利用正则表达式 获得问题列表
     *
     * @param paramter 需要匹配的数据段落
     * @return TODO: 把对应的正则表达式参数化 从而更方便的自定义解析数据
     */

    public static List<Question> getQuestions(String paramter) {


        List<Question> questionsList = new ArrayList<Question>();
        Pattern titlePattern = Pattern.compile("question_link.+?>(.+?)<");
        Matcher titleMatcher = titlePattern.matcher(paramter);
        Pattern urlPattern = Pattern.compile("<h2>.+?question_link.+?href=\"(.+?)\".+?</h2>");
        Matcher urlMatcher = urlPattern.matcher(paramter);




        while (titleMatcher.find() && urlMatcher.find()) {
            Question temp = new Question();
            temp.setTitle(titleMatcher.group(1));
            temp.setQuestionUrl("https://www.zhihu.com" + urlMatcher.group(1));
            questionsList.add(temp);

        }
        return questionsList;
    }

    //发送请求 获得页面数据
    public static String sendGet(String url) {
        BufferedReader reader = null;
        String res = null;
        try {
            URL interNetUrl = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) interNetUrl.openConnection();

            urlConnection.connect();


            if (urlConnection.getResponseCode() != 200)                               // 200表示成功获取
            {
                System.out.println("响应码：" + urlConnection.getResponseCode());
                System.out.println("响应码不对，请查错。");
                return null;
            }

            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));

            String temp = null;

            while ((temp = reader.readLine()) != null) {
                res += temp;
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        System.out.print(res);
        return res;
    }
}
