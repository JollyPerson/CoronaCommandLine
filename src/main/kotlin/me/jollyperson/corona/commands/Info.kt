package me.jollyperson.corona.commands

import me.jollyperson.corona.Command

class Info : Command {
    override fun run(args: List<String>) {
        println("heheleleloeoe")
    }

    override fun getHelp(): String {
        return "Information for this app?"
    }

}