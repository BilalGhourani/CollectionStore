package com.bg.collectionsstore.ui.user

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
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bg.collectionsstore.data.Company.Company
import com.bg.collectionsstore.data.User.User
import com.bg.collectionsstore.ui.common.LoadingIndicator
import com.bg.collectionsstore.ui.common.SearchableDropdownMenu
import com.bg.collectionsstore.ui.common.UITextField
import com.bg.collectionsstore.ui.common.UiVerticalCheckBox
import com.bg.collectionsstore.ui.theme.Blue
import com.bg.collectionsstore.ui.theme.CollectionsStoreTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ManageUsersView(
    navController: NavController? = null,
    modifier: Modifier = Modifier,
    viewModel: ManageUsersViewModel = hiltViewModel()
) {
    val manageUsersState: ManageUsersState by viewModel.manageUsersState.collectAsState(
        ManageUsersState()
    )
    val keyboardController = LocalSoftwareKeyboardController.current
    val usernameFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }
    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(manageUsersState.warning) {
        if (!manageUsersState.warning.isNullOrEmpty()) {
            CoroutineScope(Dispatchers.Main).launch {
                snackbarHostState.showSnackbar(
                    message = manageUsersState.warning!!,
                    duration = SnackbarDuration.Short,
                )
            }
        }
    }
    CollectionsStoreTheme {
        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
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
        ) { it ->
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(color = Color.Transparent)
            ) {
                var nameState by remember { mutableStateOf("") }
                var usernameState by remember { mutableStateOf("") }
                var passwordState by remember { mutableStateOf("") }
                var companyIdState by remember { mutableStateOf("") }
                var posModeState by remember { mutableStateOf(true) }
                var tableModeState by remember { mutableStateOf(false) }
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SearchableDropdownMenu(
                            items = manageUsersState.users.toMutableList(),
                            modifier = Modifier.padding(10.dp),
                            label = usernameState.ifEmpty { "Select User" },
                        ) { selectedUser ->
                            selectedUser as User
                            manageUsersState.selectedUser = selectedUser
                            nameState = selectedUser.userName ?: ""
                            usernameState = selectedUser.userUsername ?: ""
                            passwordState = selectedUser.userPassword ?: ""
                            companyIdState = selectedUser.userCompanyId ?: ""
                            posModeState = selectedUser.userPosMode ?: true
                            tableModeState = selectedUser.userTableMode ?: false
                        }

                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = nameState,
                            label = "Name",
                            placeHolder = "Enter Name",
                            onAction = { usernameFocusRequester.requestFocus() }
                        ) {
                            nameState = it
                            manageUsersState.selectedUser.userName = it
                        }

                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = usernameState,
                            label = "Username",
                            placeHolder = "Enter Username",
                            focusRequester = usernameFocusRequester,
                            onAction = { passwordFocusRequester.requestFocus() }
                        ) {
                            usernameState = it
                            manageUsersState.selectedUser.userUsername = it
                        }

                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = passwordState,
                            label = "Password",
                            placeHolder = "Enter Password",
                            focusRequester = passwordFocusRequester,
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done,
                            onAction = { keyboardController?.hide() }
                        ) {
                            passwordState = it
                            manageUsersState.selectedUser.userPassword = it
                        }

                        SearchableDropdownMenu(
                            items = manageUsersState.companies.toMutableList(),
                            modifier = Modifier.padding(10.dp),
                            label = "Select Company",
                            selectedId = companyIdState
                        ) { company ->
                            company as Company
                            companyIdState = company.companyId
                            manageUsersState.selectedUser.userCompanyId =
                                company.companyId
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
                                manageUsersState.selectedUser.userPosMode = posModeState
                                manageUsersState.selectedUser.userTableMode = tableModeState
                            }

                            UiVerticalCheckBox(
                                modifier = Modifier.weight(.5f),
                                label = "Table Mode",
                                checked = tableModeState
                            ) {
                                tableModeState = it
                                posModeState = !it
                                manageUsersState.selectedUser.userPosMode = posModeState
                                manageUsersState.selectedUser.userTableMode = tableModeState
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
                                onClick = { viewModel.saveUser(manageUsersState.selectedUser) }
                            ) {
                                Text("Save")
                            }

                            ElevatedButton(
                                modifier = Modifier
                                    .weight(.33f)
                                    .padding(3.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Blue),
                                onClick = { viewModel.deleteSelectedUser(manageUsersState.selectedUser) }
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
        LoadingIndicator(
            show = manageUsersState.isLoading
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ManageUsersViewPreview() {
    CollectionsStoreTheme {
        ManageUsersView()
    }
}