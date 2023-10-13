package com.example.demo.ui.mushroom

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.util.Log
import androidx.activity.contextaware.ContextAware
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.demo.R
import com.example.demo.ui.mqtt.MqttClientHelper.Companion.TAG
import com.example.demo.viewmodels.SecondViewModel

@Composable
fun Title(navController: NavHostController? = null, secondViewModel: SecondViewModel) {

    // Lock the screen orientation to portrait mode
    val activity = LocalContext.current as Activity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    Log.w(TAG, "checking..........................")

    //new variable
    val temp2 by secondViewModel.temp2.collectAsState()
    val hum2 by secondViewModel.hum2.collectAsState()
    val co22 by secondViewModel.co22.collectAsState()

    val maxtemp2 by secondViewModel.maxtemp2.collectAsState()
    val maxhum2 by secondViewModel.maxhum2.collectAsState()
    val maxco22 by secondViewModel.maxco22.collectAsState()

    var temp = secondViewModel.temperature
    val humid = secondViewModel.humidity
    val co2 = secondViewModel.co2

    val presetTemp = secondViewModel.maxTemperature
    val presetHumid = secondViewModel.maxHumidity
    val presetCo2 = secondViewModel.maxCo2


    Log.w(TAG, "checking")
    Log.w(TAG, "checking")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0, 102, 51)),

        ) {

//box for icon
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .padding(top = 25.dp, start = 70.dp)
                .size(width = 250.dp, height = 70.dp)
        ) {

            //Skaio Icon
            Icon(
                painter = painterResource(id = R.drawable.img1),
                contentDescription = "My Icon",
                tint = Color.Unspecified
            )

        }


        Spacer(modifier = Modifier.height(10.dp))
        //live data Surface
        Surface(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            color = (Color(0, 102, 51)),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(width = 1.dp, color = Color.LightGray)
        ) {
            Column(
                modifier = Modifier
                    .border(width = 2.dp,
                        color = Color(0xFF90EE90),
                        RoundedCornerShape(10.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center


            ) {
                Text(
                    text = "LIVE DATA",
                    fontSize = 30.sp,
                    color = Color(0xFF90EE90),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding( top = 20.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))

                //Live data Temperature
                Row {
                    Text(
                        text = temp2,
                        fontSize = 25.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold,
                       // modifier = Modifier.padding(start = 125.dp)

                    )
                    Spacer(modifier = Modifier.width(45.dp))
                    Text(
                        text = "°C",
                        fontSize = 25.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold

                    )
                }
                Spacer(modifier = Modifier.height(15.dp))

                //Live data humidity
                Row {
                    Text(
                        text = hum2,
                        fontSize = 25.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold,
                       // modifier = Modifier.padding(start = 125.dp)

                    )
                    Spacer(modifier = Modifier.width(49.dp))
                    Text(
                        text = "%",
                        fontSize = 30.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold

                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                //Live data Co2
                Row {
                    Text(
                        text = co22,
                        fontSize = 25.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 100.dp)

                    )
                    Spacer(modifier = Modifier.width(44.dp))
                    Text(
                        text = "PPM                ",
                        fontSize = 25.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold,


                        )

                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        //Preset Data Surface
        Surface(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            color = (Color(0, 102, 51)),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(width = 1.dp, color = Color.LightGray)
        ) {
            Column(
                modifier = Modifier.border(width = 2.dp,
                    color = Color(0xFF90EE90),
                    RoundedCornerShape(10.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "PRESET DATA",
                    fontSize = 30.sp,
                    color = Color(0xFF90EE90),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding( top = 20.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))


                //Preset Data Temperature
                Row {
                    Text(
                        text = maxtemp2,
                        fontSize = 25.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold,
                       // modifier = Modifier.padding(start = 125.dp)

                    )
                    Spacer(modifier = Modifier.width(45.dp))
                    Text(
                        text = "°C",
                        fontSize = 25.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold

                    )
                }
                Spacer(modifier = Modifier.height(15.dp))

                //Preset Data Humidity
                Row {
                    Text(
                        text = maxhum2,
                        fontSize = 25.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold,
                       // modifier = Modifier.padding(start = 125.dp)

                    )
                    Spacer(modifier = Modifier.width(49.dp))
                    Text(
                        text = "%",
                        fontSize = 30.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold

                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                //Preset Data Co2
                Row {
                    Text(
                        text = maxco22,
                        fontSize = 25.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 100.dp)

                    )
                    Spacer(modifier = Modifier.width(44.dp))
                    Text(
                        text = "PPM                ",
                        fontSize = 25.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold,


                        )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        //2nd screen button
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(top = 12.dp, start = 185.dp)
            // .size(100.dp)
        ) {

            //Setting Button
            IconButton(
                onClick = { navController?.navigate("SecondMushroom") },
                modifier = Modifier
                    //.padding(16.dp)
                    .size(40.dp)


            ) {
                Image(
                    painter = painterResource(id = R.drawable.img2),
                    contentDescription = "Favorite",
                    modifier = Modifier
                        //.padding(8.dp)
                        .size(90.dp)


                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        //contact info
        Surface(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            color = (Color(0, 102, 51)),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(width = 2.dp, color = Color(0xFF90EE90))
        ) {

            Column(modifier = Modifier.padding(5.dp)){
                Row {
                    Text(
                        text = "CONTACT US  :",
                        fontSize = 18.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 60.dp, top = 5.dp)
                    )
                    Spacer(modifier = Modifier.width(22.dp))
                    Text(
                        text = "9416922877",
                        fontSize = 18.sp,
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold,
                        //modifier = Modifier
                        //  .padding(top = 5.dp,)
                    )
                    Spacer(modifier = Modifier.width(39.dp))

                }

                Text(
                    text = "9034752777",
                    fontSize = 18.sp,
                    color = Color(0xFF90EE90),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 203.dp)
                )   //Spacer(modifier = Modifier.width(13.dp))
            }

        }

    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    Surface(Modifier.fillMaxSize()) {
       // Title(null,)
    }
}
