package com.example.demo.ui.mushroom

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.demo.R
import com.example.demo.viewmodels.SecondViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Title2(navController: NavHostController? = null,secondViewModel: SecondViewModel) {

    // Lock the screen orientation to portrait mode
    val activity = LocalContext.current as Activity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    //for set presetValue
    val maxTemperature = remember { mutableStateOf("") }
    val maxHumidity = remember { mutableStateOf("") }
    val maxCo2 = remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0, 102, 51))
        ) {
        Box(contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .padding(top = 25.dp, start = 70.dp)
                .size(width = 250.dp, height = 70.dp)
        ){

            Icon(
                painter = painterResource(id = R.drawable.img1),
                contentDescription = "My Icon",
                tint = Color.Unspecified
            )

        }

        Spacer(modifier = Modifier.height(30.dp))
        //Set Values surface
        Surface(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            color = (Color(0, 102, 51)),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(width = 1.dp, color = Color.LightGray)
        ) {

            Column(
                modifier = Modifier
                    .border(width = 2.dp,color = Color(0xFF90EE90), RoundedCornerShape(10.dp))
            ) {

                Text(
                    text = "SET VALUES",
                    fontSize = 30.sp,
                    color = Color(0xFF90EE90),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 90.dp, top = 20.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))

                //Max Temperature Row
                Row(modifier = Modifier.padding(horizontal = 47.dp, vertical = 8.dp)) {
                    TextField(
                        value = maxTemperature.value,
                        onValueChange = { newText ->
                            if (newText.length <= 3) {
                                maxTemperature.value = newText
                            } else {
                                maxTemperature.value = newText.take(3)
                            }

                           },
                        placeholder = { Text(text = secondViewModel.maxTemperature)},
                        modifier = Modifier.size(100.dp,68.dp),
                        textStyle = TextStyle(fontSize = 20.sp,
                        fontWeight = FontWeight.Bold),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.width(125.dp))
                    Text(
                        text = "°C",
                        fontSize = 28.sp,
                        modifier = Modifier.padding(top = 10.dp),
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold
                    )

                   // Spacer(modifier = Modifier.width(40.dp))

//                    ClickableText(
//                        text = AnnotatedString("   SET"),
//                        style = TextStyle(
//                            color = Color(0xFF90EE90),
//                            fontSize = 20.sp,
//                            fontWeight = FontWeight.Bold
//                        ),
//                        modifier = Modifier
//                            .border(
//                                width = 3.dp,
//                                color = Color(0, 182, 102),
//                                RoundedCornerShape(8.dp)
//                            )
//                            .padding(top = 20.dp)
//                            .size(70.dp, 40.dp),
////                        onClick = { secondViewModel.pubTemperature(maxTemperature.value) }
//                        onClick = {
////                            secondViewModel.pubCo2(maxCo2.value)
////                            secondViewModel.pubHumidity(maxHumidity.value)
////                            secondViewModel.pubTemperature(maxTemperature.value)
//                        })

                   // Spacer(modifier = Modifier.width(40.dp))
                }

                Spacer(modifier = Modifier.height(10.dp))

                //Max Humidity Row
                Row(modifier = Modifier.padding(horizontal = 47.dp, vertical = 8.dp)) {
                    TextField(
                        value = maxHumidity.value,
                        onValueChange = { newText ->
                            if (newText.length <= 3) {
                                maxHumidity.value = newText
                            } else {
                                maxHumidity.value = newText.take(3)
                            }
                        },
                        placeholder = { Text(text = secondViewModel.maxHumidity)},
                        modifier = Modifier.size(100.dp,68.dp),
                        textStyle = TextStyle(fontSize = 20.sp,
                        fontWeight = FontWeight.Bold),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                    )
                    Spacer(modifier = Modifier.width(125.dp))
                    Text(
                        text = "%",
                        fontSize = 35.sp,
                        modifier = Modifier.padding(top = 10.dp),
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold

                    )
                  //  Spacer(modifier = Modifier.width(40.dp))

//                    ClickableText(
//                        text = AnnotatedString("   SET"),
//                        style = TextStyle(
//                            color = Color(0xFF90EE90),
//                            fontSize = 20.sp,
//                            fontWeight = FontWeight.Bold,
//                        ),
//                        modifier = Modifier
//                            .border(
//                                width = 3.dp,
//                                color = Color(0, 182, 102),
//                                RoundedCornerShape(8.dp)
//                            )
//                            .padding(top = 20.dp)
//                            .size(70.dp, 40.dp),
////                        onClick = { secondViewModel.pubHumidity(maxHumidity.value) }
//                        onClick = {
////                            secondViewModel.pubCo2(maxCo2.value)
////                            secondViewModel.pubHumidity(maxHumidity.value)
////                            secondViewModel.pubTemperature(maxTemperature.value)
//                        } )
                }
                Spacer(modifier = Modifier.height(10.dp))

                //Max Co2 Row
                Row(modifier = Modifier.padding(horizontal = 47.dp, vertical = 8.dp)) {
                    TextField(
                        value = maxCo2.value,
                        onValueChange = { newText ->
                            if (newText.length <= 5) {
                                maxCo2.value = newText
                            } else {
                                maxCo2.value = newText.take(5)
                            }
                        },
                        placeholder = { Text(text = secondViewModel.maxCo2) },
                        modifier = Modifier.size(100.dp, 68.dp),
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.width(100.dp))
                    Text(
                        text = "PPM",
                        fontSize = 25.sp,
                        modifier = Modifier.padding(top = 10.dp),
                        color = Color(0xFF90EE90),
                        fontWeight = FontWeight.Bold,
                    )

                    //Spacer(modifier = Modifier.width(30.dp))
                }
//                    ClickableText(
//                        text = AnnotatedString("   SET"),
//                        style = TextStyle(
//                            color = Color(0xFF90EE90),
//                            fontSize = 20.sp,
//                            fontWeight = FontWeight.Bold,
//                        ),
//                        modifier = Modifier
//                            .border(
//                                width = 3.dp,
//                                color = Color(0, 182, 102),
//                                RoundedCornerShape(8.dp)
//                            )
//                            .padding(top = 20.dp)
//                            .size(70.dp, 40.dp),
//                        onClick = {
////                            secondViewModel.pubCo2(maxCo2.value)
////                            secondViewModel.pubHumidity(maxHumidity.value)
//                            secondViewModel.pubTempHumidCo2(maxTemperature.value, maxHumidity.value, maxCo2.value)
//                        }
//                    )

                Row(
                    modifier = Modifier.padding(7.dp).align(Alignment.CenterHorizontally),
                ) {
                    Surface(modifier = Modifier
                        .padding(10.dp),
                        color = (Color(10, 200, 49)),
                        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                        border = BorderStroke(width = 1.dp, color = Color.LightGray)
                    ) {
                        ClickableText(
                            text = AnnotatedString("        SET"),
                            style = TextStyle(
                                color = Color(0xFF90EE90),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .size(120.dp, 40.dp),
                            onClick = {
//                            secondViewModel.pubCo2(maxCo2.value)
//                            secondViewModel.pubHumidity(maxHumidity.value)
                                secondViewModel.pubTempHumidCo2(
                                    maxTemperature.value,
                                    maxHumidity.value,
                                    maxCo2.value
                                )
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(7.dp))
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding( start = 155.dp)
            // .size(100.dp)
        ){

            IconButton(
                onClick = {navController?.navigate("FirstMushroom")},
                modifier = Modifier
                    //.padding(16.dp)
                    .size(90.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img7),
                    contentDescription = "Favorite",
                    modifier = Modifier
                        //.padding(8.dp)
                        .size(60.dp)
                    )
            }
    }

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
fun DefaultPreview2(){
    Surface(Modifier.fillMaxSize()) {
//        Title2()
    }

}