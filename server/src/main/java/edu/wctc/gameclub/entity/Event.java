package edu.wctc.gameclub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    private String location;

    private String description;

    @ManyToOne
    @JoinColumn(name = "host_id", referencedColumnName = "member_id")
    private Member host;
}
