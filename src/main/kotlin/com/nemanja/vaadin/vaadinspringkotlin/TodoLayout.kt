package com.nemanja.vaadin.vaadinspringkotlin

import com.vaadin.spring.annotation.SpringComponent
import com.vaadin.ui.VerticalLayout
import org.springframework.beans.factory.annotation.Autowired
import javax.annotation.PostConstruct

/**
 * Created by nemanja on 8/29/2017.
 */
@SpringComponent
class TodoLayout : VerticalLayout() {

    @Autowired
    lateinit var repo: TodoRepository

    @PostConstruct
    fun init() {
        reload()
    }

    fun reload() {
        setTodos(repo.findAll())
    }

    fun setTodos(todos: List<Todo>){
        removeAllComponents()
        todos.forEach { todo -> addComponent(TodoItemLayout(todo)) }
    }

    fun add(todo: Todo){
        repo.save(todo)
        reload()
    }

    fun delete(){
        repo.deleteByDone(true)
        reload()
    }
}