package com.kwdz.test.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @version 0.0.1
 * @author: huyt
 * @date: 2019/4/3 22:02
 */
@Entity
@Table(name = "room", schema = "springbootdemo", catalog = "")
public class RoomEntity {
    private String roomId;
    private String roomCode;
    private Long roomFloor;
    private String roomInfo;
    private String roomRent;
    private Double roomSize;

    @Id
    @Column(name = "room_id")
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "room_code")
    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    @Basic
    @Column(name = "room_floor")
    public Long getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(Long roomFloor) {
        this.roomFloor = roomFloor;
    }

    @Basic
    @Column(name = "room_info")
    public String getRoomInfo() {
        return roomInfo;
    }

    public void setRoomInfo(String roomInfo) {
        this.roomInfo = roomInfo;
    }

    @Basic
    @Column(name = "room_rent")
    public String getRoomRent() {
        return roomRent;
    }

    public void setRoomRent(String roomRent) {
        this.roomRent = roomRent;
    }

    @Basic
    @Column(name = "room_size")
    public Double getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Double roomSize) {
        this.roomSize = roomSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return Objects.equals(roomId, that.roomId) &&
                Objects.equals(roomCode, that.roomCode) &&
                Objects.equals(roomFloor, that.roomFloor) &&
                Objects.equals(roomInfo, that.roomInfo) &&
                Objects.equals(roomRent, that.roomRent) &&
                Objects.equals(roomSize, that.roomSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, roomCode, roomFloor, roomInfo, roomRent, roomSize);
    }
}
