package org.papaja.adminfly.module.blog.entity;

import org.papaja.adminfly.commons.dao.entity.api.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "BLOG_POSTS")
public class Post extends AbstractEntity {

    @OneToOne
    @JoinColumn(name="DOMAIN_ID")
    private Domain domain;

    @OneToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY", columnDefinition = "MEDIUMTEXT")
    private String body;

    @Column(name = "VIEWS")
    private Integer views;

    @Column(name = "ENABLED")
    private boolean enabled;

    @Column(name = "CREATED")
    private Timestamp created;

    @Column(name = "UPDATED")
    private Timestamp updated;

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return String.format("Post{domain=%s, category=%s, title='%s', body='%s', views=%d, created=%s, updated=%s}",
            domain, category, title, body, views, created, updated);
    }
}
