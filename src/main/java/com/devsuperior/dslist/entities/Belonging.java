package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    @Autowired
    private BelongingPK belongingPK;

    private Integer position;

    public Belonging() {};

    public Belonging(BelongingPK belongingPK, Integer position) {
        this.belongingPK = belongingPK;
        this.position = position;
    }

    public BelongingPK getBelongingPK() {
        return belongingPK;
    }

    public void setBelongingPK(BelongingPK belongingPK) {
        this.belongingPK = belongingPK;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return Objects.equals(belongingPK, belonging.belongingPK);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(belongingPK);
    }
}
