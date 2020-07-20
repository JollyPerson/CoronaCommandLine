package me.jollyperson.corona

import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import me.jollyperson.corona.commands.Corona
import me.jollyperson.corona.commands.Countries
import me.jollyperson.corona.commands.Help
import me.jollyperson.corona.commands.Info
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.collections.HashMap
import kotlin.collections.HashSet

val countries = HashSet<String>()
val client = OkHttpClient().newBuilder().build()
val gson = GsonBuilder().setPrettyPrinting().create()
var commands = HashMap<String, Command>()
val corona = CoronaObject()

public class Main {
    public fun getCommands(): Map<String, Command>{
        return commands
    }
}


@ExperimentalStdlibApi
fun main(): Unit{
    commands["-countries"] = Countries(corona)
    commands["-help"] = Help(Main())
    commands["-info"] = Info()
    commands["-corona"] = Corona(corona)
    loadCountries()
    println("Hello, welcome to my corona test. Please enter a country or do -countries for a list of countries.")
    val input = readLine()
    if (input != null) {
        findCommand(input)
    }
}

@OptIn(ExperimentalStdlibApi::class)
fun getInput(){
    val input = readLine()
    if(input != null){
        findCommand(input)
    }else{
        getInput()
    }
}

@ExperimentalStdlibApi
fun findCommand(command: String){
    val commandI = command.split("\\s".toRegex()).toMutableList()
    if(commands.containsKey(commandI[0])){
        commandI.removeFirst()
        println(commandI)
        commands.get(command)?.run(commandI)
        getInput()
    }else{
        println("Could not fnd command.")
        getInput()
    }
}

fun loadCountries(){
    val request = Request.Builder().
        url("https://api.covid19api.com/countries")
        .method("GET", null)
        .build();
    val response = client.newCall(request).execute()
    val json = response.body?.string()
    val jsonArray = gson.fromJson(json, JsonArray::class.java)
    for (jsonElement in jsonArray) {
        //println("${jsonElement.asJsonObject.get("Country")}, ${jsonElement.asJsonObject.get("ISO2")}")
        var new = jsonElement.asJsonObject.get("Country").asString.replace("\"", "");
        countries.add(new.toLowerCase())
        //println(new)
    }
}