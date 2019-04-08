package com.kwdz.test.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @version 0.0.1
 * @author: huyt
 * @date: 2019/4/3 22:02
 */
@Entity
@Table(name = "hibernate_sequence", schema = "springbootdemo", catalog = "")
public class HibernateSequenceEntity {
    private Long nextVal;

    @Basic
    @Column(name = "next_val")
    public Long getNextVal() {
        return nextVal;
    }

    public void setNextVal(Long nextVal) {
        this.nextVal = nextVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HibernateSequenceEntity that = (HibernateSequenceEntity) o;
        return Objects.equals(nextVal, that.nextVal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nextVal);
    }
}
