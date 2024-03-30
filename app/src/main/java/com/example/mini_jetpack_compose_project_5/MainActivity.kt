package com.example.mini_jetpack_compose_project_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mini_jetpack_compose_project_5.ui.theme.Minijetpackcomposeproject5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Minijetpackcomposeproject5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculor()
                }
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun Calculor() {

        var value1 = remember {
            mutableStateOf("")
        }
        var value2 = remember {
            mutableStateOf("")
        }
        var result = remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = value1.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = {
                    value1.value = it
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = value2.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = {
                    value2.value = it
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(40.dp))
            Row {
                Button(onClick = {
                    result.value = (value1.value.toDouble() + value2.value.toDouble()).toString()
                }) {
                    Text(text = "+")

                }
                Spacer(modifier = Modifier.width(40.dp))

                Button(onClick = {
                    result.value = (value1.value.toDouble() * value2.value.toDouble()).toString()
                }) {
                    Text(text = "*")

                }


            }
            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Button(onClick = {
                    result.value = (value1.value.toDouble() - value2.value.toDouble()).toString()
                }) {

                    Text(text = "-")

                }
                Spacer(modifier = Modifier.width(40.dp))

                Button(onClick = {
                    result.value = (value1.value.toDouble() / value2.value.toDouble()).toString()
                }) {
                    Text(text = "/")

                }


            }
            Spacer(modifier = Modifier.height(60.dp))
            if (result.value.isNotEmpty()) {
                Text(text = "The result is :${result.value} ")

            }


        }

    }

}

