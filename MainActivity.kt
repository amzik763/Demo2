package com.example.demo

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demo.ui.theme.DemoTheme
import androidx.compose.ui.unit.sp as sp1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Title()
        }

    }
}

@Composable
fun Title() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(153,255,255)),

        ) {
        Box(
            contentAlignment = Alignment.TopCenter
        ) {
            Row(
                verticalAlignment = Alignment.Top,
                //modifier = Modifier.padding(1.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_3),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .aspectRatio(1.1f)
                        .padding(start = 5.dp)
                )

                Text(
                    text = "MUSHROOM PLANT AUTOMATION",
                    fontSize = 30.sp1,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(10.dp)


                )

            }

        }
        Spacer(modifier = Modifier.height(45.dp))

        Box() {

            Column(
                modifier = Modifier.padding(start = 90.dp)
            ) {
                Column(
                    modifier = Modifier.padding(11.dp)
                ) {
                    Text(
                        text = "TEMPERATURE(°C)" ,
                        fontSize = 24.sp1 ,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold

                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "                 " ,
                        fontSize = 35.sp1 ,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold ,
                        modifier = Modifier
                            .background(Color.White)
                            .padding(12.dp)
                    )

                }
                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier.padding(11.dp)
                ) {
                    Text(
                        text = "HUMIDITY(%)" ,
                        fontSize = 24.sp1 ,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                          .padding(start = 23.dp)


                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "                 " ,
                        fontSize = 35.sp1 ,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold ,
                        modifier = Modifier
                            .background(Color.White)
                            .padding(12.dp)
                    )

                }

                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier.padding(11.dp)
                ) {
                    Text(
                        text = "CO2(PPM)" ,
                        fontSize = 24.sp1 ,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 23.dp)


                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "                 " ,
                        fontSize = 35.sp1 ,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold ,
                        modifier = Modifier
                            .background(Color.White)
                            .padding(12.dp)
                    )

                }
            }


        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(top = 60.dp , start = 125.dp)
            // .size(100.dp)
        ){
            val isChecked = remember { mutableStateOf(false) }

            IconButton(
                onClick = { isChecked.value = !isChecked.value },
                modifier = Modifier
                    .padding(16.dp)
                    .size(100.dp)


            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Favorite",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(110.dp)
                        .background(Color(153,255,255))



                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    Surface(Modifier.fillMaxSize()) {
        Title()

    }

}