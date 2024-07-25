package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

// @Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	private TodoSevice todoService;

	@RequestMapping(value = "todo-list")
	public String getTodo(ModelMap modelMap) {
		List<Todo> list = todoService.findByUsername(getLoggedInUserName());
		modelMap.put("list", list);
		return "todoList";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap modelMap) {
		String name = getLoggedInUserName();
		Todo todo = new Todo(0, name, "", LocalDate.now(), false);
		modelMap.put("todo", todo);
		return "addTodo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addTodo2(ModelMap modelMap, @Valid Todo todo, BindingResult bindingresult) {

		if (bindingresult.hasErrors()) {
//			System.out.println("error");
			return "addTodo";
		}
		String name = getLoggedInUserName();
		todoService.addTodo(name, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:todo-list";
	}

	@RequestMapping(value = "delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodoService(id);
		return "redirect:todo-list";
//		return "todoList";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdate(ModelMap modelMap, @RequestParam int id) {
		Todo todo = todoService.findById(id);
		modelMap.put("todo", todo);
		return "addTodo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String showUpdate(ModelMap modelMap, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "addTodo";
		}

		String name = (String) modelMap.get("name");
		todo.setUsername(name);

		todoService.updateTodo(todo);

		return "redirect:todo-list";
	}

	public String getLoggedInUserName() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication.getName();
	}

}
