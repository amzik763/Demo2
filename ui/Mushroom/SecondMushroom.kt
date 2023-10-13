package com.example.demo.ui.Mushroom

import android.graphics.Paint.Style
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.support.v4.os.IResultReceiver.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo.R
import androidx.compose.ui.text.TextStyle

class SecondMushroomActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Title2()
        }

    }
}


@Composable
fun Title2(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(153, 255, 255)),

        ) {

        Box(
            contentAlignment = Alignment.TopCenter
        ){
            Row(
                verticalAlignment = Alignment.Top,
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
                    fontSize = 30.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(10.dp)
                )

            }

        }

        Spacer(modifier = Modifier.height(45.dp))
        Box(
            modifier = Modifier
                .padding(start = 100.dp , end = 90.dp, top = 50.dp)
        ){
          Column(
              //modifier = Modifier
                //  .padding( top = 35.dp)
                  //.background(Color.Green),
          )
          {

              ClickableText(
                  text = AnnotatedString("TEMPERATURE"),
                  style = TextStyle(
                      color = Color.Black,
                      fontSize = 22.sp,
                      fontWeight = FontWeight.Bold

                  ),
                  modifier = Modifier
                      .border(width = 3.dp,color = Color(0, 102, 102), RoundedCornerShape(8.dp))
                      .padding( 20.dp),

                  onClick = { }

                  )
              Spacer(modifier = Modifier.height(40.dp))

              ClickableText(
                  text = AnnotatedString("    HUMIDITY     "),
                  style = TextStyle(
                      color = Color.Black,
                      fontSize = 22.sp,
                      fontWeight = FontWeight.Bold

                  ),
                  modifier = Modifier
                      .border(width = 3.dp,color = Color(0, 102, 102), RoundedCornerShape(8.dp))
                      .padding( 20.dp),

                  onClick = { }

              )
              Spacer(modifier = Modifier.height(40.dp))

              ClickableText(
                  text = AnnotatedString("         CO2            "),
                  style = TextStyle(
                      color = Color.Black,
                      fontSize = 22.sp,
                      fontWeight = FontWeight.Bold

                  ),
                  modifier = Modifier
                      .border(width = 3.dp,color = Color(0, 102, 102), RoundedCornerShape(8.dp))
                      .padding( 20.dp),

                  onClick = { }

              )
          }

        }

}


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2(){
    Surface(Modifier.fillMaxSize()) {
        Title2()
    }
}




