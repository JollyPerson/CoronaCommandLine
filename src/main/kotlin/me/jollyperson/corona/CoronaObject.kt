package me.jollyperson.corona

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.*

class CoronaObject {


    val client = OkHttpClient()
    val countrySet = HashSet<String>()

    fun getCountries(): Set<String>{
        if(countrySet.isEmpty()){
            val request = Request.Builder().
            url("https://api.covid19api.com/countries")
                .method("GET", null)
                .build();
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            val jsonArray = gson.fromJson(json, JsonArray::class.java)
            for (jsonElement in jsonArray) {
                //println("${jsonElement.asJsonObject.get("Country")}, ${jsonElement.asJsonObject.get("ISO2")}")
                val new = jsonElement.asJsonObject.get("Country").asString.replace("\"", "");
                countrySet.add(new.toLowerCase())
            }
            return countrySet
        }
        return countrySet;
    }

    fun getCountry(countryName: String): JsonElement? {
        
     return null
    }

}