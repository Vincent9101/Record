package com.githhub.vincent9101.zhihu_crawler.entity;

import java.util.ArrayList;

/**
 * @author Vincent
 * <p>爬取知乎推荐页问题的实体类</p>
 */
public class Question {
    private String title;
    private String titleDescription;
    private String questionUrl;
    private ArrayList<String> answers;

    public Question(String title, String titleDescription, String questionUrl, ArrayList<String> answers) {
        this.title = title;
        this.titleDescription = titleDescription;
        this.questionUrl = questionUrl;
        this.answers = answers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Question() {
        title = "";
        titleDescription = "";
        questionUrl = "";

        answers = new ArrayList<String>();
    }


    public String getTitleDescription() {
        return titleDescription;
    }

    public void setTitleDescription(String titleDescription) {
        this.titleDescription = titleDescription;
    }

    public String getQuestionUrl() {
        return questionUrl;
    }

    public void setQuestionUrl(String questionUrl) {
        this.questionUrl = questionUrl;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", titleDescription='" + titleDescription + '\'' +
                ", questionUrl='" + questionUrl + '\'' +
                ", answers=" + answers +
                '}';
    }
}
