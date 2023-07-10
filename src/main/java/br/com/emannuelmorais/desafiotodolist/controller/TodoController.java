package br.com.emannuelmorais.desafiotodolist.controller;

import br.com.emannuelmorais.desafiotodolist.entity.Todo;
import br.com.emannuelmorais.desafiotodolist.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody Todo todo){
        return ResponseEntity.ok(todoService.create(todo));

    }
    @GetMapping()
    ResponseEntity<?> list(){
        return ResponseEntity.ok(todoService.list());
    }
    @PutMapping("/update")
    ResponseEntity<?> update(@RequestBody Todo todo){
        return ResponseEntity.ok(todoService.create(todo));
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(todoService.delete(id));
    }
}
