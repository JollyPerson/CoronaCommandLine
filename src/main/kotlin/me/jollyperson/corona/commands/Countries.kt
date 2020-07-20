package me.jollyperson.corona.commands

import me.jollyperson.corona.Command
import me.jollyperson.corona.CoronaObject

class Countries(private val corona: CoronaObject) : Command {

    override fun getHelp(): String {
        return "Returns a list of countries with available corona data."
    }

    override fun run(args: List<String>) {
        println("test")
        corona.getCountries().forEach{ country -> println("$country test")}
    }
}