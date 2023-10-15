package kz.articles.articles_app.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "topic", nullable = false)
    private String topic;

    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "public_date")
    private Date publicDate;

    public Article() {
    }

    public Article(String topic, String text, Date publicDate) {
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

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", text='" + text + '\'' +
                ", publicDate=" + publicDate +
                '}';
    }
}
