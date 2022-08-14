package com.qa.teamBuilder.controllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.teamBuilder.models.Pokemon;
import com.qa.teamBuilder.service.PokemonService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class PokemonControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private PokemonService service;
	
	@Test
	public void createPokemonTest() throws Exception {
		Pokemon testPokemon = new Pokemon("Pikachu", "Electric", 50, "Focus Sash");
		String testPokemonAsJSON = this.mapper.writeValueAsString(testPokemon);
		Mockito.when(this.service.createPokemon(testPokemon)).thenReturn(testPokemon);

		mvc.perform(post("/home/createPokemon")
				.content(testPokemonAsJSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(testPokemonAsJSON));
		
		Mockito.verify(this.service, Mockito.times(1)).createPokemon(testPokemon);	
		
	}
	

//	@Test
//    public void listAllUsers_whenGetMethod()
//            throws Exception {
//
//        User user = new User();
//        user.setName("Test name");
//
//        List<User> allUsers = Arrays.asList(user);
//
//        given(listUserService
//                .listAllUsers())
//                .willReturn(allUsers);
//
//        mvc.perform(get("/users")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", is(user.getName())));
//    }
}