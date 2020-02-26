package com.github.eloyzone.freshvotes.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/24/20, 15:49.
 */
@Embeddable
public class VoteId implements Serializable
{
    private static final long serialVersionUID = -1689574419597665598L;

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
