package com.nemanja.vaadin.vaadinspringkotlin

import com.vaadin.data.Binder
import com.vaadin.ui.Alignment
import com.vaadin.ui.CheckBox
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.TextField
import com.vaadin.ui.themes.ValoTheme
import javax.xml.soap.Text

/**
 * Created by nemanja on 8/29/2017.
 */
class TodoItemLayout: HorizontalLayout {

    lateinit var done: CheckBox
    lateinit var text: TextField

    constructor()

     constructor(todo: Todo): super() {
        done = CheckBox()
        text = TextField()

        text.styleName = ValoTheme.TEXTFIELD_BORDERLESS

        addComponent(done)
        addComponentsAndExpand(text)
        defaultComponentAlignment = Alignment.MIDDLE_LEFT

        val binder: Binder<Todo> = Binder<Todo>(Todo::class.java)
        binder.bindInstanceFields(this)
        binder.bean = todo
    }
}