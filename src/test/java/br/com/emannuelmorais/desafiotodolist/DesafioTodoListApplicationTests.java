package br.com.emannuelmorais.desafiotodolist;

import br.com.emannuelmorais.desafiotodolist.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioTodoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSucess() {
		var todo = new Todo("todo 1", "desc todo 1", false, 1);

		webTestClient
				.post()
				.uri("/todos/create")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(todo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());

	}
	@Test
	void testCreateTodoFailure() {
		webTestClient
				.post()
				.uri("/todos/create")
				.bodyValue(new Todo("","", false, 0))
				.exchange()
				.expectStatus().isBadRequest();
	}
	@Test
	void testUpdateTodoSucess() {

	}
	@Test
	void testUpdateTodoFailure() {

	}
	@Test
	void testDeleteTodoSucess() {

	}
	@Test
	void  testDeleteTodoFailure() {

	}

}
