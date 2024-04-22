package com.bg.collectionsstore.ui.User

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bg.collectionsstore.data.DataModel
import com.bg.collectionsstore.data.User.User
import com.bg.collectionsstore.ui.common.SearchableDropdownMenu
import com.bg.collectionsstore.ui.common.UITextField
import com.bg.collectionsstore.ui.common.UiVerticalCheckBox
import com.bg.collectionsstore.ui.theme.Blue
import com.bg.collectionsstore.ui.theme.CollectionsStoreTheme
import com.bg.collectionsstore.ui.theme.PurpleGrey80
import com.bg.collectionsstore.utils.Utils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageUsersView(
    navController: NavController? = null,
    modifier: Modifier = Modifier,
    viewModel: ManageUsersViewModel = hiltViewModel()
) {
    CollectionsStoreTheme {
        Scaffold(
            topBar = {
                Surface(shadowElevation = 3.dp, color = Color.White) {
                    TopAppBar(
                        navigationIcon = {
                            IconButton(onClick = { navController?.navigateUp() }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        },
                        title = {
                            Text(
                                text = "Manage Users",
                                color = Color.Black,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        })
                }
            }
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(color = Color.Transparent)
            ) {
                val manageUsersState: ManageUsersState by viewModel.manageUsersState.collectAsState(
                    ManageUsersState()
                )
                var posModeState by remember { mutableStateOf(true) }
                var tableModeState by remember { mutableStateOf(false) }
                var usernameState by remember { mutableStateOf("") }
                var passwordState by remember { mutableStateOf("") }
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SearchableDropdownMenu(
                            items = manageUsersState.users.toMutableList(),
                            modifier = Modifier.padding(10.dp),
                            selectedItem = usernameState,
                        ) {
                            it as User
                            usernameState = it.userName ?: ""
                            passwordState = it.userPassword ?: ""
                        }

                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = usernameState,
                            label = "Username",
                            placeHolder = "Enter Username"
                        ) {
                            usernameState = it
                        }

                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = passwordState,
                            label = "Password",
                            placeHolder = "Enter Password",
                            keyboardType = KeyboardType.Password
                        ) {
                            passwordState = it
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            UiVerticalCheckBox(
                                modifier = Modifier.weight(.5f),
                                label = "POS Mode",
                                checked = posModeState
                            ) {
                                posModeState = it
                                tableModeState = !it
                            }

                            UiVerticalCheckBox(
                                modifier = Modifier.weight(.5f),
                                label = "Table Mode",
                                checked = tableModeState
                            ) {
                                tableModeState = it
                                posModeState = !it
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(10.dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            ElevatedButton(
                                modifier = Modifier
                                    .weight(.33f)
                                    .padding(3.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Blue),
                                onClick = { viewModel.saveUser() }
                            ) {
                                Text("Save")
                            }

                            ElevatedButton(
                                modifier = Modifier
                                    .weight(.33f)
                                    .padding(3.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Blue),
                                onClick = { viewModel.deleteSelectedUser() }
                            ) {
                                Text("Delete")
                            }

                            ElevatedButton(
                                modifier = Modifier
                                    .weight(.33f)
                                    .padding(3.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Blue),
                                onClick = { navController?.navigateUp() }
                            ) {
                                Text("Close")
                            }

                        }

                    }
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