package com.example.demo.viewmodels

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.data.modelData
import com.example.demo.ui.mqtt.ClientHelper
import com.example.demo.Utility.sharedDataMushroom
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SecondViewModel(
     context: Context
     ) : ViewModel() {
     val ct = context

//     val mqttClient = MqttClientHelper(context.applicationContext)
     val mqttClient = ClientHelper(context.applicationContext)

     //shared Preferences
     val msharedDataMushroom =  sharedDataMushroom(context)

     //new variable
     var temp2 =  MutableStateFlow("0")
     var hum2 = MutableStateFlow<String>("0")
     var co22 = MutableStateFlow<String>("0")

     var maxtemp2 = MutableStateFlow<String>("0")
     var maxhum2 = MutableStateFlow<String>("0")
     var maxco22 = MutableStateFlow<String>("0")


     lateinit var responseData:modelData
     var temperature by mutableStateOf("0")
          private set

     var humidity by mutableStateOf("0")
          private set

     var co2 by mutableStateOf("0")
          private set

     var maxTemperature by mutableStateOf("0")
          private set

     var maxHumidity by mutableStateOf("0")
          private set

     var maxCo2 by mutableStateOf("0")
          private set

     init {
          viewModelScope.launch {
               Log.d("not","find me")
               startFetchingData2()
          }


          //Temporary code
         /* GlobalScope.launch(Dispatchers.Default) {
               while (true) {
                    // Call your function here
                    if (mqttClient.isConnected()){
                         Log.d("AMZI: cor","data sending")

                         val randomTemp = Random.nextInt(1, 101)
                         val randomHum = Random.nextInt(1, 101)
                         val randomCO2 = Random.nextInt(1, 101)
                         var formatedData = "UPDATE_PRESET_DATA=$randomTemp,$randomHum,$randomCO2"
                         if(temperature.isNotEmpty())

                              mqttClient.publish("Mashroom/70:04:1D:55:94:9A/$/command",formatedData)
                    }

                    // Delay for 15 seconds
                    delay(20000L) // 15 seconds in milliseconds
               }
          }*/

     }

     private fun startFetchingData2() {

          mqttClient.connect(mqttClient.context!!,temp2,hum2,co22,maxtemp2,maxhum2,maxco22,msharedDataMushroom)


     }




     //setting maximum value of ...
     fun pubTemperature ( temperature: String ) {
          if (mqttClient.isConnected()){
               var formatedData = "UPDATE_PRESET_DATA=$temperature,$maxHumidity,$maxCo2"
               if(temperature.isNotEmpty())
                    mqttClient.publish("Mashroom/70:04:1D:55:94:9A/$/command",formatedData)
          }
     }

 //    setting maximum value of ...
     fun pubTempHumidCo2 ( temperature: String, humidity: String, co2: String) {
          if (mqttClient.isConnected()){
               var formatedData = "UPDATE_PRESET_DATA=$temperature,$humidity,$co2"
               Log.d("AMZI FOR: ",formatedData)

               if(temperature.isNotEmpty()||humidity.isNotEmpty()||co2.isNotEmpty())
                    mqttClient.publish("Mashroom/70:04:1D:55:94:9A/$/command",formatedData)
               }
     }




     fun pubHumidity ( humidity: String ) {
          if (mqttClient.isConnected()){
               var formatedData = "UPDATE_PRESET_DATA=$maxTemperature,$humidity,$maxCo2"
               if(humidity.isNotEmpty())
                    mqttClient.publish("Mashroom/70:04:1D:55:94:9A/$/command",formatedData)
          }
     }
//
     fun pubCo2 ( co2: String ) {
          if (mqttClient.isConnected()) {
               var formatedData = "UPDATE_PRESET_DATA=$maxTemperature,$maxHumidity,$co2"
               if(co2.isNotEmpty())
                    mqttClient.publish("Mashroom/70:04:1D:55:94:9A/$/command",formatedData)
          }
     }
//
//     private suspend fun startFetchingData() {
//          mqttClient.setCallback(object : MqttCallbackExtended {
//               override fun connectComplete(reconnect: Boolean, serverURI: String) {
//                    Log.w(MqttClientHelper.TAG, "MQTT reconnect...$reconnect")
//               }
//
//               override fun connectionLost(cause: Throwable) {
//                    Log.e(MqttClientHelper.TAG, "MQTT lost..." + cause.message)
//                    val st = "MQTT lost! " + cause.message
//               }
//
//               override fun messageArrived(topic: String, message: MqttMessage) {
//                    val mess = message.toString()
//                    Log.d("amzi: messagearrived",mess)
//                    Log.d("amzi: topicarrived",topic)
//                    val log = String.format("MQTT RX [%s]: %s", topic, mess)
//                    Log.d("amzi: messagearrivedformated",log)
//
//                    when(topic){
//                         "temperature" ->{
//                              temperature = mess.toString()
//                         }
//                         "humidity" ->{
//                              humidity = mess.toString()
//                         }
//                         "co2" ->{
//                              co2 = mess.toString()
//                         }
//                         "maxTemperature" ->{
//                              maxTemperature = mess.toString()
//                         }
//                         "maxHumidity" ->{
//                              maxHumidity = mess.toString()
//                         }
//                         "maxCo2" ->{
//                              maxCo2 = mess.toString()
//                         }
//                         "Mashroom/Green/status" -> {
//                              val jsonObject = JSONObject(mess)
//                              val environmentData = jsonObject.getJSONObject("d").getString("Environment Data")
//                              println("Environment Data: $environmentData")
//
//                              val separatedList = environmentData.split(",")
//                              // Print the extracted data
//                              for (item in separatedList) {
//                                   println(item)
//                              }
//                              co2 = separatedList[0]
//                              temperature = separatedList[1]
//                              humidity = separatedList[2]
//                              maxCo2 = separatedList[3]
//                              maxTemperature = separatedList[4]
//                              maxHumidity = separatedList[5]
//
//                              Toast.makeText(
//                                   ct, environmentData,
//                                   Toast.LENGTH_LONG
//                              ).show()
//                         }
//                         "Mashroom/Green/preset"->{
//                              val jsonObject = JSONObject(mess)
//                              val environmentData = jsonObject.getJSONObject("d").getString("Environment Data")
//                              println("Environment preset Data: $environmentData")
//
//                              val separatedList = environmentData.split(",")
//                              // Print the extracted data
//                              for (item in separatedList) {
//                                   println(item)
//                              }
//                              maxTemperature = separatedList[0]
//                              maxHumidity = separatedList[1]
//                              maxCo2 = separatedList[2]
//                         }
//                         "Mashroom/70:04:1D:55:94:9A/$/command"->{
//                              val separatedList = mess.split("=")
//                              val maxparam = separatedList[1].toString().split(",")
//                              maxTemperature = maxparam[0]
//                              maxHumidity = maxparam[1]
//                              maxCo2 = maxparam[2]
//                         }
//                    }
////                    Log.d("not","temp: ${state.temperature} hum: ${state.humidity} co2: ${state.co2}")
//                Log.w(MqttClientHelper.TAG, log)
//               }
//               override fun deliveryComplete(token: IMqttDeliveryToken) {
//                    Log.w(MqttClientHelper.TAG, "Publish success...")
//               }
//          })
//     }
}
