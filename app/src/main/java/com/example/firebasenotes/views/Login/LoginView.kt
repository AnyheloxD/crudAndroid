package com.example.firebasenotes.views.Login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firebasenotes.components.Alert
import com.example.firebasenotes.viewModels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(navController: NavController , loginVM: LoginViewModel){


    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .padding(vertical = 40.dp)
    ){
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }


        OutlinedTextField(
            value = email ,
            onValueChange = {email = it} ,
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 30.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password ,
            onValueChange = {password = it} ,
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 30.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
                         loginVM.login(email,password){
                             navController.navigate("Home")
                         }
        } , modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp)){
            Text("Ingresar")
        }

        if (loginVM.showAlert){
            Alert(
                title = "Alerta" ,
                message = "Usuario y/o Contraseña Incorrecta" ,
                confirmText = "Aceptar",
                onConfirmClick ={ loginVM.closeAlert() }){

            }


        }


    }


}