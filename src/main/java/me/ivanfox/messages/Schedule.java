package me.ivanfox.messages;

import java.util.List;
import lombok.Data;

@Data
public class Schedule {

    String ScheduleId;
    String Name;
    List<Departures> Departures;

}
