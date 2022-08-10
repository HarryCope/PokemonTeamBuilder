package com.qa.teamBuilder.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;
	
	@Column(nullable = false)
	private String team_name;

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(teamId, team_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(teamId, other.teamId) && Objects.equals(team_name, other.team_name);
	}

	@Override
	public String toString() {
		return "Teams [teamId= " + teamId + ", team name= " + team_name + "]";
	}
	
	
}
