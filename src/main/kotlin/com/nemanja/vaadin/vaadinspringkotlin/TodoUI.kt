package com.nemanja.vaadin.vaadinspringkotlin

import com.vaadin.event.ShortcutAction
import com.vaadin.icons.VaadinIcons
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.*
import com.vaadin.ui.themes.ValoTheme
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by nemanja on 8/29/2017.
 */
@SpringUI
class TodoUI : UI() {

    lateinit var root: VerticalLayout

    @Autowired
    lateinit var todoLayout: TodoLayout

    override fun init(p0: VaadinRequest?) {
        setupLayout()
        addHeader()
        addForm()
        addTodoList()
        addDeleteButton()
    }

    fun setupLayout() {
        root = VerticalLayout()
        root.defaultComponentAlignment = Alignment.MIDDLE_CENTER
        content = root
    }

    fun addHeader() {
        val header = Label("Todos")
        header.styleName = ValoTheme.LABEL_H1
        root.addComponent(header)
    }

    fun addForm() {
        val horizontalLayout: HorizontalLayout = HorizontalLayout()
        horizontalLayout.setWidth("80%")

        val text: TextField = TextField()

        val add: Button = Button()
        add.styleName = ValoTheme.BUTTON_PRIMARY
        add.icon = VaadinIcons.PLUS

        horizontalLayout.addComponentsAndExpand(text)
        horizontalLayout.addComponent(add)

        add.addClickListener(Button.ClickListener {
            todoLayout.add(Todo(text.value))
            text.clear()
            text.focus()
        })
        text.focus()
        add.setClickShortcut(ShortcutAction.KeyCode.ENTER)

        root.addComponent(horizontalLayout)
    }

    fun addTodoList() {
        todoLayout.setWidth("80%")
        root.addComponent(todoLayout)
    }

    fun addDeleteButton() {
        root.addComponent(Button("Delete completed", Button.ClickListener { todoLayout.delete() }))
    }

}