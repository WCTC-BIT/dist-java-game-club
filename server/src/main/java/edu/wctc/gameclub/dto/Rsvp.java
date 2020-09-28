package edu.wctc.gameclub.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Rsvp {
    private int eventId;
    private String memberEmail;
    private String status;
}
