package edu.wctc.gameclub.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CalendarEvent {
    private int id;
    private String name;
    private String location;
    private String description;
    private LocalDateTime date;
    private int hostId;
    private String type = "Event"; // required field for EvoCalendar JS library
}
