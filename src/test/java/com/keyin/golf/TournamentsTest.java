package com.keyin.golf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class TournamentsTest {
    @Mock
    private Tournaments mockTournament;

    @Test
    public void testCreateNewTournament() {

        ArrayList<Long> membersInTourney = new ArrayList<>();
        membersInTourney.add(123L);
        membersInTourney.add(456L);
        membersInTourney.add(789L);

        Date startDate;
        try {
            startDate = new SimpleDateFormat("MMMMM dd, yyyy").parse("October 28, 2022");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Date endDate;
        try {
            endDate = new SimpleDateFormat("MMMMM dd, yyyy").parse("October 31, 2022");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Tournaments test1 = new Tournaments(123L, startDate, endDate, "Summerside Open", "Summerside Golf Club", 50L, 1000L, membersInTourney);
        Tournaments test2 = new Tournaments(456L, startDate, endDate, "PEI Fall Invitational", "Anderson Greek Golf Course", 100L, 2000L, membersInTourney);

        // Testing the creation of Tournament
        Mockito.when(mockTournament.createNewTournament()).thenReturn(test1);
        assertEquals(test1, mockTournament.createNewTournament());
        assertNotEquals(test2, mockTournament.createNewTournament());

        // Testing the get Tournament by ID
        Mockito.when(mockTournament.getTournamentId()).thenReturn(test1.getTournamentId());
        assertEquals(test1.getTournamentId(), mockTournament.getTournamentId());
        assertNotEquals(test2.getTournamentId(), mockTournament.getTournamentId());
    }

     @Test
     public void testGetTournamentById() throws ParseException {
        // Using tournaments.json for testing
        Tournaments test1 = new Tournaments();
        Tournaments test2 = new Tournaments();

        test2 = test1.getTournamentByIdForJson(1L);

        Assertions.assertEquals(1L, test2.getTournamentId());
        Assertions.assertNotEquals(2L, test2.getTournamentId());
    }

    @Mock
    private Members mockMember;
    private Tournaments mockTournamentsForMembers;
    @Test
    public void testUpdateMemberTournamentsStatus(){


        Assertions.assertEquals(new SimpleDateFormat("March 2, 2022"), mockTournamentsForMembers.getTournamentStartDate());
    }

     }

