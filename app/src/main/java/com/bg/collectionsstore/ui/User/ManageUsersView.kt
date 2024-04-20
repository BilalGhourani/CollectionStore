package com.bg.collectionsstore.ui.User

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bg.collectionsstore.data.Item.Item
import com.bg.collectionsstore.ui.theme.CollectionsStoreTheme
import com.bg.collectionsstore.ui.theme.Red
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.bg.collectionsstore.ui.common.UITextField

@Composable
fun ManageUsersView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(120.dp)
            .height(120.dp)
            .padding(2.dp)
            .background(color = Color.Transparent)
    ) {
        var usernameState by remember { mutableStateOf("") }
        var passwordState by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Red, shape = RoundedCornerShape(15.dp)),
            contentAlignment = Alignment.Center
        ) {
            Column( // Use a Box to achieve content alignment
                modifier = Modifier
                    .wrapContentSize(),
                horizontalAlignment = Alignment.CenterHorizontally // Center content within the Box
            ) {
                UITextField(
                    defaultValue = usernameState,
                    label = "Username",
                    placeHolder = "Enter Username"
                ){
                    usernameState=it
                }

                UITextField(
                    defaultValue = passwordState,
                    label = "Password",
                    placeHolder = "Enter Password"
                ){
                    passwordState=it
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ManageUsersViewPreview() {
    CollectionsStoreTheme {
        ManageUsersView()
    }
}