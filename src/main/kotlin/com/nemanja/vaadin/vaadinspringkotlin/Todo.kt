package com.nemanja.vaadin.vaadinspringkotlin

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by nemanja on 8/29/2017.
 */
@Entity
class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var text: String = ""
    var done: Boolean = false

    constructor()
    constructor(t: String){
        text = t
    }
}
