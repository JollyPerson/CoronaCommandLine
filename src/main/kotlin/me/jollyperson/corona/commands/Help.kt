package me.jollyperson.corona.commands

import me.jollyperson.corona.Command
import me.jollyperson.corona.Main

class Help(private val main: Main) : Command {
    override fun getHelp(): String {
        return "Shows this message"
    }

    override fun run(args: List<String>) {
        main.getCommands()
            .forEach { (string: String, command: Command) ->
                println(string + " | " + command.getHelp())
            }
    }
}
