package com.kwdz.test.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @version 0.0.1
 * @author: huyt
 * @date: 2019/4/3 22:02
 */
@Entity
@Table(name = "record", schema = "springbootdemo", catalog = "")
public class RecordEntity {
    private String recordId;
    private String recordGas;
    private String recordItem;
    private String recordNumber;
    private String recordPower;
    private Timestamp recordTime;
    private String recordWater;
    private String roomId;

    @Id
    @Column(name = "record_id")
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "record_gas")
    public String getRecordGas() {
        return recordGas;
    }

    public void setRecordGas(String recordGas) {
        this.recordGas = recordGas;
    }

    @Basic
    @Column(name = "record_item")
    public String getRecordItem() {
        return recordItem;
    }

    public void setRecordItem(String recordItem) {
        this.recordItem = recordItem;
    }

    @Basic
    @Column(name = "record_number")
    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    @Basic
    @Column(name = "record_power")
    public String getRecordPower() {
        return recordPower;
    }

    public void setRecordPower(String recordPower) {
        this.recordPower = recordPower;
    }

    @Basic
    @Column(name = "record_time")
    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    @Basic
    @Column(name = "record_water")
    public String getRecordWater() {
        return recordWater;
    }

    public void setRecordWater(String recordWater) {
        this.recordWater = recordWater;
    }

    @Basic
    @Column(name = "room_id")
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordEntity that = (RecordEntity) o;
        return Objects.equals(recordId, that.recordId) &&
                Objects.equals(recordGas, that.recordGas) &&
                Objects.equals(recordItem, that.recordItem) &&
                Objects.equals(recordNumber, that.recordNumber) &&
                Objects.equals(recordPower, that.recordPower) &&
                Objects.equals(recordTime, that.recordTime) &&
                Objects.equals(recordWater, that.recordWater) &&
                Objects.equals(roomId, that.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId, recordGas, recordItem, recordNumber, recordPower, recordTime, recordWater, roomId);
    }
}
