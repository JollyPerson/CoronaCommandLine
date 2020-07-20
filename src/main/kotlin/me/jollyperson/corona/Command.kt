package me.jollyperson.corona

interface Command {

    fun run(args: List<String>)

    fun getHelp(): String


}