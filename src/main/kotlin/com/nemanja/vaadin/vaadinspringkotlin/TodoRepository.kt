package com.nemanja.vaadin.vaadinspringkotlin

import com.sun.org.apache.xpath.internal.operations.Bool
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by nemanja on 8/29/2017.
 */
interface TodoRepository: JpaRepository<Todo, Long> {

    fun deleteByDone(done: Boolean)
}