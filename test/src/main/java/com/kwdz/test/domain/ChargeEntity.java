package com.kwdz.test.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @version 0.0.1
 * @author: huyt
 * @date: 2019/4/3 22:02
 */
@Entity
@Table(name = "charge", schema = "springbootdemo", catalog = "")
public class ChargeEntity {
    private String chargeId;
    private String chargeInfo;
    private String chargeItem;
    private String chargeStandard;

    @Id
    @Column(name = "charge_id")
    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    @Basic
    @Column(name = "charge_info")
    public String getChargeInfo() {
        return chargeInfo;
    }

    public void setChargeInfo(String chargeInfo) {
        this.chargeInfo = chargeInfo;
    }

    @Basic
    @Column(name = "charge_item")
    public String getChargeItem() {
        return chargeItem;
    }

    public void setChargeItem(String chargeItem) {
        this.chargeItem = chargeItem;
    }

    @Basic
    @Column(name = "charge_standard")
    public String getChargeStandard() {
        return chargeStandard;
    }

    public void setChargeStandard(String chargeStandard) {
        this.chargeStandard = chargeStandard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChargeEntity that = (ChargeEntity) o;
        return Objects.equals(chargeId, that.chargeId) &&
                Objects.equals(chargeInfo, that.chargeInfo) &&
                Objects.equals(chargeItem, that.chargeItem) &&
                Objects.equals(chargeStandard, that.chargeStandard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chargeId, chargeInfo, chargeItem, chargeStandard);
    }
}
