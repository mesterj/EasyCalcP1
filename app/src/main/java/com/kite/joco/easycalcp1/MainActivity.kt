package com.kite.joco.easycalcp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kite.joco.easycalcp1.ui.theme.EasyCalcP1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasyCalcP1Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CalcMainScreen()
                }
            }
        }
    }
}

@Composable
fun CalcMainScreen() {
    var initvalue by remember {
        mutableStateOf(0.0)
    }

    Column() {


        Row(modifier = Modifier.padding(8.dp)) {
            Column() {
                Text( initvalue.toString(),textAlign = TextAlign.End,modifier = Modifier.fillMaxWidth())
            }
        }
        Row(modifier = Modifier.padding(8.dp).width(IntrinsicSize.Max)) {
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "7")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "8")               }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "9")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "./.")                }            }
        }

        Row(modifier = Modifier.padding(8.dp)) {
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "4")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "5")               }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "6")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "X")                }            }
        }

        Row(modifier = Modifier.padding(8.dp)) {
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "1")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "2")               }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "3")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "-")                }            }
        }
        Row(modifier = Modifier.padding(8.dp)) {
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "0")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = ",")               }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "=")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "+")                }            }
        }
    }

}

@Composable
fun CenterText() {
    Column() {
    Row() {
        Text("Hello World", textAlign = TextAlign.End, modifier = Modifier.width(150.dp))
    }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EasyCalcP1Theme {
        CalcMainScreen()
     //   CenterText()

    }
}