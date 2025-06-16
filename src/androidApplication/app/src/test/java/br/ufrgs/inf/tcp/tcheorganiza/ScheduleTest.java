package test;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Schedule;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Office;
import org.threeten.bp.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScheduleTest {
    
    private Schedule schedule;
    private Office office, lab;

    @BeforeEach
    public void setUp() {
        office = new Office(218, 43424);
        lab = new Office(104,43413);
        schedule = new Schedule("terça", office, LocalTime.of(10, 30), LocalTime.of(12, 10));
    }

    @Test
    public void testGetters() {
        assertEquals("terça", schedule.getWeekday());
        assertEquals(office, schedule.getOffice());
        assertEquals(LocalTime.of(10, 30), schedule.getBeginTime());
        assertEquals(LocalTime.of(12, 10), schedule.getEndTime());
    }

    @Test
    public void testSetters() {
        schedule.setWeekday("quinta");
        schedule.setOffice(lab);
        schedule.setTime(LocalTime.of(11, 30), LocalTime.of(12, 00));

        assertEquals("quinta", schedule.getWeekday());
        assertEquals(lab, schedule.getOffice());
        assertEquals(LocalTime.of(11, 30), schedule.getBeginTime());
        assertEquals(LocalTime.of(12, 00), schedule.getEndTime());
    }

    @Test
    public void testGetScheduleDetails() {
        assertEquals("terça, 10:30 - 12:10, Sala 218, Predio 43424", schedule.getScheduleDetails());
    }
}