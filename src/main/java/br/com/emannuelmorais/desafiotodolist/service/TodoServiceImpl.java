package br.com.emannuelmorais.desafiotodolist.service;

import br.com.emannuelmorais.desafiotodolist.entity.Todo;
import br.com.emannuelmorais.desafiotodolist.repository.TodoRepository;
import br.com.emannuelmorais.desafiotodolist.service.TodoService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> create(Todo todo) {
         todoRepository.save(todo);
         return list();
    }

    @Override
    public List<Todo> list() {
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending()
        );
        return todoRepository.findAll(sort);

    }

    @Override
    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    @Override
    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}
