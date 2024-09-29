package com.example.shark.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AccountScreen(navController: NavController) {
    val user = User("Tulika Tripathi", "tripathitulika3@gmail.com")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            ProfileHeader(user)
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(accountOptions) { option ->
            AccountOptionItem(option) {
                when (option.title) {
                    "Edit Profile" -> {
                    }
                    "Favorite Orders" -> {
                    }
                    "Logout" -> {
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileHeader(user: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Profile",
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = user.name, style = MaterialTheme.typography.headlineMedium)
            Text(text = user.email, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun AccountOptionItem(option: AccountOption, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Icon(
            imageVector = option.icon,
            contentDescription = option.title,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = option.title)
    }
}

data class User(val name: String, val email: String)

data class AccountOption(val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)

val accountOptions = listOf(
    AccountOption("Edit Profile", Icons.Default.Edit),
    AccountOption("Favorite Orders", Icons.Default.Favorite),
    AccountOption("Logout", Icons.Default.ExitToApp)
)