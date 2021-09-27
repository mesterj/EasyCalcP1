package com.kite.joco.easycalcp1

import android.os.Bundle
import android.util.Log
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
        mutableStateOf("0.0")
    }
    var elsoertek by remember {
        mutableStateOf( "")
    }
    var utolsomuvelet by remember {
        mutableStateOf("")
    }

    fun kiir(numberString: String) {
        if (initvalue.equals("0.0")) {
            initvalue = numberString
        } else {
            initvalue = initvalue + numberString
        }
    }

    fun egyenlo() {
        Log.d("CALC","elsoertek $elsoertek initvalue: $initvalue")
        if (utolsomuvelet.equals("+")) {
            initvalue =  (elsoertek.toDouble()+initvalue.toDouble()).toString()
        } else if (utolsomuvelet.equals("-")) {
            initvalue = (elsoertek.toDouble()-initvalue.toDouble()).toString()
        } else if (utolsomuvelet.equals("*")) {
            initvalue = (elsoertek.toDouble()*initvalue.toDouble()).toString()
        } else {
            initvalue = (elsoertek.toDouble()/initvalue.toDouble()).toString()
        }
    }

   fun szamit(muvelet: String) {
        Log.d("CALC", "Elsőérték $elsoertek, jelenlegi: $initvalue")
        utolsomuvelet = muvelet
        if (elsoertek.equals("")) {
            elsoertek = initvalue
            Log.d("CALC","Elso érték: $elsoertek mentve, kilép")
            initvalue = "0.0"
        } else {
            Log.d("CALC", "Elsoérték:$elsoertek jelenlegi: $initvalue")
            var eredmeny1 = when (muvelet) {
                "/" -> elsoertek.toDouble() / initvalue.toDouble()
                "+" -> elsoertek.toDouble() + initvalue.toDouble()
                "-" -> elsoertek.toDouble() - initvalue.toDouble()
                "*" -> elsoertek.toDouble() * initvalue.toDouble()
                else -> 0.0
            }
            initvalue = eredmeny1.toString()
            Log.d("CALC", "részeredmeny: $initvalue")
        }


        Log.d("CALC","számítás vége")

    }

    Column() {


        Row(modifier = Modifier.padding(8.dp)) {
            Column() {
                Text( initvalue,textAlign = TextAlign.End,modifier = Modifier.fillMaxWidth())
            }
        }
        Row(modifier = Modifier
            .padding(8.dp)
            .width(IntrinsicSize.Max)) {
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { kiir("7") }) {
                    Text(text = "7")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { kiir("8") }) {
                    Text(text = "8")               }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { kiir("9") }) {
                    Text(text = "9")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { szamit("/") }) {
                    Text(text = "./.")                }            }
        }

        Row(modifier = Modifier.padding(8.dp)) {
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { kiir("4")}) {
                    Text(text = "4")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { kiir("5") }) {
                    Text(text = "5")               }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { kiir("6") }) {
                    Text(text = "6")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { szamit("*") }) {
                    Text(text = "X")                }            }
        }

        Row(modifier = Modifier.padding(8.dp)) {
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { kiir("1") }) {
                    Text(text = "1")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { kiir("2") }) {
                    Text(text = "2")               }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { kiir("3") }) {
                    Text(text = "3")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { szamit("-") }) {
                    Text(text = "-")                }            }
        }
        Row(modifier = Modifier.padding(8.dp)) {
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { kiir("0") }) {
                    Text(text = "0")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { kiir(",") }) {
                    Text(text = ",")               }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { egyenlo() }) {
                    Text(text = "=")                }            }
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = { szamit("+") }) {
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