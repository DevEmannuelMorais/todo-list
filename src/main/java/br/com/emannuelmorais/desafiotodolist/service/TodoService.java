package br.com.emannuelmorais.desafiotodolist.service;

import br.com.emannuelmorais.desafiotodolist.entity.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> create(Todo todo);
    List<Todo> list();
    List<Todo> update(Todo todo);
    List<Todo> delete(Long id);
}
