package com.back.backend.classes;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Nullable
    @ManyToOne(cascade = CascadeType.ALL)
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(@Nullable Room room) {
        this.room = room;
    }

    public Player(Long id, String name, Room roomId) {
        this.id = id;
        this.name = name;
        this.room = roomId;
    }

    public Player() {}

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
