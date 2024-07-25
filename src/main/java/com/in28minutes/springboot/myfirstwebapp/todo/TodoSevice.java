package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoSevice {
	
	private static List<Todo> todoList = new ArrayList<>();
	private static int count = 0;
	
	static {
		todoList.add(new Todo(++count, "me", "Learn AWS", LocalDate.now().plusYears(1), false));
		todoList.add(new Todo(++count, "me", "Learn Full Stack", LocalDate.now().plusYears(2), false));
		todoList.add(new Todo(++count, "me", "Learn Power Bi", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todoList.stream().filter(predicate).toList();
	}

	public void addTodo(String name, String description, LocalDate date, boolean done) {
		
		todoList.add(new Todo(++count, name, description, date, done));
		
		// TODO Auto-generated method stub
		
	}

	public void deleteTodoService(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		// TODO Auto-generated method stub
		todoList.removeIf(predicate );
		
	}
	
	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		// TODO Auto-generated method stub
		return todoList.stream().filter(predicate).findFirst().get();
		
	}

	public void updateTodo(Todo todo) {
		
		deleteTodoService(todo.getId());
		todoList.add(todo);
		
		
	}

}
