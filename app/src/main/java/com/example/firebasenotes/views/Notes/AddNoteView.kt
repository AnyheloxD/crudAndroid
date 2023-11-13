package com.example.firebasenotes.views.Notes

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firebasenotes.viewModels.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteView(navController: NavController , notesVm: NotesViewModel){

    var title by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }
    val context = LocalContext.current


    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text="Nueva Nota")},
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }){
                        Icon(
                            imageVector = Icons.Default.ArrowBack ,
                            contentDescription = ""
                        )
                    }

                },
                actions = {
                    IconButton(
                        onClick = {
                            notesVm.saveNewNote(title , note){
                                Toast.makeText(context , "Guardo" , Toast.LENGTH_SHORT).show()
                                navController.popBackStack()
                            }
                        }
                    ){
                        Icon(
                            imageVector = Icons.Default.AddCircle ,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ){
        pad ->
        Column(
            modifier = Modifier
                .padding(pad)
                .fillMaxSize() ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = title ,
                onValueChange = { title = it },
                label = { Text(text = "Titulo") },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
            )

            OutlinedTextField(
                value = note ,
                onValueChange = { note = it },
                label = { Text(text = "Nota") },
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 10.dp)
            )

        }

    }

}