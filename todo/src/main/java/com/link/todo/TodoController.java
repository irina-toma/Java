package com.link.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {

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
	
	@GetMapping("/api/todo") 
	public ResponseEntity<List<Todo>> getTodos2() {
		Todo todo1 = new Todo(1, "Mail factura", "Mail catre RoCHI pt factura", "not started", false);
		Todo todo2 = new Todo(2, "HTTPS", "Semantic HTTPS - urgent", "not started", false);
		Todo todo3 = new Todo(3, "Articol UNESCO", "De scris articol 8-10 pagini", "not started", false);
		
		List<Todo> todos = new ArrayList<Todo>();
		todos.add(todo1);
		todos.add(todo2);
		todos.add(todo3);
		return ResponseEntity.ok(todos);
		
	}
	
}
