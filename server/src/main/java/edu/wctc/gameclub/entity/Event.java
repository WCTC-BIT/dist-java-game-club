package edu.wctc.gameclub.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int id;

    @Column(name = "title")
    private String name;

    @Column(name = "event_date")
    private LocalDateTime date;

    @Column(name="location")
    private String location;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "host_id", referencedColumnName = "member_id")
    private Member host;
}
