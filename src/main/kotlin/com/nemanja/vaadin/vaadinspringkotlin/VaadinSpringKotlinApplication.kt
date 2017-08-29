package com.nemanja.vaadin.vaadinspringkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class VaadinSpringKotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(VaadinSpringKotlinApplication::class.java, *args)
}
