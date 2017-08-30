package com.nemanja.vaadin.vaadinspringkotlin

import com.sun.org.apache.xpath.internal.operations.Bool
import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

/**
 * Created by nemanja on 8/29/2017.
 */
interface TodoRepository: JpaRepository<Todo, Long> {

    @Transactional
    fun deleteByDone(done: Boolean)
}