package kz.articles.articles_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ArticleDTO {

    private Long id;
    private String topic;
    private String text;

    @JsonProperty("public_date")
    private Date publicDate;

    public ArticleDTO() {
    }

    public ArticleDTO(Long id, String topic, String text, Date publicDate) {
        this.id = id;
        this.topic = topic;
        this.text = text;
        this.publicDate = publicDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }
}
