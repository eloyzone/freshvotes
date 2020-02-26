package com.github.eloyzone.freshvotes.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/24/20, 16:19.
 */
@Embeddable
public class CommentId implements Serializable
{
    private static final long serialVersionUID = -5447497808830391423L;

    @ManyToOne
    private User user;
    @ManyToOne
    private Feature feature;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Feature getFeature()
    {
        return feature;
    }

    public void setFeature(Feature feature)
    {
        this.feature = feature;
    }
}
