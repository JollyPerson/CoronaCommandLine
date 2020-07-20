package me.jollyperson.corona.commands

import me.jollyperson.corona.Command
import me.jollyperson.corona.CoronaObject

class Corona constructor(private val corona: CoronaObject) : Command {
    override fun run(args: List<String>) {
        println(args)
        if(args.isEmpty()){
            println("-corona <country> <confirmed/dead/recovered/all>")
            return
        }
        if(!corona.getCountries().contains(args[0].toLowerCase())) {
            println("Could not find country: ${args[0]} do -countries")
            return
        }
        corona.getCountry(args[0])
    }

    override fun getHelp(): String {
        return "Returns help "
    }
}