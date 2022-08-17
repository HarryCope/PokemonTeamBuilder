package com.qa.teamBuilder.modelsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.qa.teamBuilder.models.Team;

import nl.jqno.equalsverifier.EqualsVerifier;

@TestInstance(Lifecycle.PER_CLASS)
public class TeamTest {
	
	static Team testTeam;

	@BeforeAll
	public static void buildTeam() {
		System.out.println("Building Team");
		testTeam = new Team(1L, "Team Test");
	}
	
	@Test
	public void constructors_Team_TeamWithId() {
		
		Team teamOne = new Team();

		assertTrue(teamOne instanceof Team == true);

		Team teamTwo = new Team(1L, "Team One");

		assertTrue(teamTwo instanceof Team == true);
		assertEquals(1L, teamTwo.getTeamId());
		assertEquals("Team One", teamTwo.getTeam_name());
		
	}
	
	@Test
	public void constructors_Team_Team() {

		Team teamTwo = new Team("Team Two");

		assertTrue(teamTwo instanceof Team == true);
		assertEquals("Team Two", teamTwo.getTeam_name());
		
	}
	
	@Test
	public void toString_String_TeamInstance() {
		String expecting = "Teams [teamId= " + testTeam.getTeamId() + ", team name= " + testTeam.getTeam_name() + "]";

		assertEquals(expecting, testTeam.toString());
	}

	@Test
    public void setTeamIdTest() throws NoSuchFieldException, IllegalAccessException {
        Team testEntry = new Team(1L, null);
        testEntry.setTeamId(2L);

       Field expected = testEntry.getClass().getDeclaredField("teamId");
        expected.setAccessible(true);
        assertEquals(expected.get(testEntry), 2L);
    }
	
	@Test
    public void setTeamNameTest() throws NoSuchFieldException, IllegalAccessException {
        Team testEntry = new Team(4L, "Test Team");
        testEntry.setTeam_name("Team Updated");

       Field expected = testEntry.getClass().getDeclaredField("team_name");
        expected.setAccessible(true);
        assertEquals(expected.get(testEntry), "Team Updated");
    }

	@Test
	public void hashAndEqualsTest() {
	    EqualsVerifier.simple().forClass(Team.class).verify();
	}
}
