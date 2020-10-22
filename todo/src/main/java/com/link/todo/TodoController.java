package com.link.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {
	
	List<Todo> todos;

	@GetMapping("/todo")
	public ModelAndView listTodos() {
		ModelAndView view = new ModelAndView("todo.html");
		return view;
	} 
	
	// get all
	// get one
	// delete
	// add
	// edit
	
	
//	@GetMapping("/api/todo")
//	@ResponseBody
//	public List<Map<String, String>> getTodos() {
//		List< Map<String, String> > todoList = 
//				new ArrayList< Map<String, String> >();
//		
//		Map<String, String> todo = new HashMap<String, String>();
//		
//		todo.put("title", "Mail factura");
//		todo.put("desc", "Mail catre RoCHI pt factura");
//		todo.put("status", "not started");
//		
//		todoList.add(todo);
//		
//		return todoList;
//	}
	
	@GetMapping("/api/todos") 
	public ResponseEntity<List<Todo>> getTodos() {
		if (this.todos == null) {
			this.todos = new ArrayList<Todo>();
		}
		return ResponseEntity.ok(this.todos);
	}
	
	@GetMapping("/api/todos/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable("id") int id) {
		System.out.println(id);
		
		for (int i = 0; i < this.todos.size(); i++) {
			if (this.todos.get(i).getId().equals(id)) {
				return ResponseEntity.ok(this.todos.get(i));
			}
		}
		
		return ResponseEntity.ok(null);
	}
	
	@PostMapping(value="/api/todos")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
		System.out.println(newTodo);
		
		// set default fields that the DB would set
		newTodo.setInProgress(false);
		newTodo.setStatus("not started");
		if (this.todos.size() == 0) {
			newTodo.setId(1);
		} else {
			Todo lastElem = this.todos.get(this.todos.size() - 1);
			newTodo.setId(lastElem.getId() + 1);
		}
		
		this.todos.add(newTodo);
		
		return ResponseEntity.ok(newTodo);
	}
	
	@PutMapping(value="/api/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable("id") int id, @RequestBody Todo newTodo) {
		System.out.println(id);
		System.out.println(newTodo);
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping("/api/todos/{id}")
	public ResponseEntity<Todo> deleteTodo(@PathVariable("id") int id) {
		System.out.println(id);
		for (int i = 0; i < this.todos.size(); i ++) {
			if (this.todos.get(i).getId().equals(id)) {
				Todo deletedTodo = this.todos.get(i);
				this.todos.remove(i);
				return ResponseEntity.ok(deletedTodo);
			}
		}
		
		return ResponseEntity.ok(null);
	}
	
}
