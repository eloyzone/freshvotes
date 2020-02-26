package com.github.eloyzone.freshvotes.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/24/20, 15:48.
 */
@Entity
public class Vote
{
    @EmbeddedId
    private VoteId pk;
    private Boolean upVote;

    public VoteId getPk()
    {
        return pk;
    }

    public void setPk(VoteId pk)
    {
        this.pk = pk;
    }

    public Boolean getUpVote()
    {
        return upVote;
    }

    public void setUpVote(Boolean upVote)
    {
        this.upVote = upVote;
    }
}
