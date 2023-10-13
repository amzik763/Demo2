package com.example.demo.ui.mqtt

import android.content.Context
import android.util.Log
import com.example.demo.Utility.sharedDataMushroom
import com.example.demo.data.PresetData
import com.example.demo.data.modelData
import com.google.gson.GsonBuilder
import com.somsakelect.android.mqtt.MqttAndroidClient
import kotlinx.coroutines.flow.MutableStateFlow
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.IMqttToken
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.MqttMessage

class ClientHelper(context : Context?) {


    lateinit var mqttClient:MqttAndroidClient
    var context = context

    lateinit var temp:String
    lateinit var hum:String
    lateinit var co2:String


    // TAG
    companion object {
        const val TAG = "Amzi: AndroidMqttClient"
    }

    val serverUri:String = "tcp://3.110.187.253:1883"
    private val clientId: String = MqttClient.generateClientId()


    fun connect(
        context: Context,
        temp2: MutableStateFlow<String>,
        hum2: MutableStateFlow<String>,
        co22: MutableStateFlow<String>,
        maxtemp2: MutableStateFlow<String>,
        maxhum2: MutableStateFlow<String>,
        maxco22: MutableStateFlow<String>,
        msharedDataMushroom: sharedDataMushroom
    ){
        val serverURI = serverUri

        mqttClient = MqttAndroidClient(context, serverURI, clientId)
        mqttClient.setCallback(object : MqttCallbackExtended {
            override fun messageArrived(topic: String?, message: MqttMessage?) {
                Log.d(ClientHelper.TAG, "Receive message: ${message.toString()} from topic: $topic")

                when(topic){
                    "temperature" ->{
                       // temp2.value = message.toString()
                    }
                    "humidity" ->{
                        hum = message.toString()
                    }
                    "co2" ->{
                        co2 = message.toString()
                    }
                    "maxTemperature" ->{
//                              maxTemperature = mess.toString()
                    }
                    "maxHumidity" ->{
//                              maxHumidity = mess.toString()
                    }
                    "maxCo2" ->{
//                              maxCo2 = mess.toString()
                    }
                    "Mashroom/Green/status" -> {
                        Log.d(TAG,"TEMP2: " + "largeData")
                        val gson = GsonBuilder().create()
                        val responseData = gson.fromJson(message.toString(),modelData::class.java)
                        temp2.value = responseData.d.LIVE_TEMP.toString()
                        hum2.value = responseData.d.LIVE_HUMIDITY.toString()
                        co22.value = responseData.d.LIVE_CO2.toString()

//                        if(msharedDataMushroom.getIsFirst()=="NOT"){
//                            msharedDataMushroom.commitPreset("40","60","1000")
//                            msharedDataMushroom.setIsFirst()
//                        }
//
//                        if(responseData.d.counter<2){
//                            val mPresetData: PresetData = msharedDataMushroom.getPreset()
//                            var formatedData = "UPDATE_PRESET_DATA=${mPresetData.temp.toString()},${mPresetData.hum.toString()},${mPresetData.co2.toString()}"
//                            Log.d("AMZI FOR: ",formatedData)
//
//
//
//                        }


                        maxtemp2.value = responseData.d.PRESET_TEMP.toString()
                        maxhum2.value = responseData.d.PRESET_HUMIDITY.toString()
                        maxco22.value = responseData.d.PRESET_CO2.toString()

                        Log.d(TAG,"TEMP2: " + hum2.value)
//                        Log.d(TAG,"TEMP2: " + "largeData")

                        Log.d(TAG,"TEMPO: " + responseData.d.LIVE_CO2)
                        Log.d(TAG,"TEMPO: " + responseData.d.LIVE_HUMIDITY)
                        Log.d(TAG,"TEMPO: " + responseData.d.LIVE_TEMP)
                    }
                }


            }

            override fun connectionLost(cause: Throwable?) {
                Log.d(ClientHelper.TAG, "Connection lost ${cause.toString()}")
            }

            override fun deliveryComplete(token: IMqttDeliveryToken?) {
                if (token != null && token.isComplete) {
                    println("Message published successfully.")
                }
            }

            override fun connectComplete(reconnect: Boolean, serverURI: String?) {
                Log.d(ClientHelper.TAG, "reconnect: "+reconnect)
                subscribe("Mashroom/Green/status",1)
//                subscribe("Mashroom/70:04:1D:55:94:9A/$/command",1)
//                subscribe("humidity",1)
//                subscribe("temperature",1)
//                subscribe("co2",1)
//                subscribe("maxTemperature")
//                subscribe("maxHumidity")
//                subscribe("maxCo2")
            }

        })

        val options = MqttConnectOptions()
        options.isAutomaticReconnect = CONNECTION_RECONNECT
        options.isCleanSession = CONNECTION_CLEAN_SESSION
        options.connectionTimeout = CONNECTION_TIMEOUT
        options.keepAliveInterval = CONNECTION_KEEP_ALIVE_INTERVAL
        try {
            mqttClient.connect(options, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken?) {
                    Log.d(TAG, "Connection success")
                    subscribe("Mashroom/Green/status",1)
//                    subscribe("Mashroom/70:04:1D:55:94:9A/$/command",1)
//                    subscribe("humidity",1)
//                    subscribe("temperature",1)
//                    subscribe("co2",1)
//                    subscribe("maxTemperature")
//                    subscribe("maxHumidity")
//                    subscribe("maxCo2")
                }

                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                    Log.d(TAG, "Connection failure")
                }
            })
        } catch (e: MqttException) {
            e.printStackTrace()
        }

    }

    fun subscribe(topic: String, qos: Int = 1) {
        try {
            mqttClient.subscribe(topic, qos, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken?) {
                    Log.d(TAG, "Subscribed to $topic")
                    publish(topic,"39")
                }

                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                    Log.d(TAG, "Failed to subscribe $topic")
                }
            })
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }


    fun publish(topic: String, msg: String, qos: Int = 1, retained: Boolean = false) {
        try {
            val message = MqttMessage()
            message.payload = msg.toByteArray()
            message.qos = qos
            message.isRetained = retained
            mqttClient.publish(topic, message, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken?) {
                    Log.d(TAG, "$msg published to $topic")
                }

                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                    Log.d(TAG, "Failed to publish $msg to $topic")
                }
            })
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }


    fun disconnect() {
        try {
            mqttClient.disconnect(null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken?) {
                    Log.d(TAG, "Disconnected")
                }

                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                    Log.d(TAG, "Failed to disconnect")
                }
            })
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    fun isConnected() : Boolean {
        return mqttClient!!.isConnected
    }

    fun destroy() {
        mqttClient!!.unregisterResources()
        mqttClient!!.disconnect()
    }

}