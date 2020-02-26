package com.github.eloyzone.freshvotes.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/24/20, 16:16.
 */
@Entity
public class Comment
{
    @EmbeddedId
    private CommentId pk;
    @Column(length = 500)
    private String text;

    public CommentId getPk()
    {
        return pk;
    }

    public void setPk(CommentId pk)
    {
        this.pk = pk;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
