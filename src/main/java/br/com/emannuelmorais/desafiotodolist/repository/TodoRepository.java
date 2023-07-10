package br.com.emannuelmorais.desafiotodolist.repository;

import br.com.emannuelmorais.desafiotodolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
