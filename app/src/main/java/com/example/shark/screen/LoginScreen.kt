package com.example.shark.screen
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shark.R
import com.example.shark.Screen


@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.login_background),
                contentScale = ContentScale.Crop
            )

    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()

                .padding(16.dp)
                .align(Alignment.Center),
            border = BorderStroke(2.dp, Color.White),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        )
         {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth(),
                    isError = showError && !isValidEmail(username),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                if(showError && !isValidEmail(username)){
                    Text(text = "Invalid email format",
                        color = Color.Red,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(16.dp))
                }

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(),
                    isError = showError && !isValidPassword(password),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                if (showError && !isValidPassword(password)) {
                    Text(
                        text = "Password must be at least 5 characters",
                        color = Color.Red,style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        showError = true
                        if (isValidEmail(username) && isValidPassword(password)) {
                            navController.navigate(Screen.Dashboard.route)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                            containerColor = Color.DarkGray        //The colorResource function allows you to access colors defined in your XML resources


                )
                ) {
                    Text("Login",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.White,
                            fontFamily = FontFamily.Serif
                        )
                        )

                }
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(onClick = { /* Handle forgot password */ }) {
                        Text("Forgot Password?",
                           color = Color.Black,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = FontFamily.Serif
                            ),
                            modifier = Modifier



                            )
                    }
                    TextButton(onClick = { navController.navigate(Screen.Registration.route) }) {
                        Text("Create Account",
                          color = Color.Black,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = FontFamily.Serif,
                            ),
                            modifier = Modifier

                        )
                    }
                }
            }
         }
                }
            }
fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
fun isValidPassword(password: String): Boolean {
    return password.length >= 5
}
