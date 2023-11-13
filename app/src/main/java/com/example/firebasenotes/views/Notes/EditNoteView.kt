package com.example.firebasenotes.views.Notes

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firebasenotes.viewModels.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNoteView(
    navController: NavController ,
    notesVM: NotesViewModel ,
    idDoc: String
){
    LaunchedEffect(Unit){
        notesVM.getNoteById(idDoc)
    }
    val state = notesVM.state

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text="Editar Nota")},
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
                            notesVM.deleteNote(idDoc){
                                navController.popBackStack()
                            }
                        }
                    ){
                        Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                    }
                    IconButton(
                        onClick = {
                            notesVM.updateNote(idDoc){
                                navController.popBackStack()
                            }
                        }
                    ){
                        Icon(
                            imageVector = Icons.Default.Edit ,
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
                value = state.title ,
                onValueChange = { notesVM.onValue(it , "title")},
                label = { Text(text = "Titulo") },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
            )

            OutlinedTextField(
                value = state.note ,
                onValueChange = { notesVM.onValue(it , "note") },
                label = { Text(text = "Nota") },
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 10.dp)
            )

        }

    }
}


