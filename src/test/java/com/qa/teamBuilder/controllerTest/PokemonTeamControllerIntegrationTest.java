package com.qa.teamBuilder.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.teamBuilder.models.Pokemon;
import com.qa.teamBuilder.service.PokemonService;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath-schema", "classpath:cat-data.sql"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PokemonTeamControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private PokemonService service;
	
	public void createIntegrationTest() throws Exception{
		Pokemon testPokemon = new Pokemon("pikachu", "electric", 50, "Focus Sash");
		String testPokemonAsJSON = this.mapper.writeValueAsString(testPokemon);
		
		mvc.perform(post("home/createPokemon")
				.content(testPokemonAsJSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(testPokemonAsJSON));

		Mockito.verify(this.service, Mockito.times(1)).createPokemon(testPokemon);
	}
	
}
