package com.example.firebasenotes.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CardNote(
    title: String,
    note: String,
    date: String,
    onClick: ()-> Unit
){
    var showAlert by remember{ mutableStateOf(false) }


    Column(modifier = Modifier
        .padding(start = 20.dp , end = 20.dp , top = 20.dp)
        .clickable { showAlert = true }
    ) {
        Row {
            Column() {
                Text(text=title, fontWeight = FontWeight.Bold)
                Text(text=date,color= Color.Gray)
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick={ onClick() }){
                Icon(imageVector = Icons.Default.Edit , contentDescription = "")
            }
        }

        Divider()
        if(showAlert){
            Alert(
                title=title ,
                message =  note,
                confirmText = "Aceptar" ,
                onConfirmClick = { showAlert = false }){

            }
        }

    }


}