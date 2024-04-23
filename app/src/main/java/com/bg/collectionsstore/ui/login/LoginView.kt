package com.bg.collectionsstore.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bg.collectionsstore.ui.common.LoadingIndicator
import com.bg.collectionsstore.ui.common.UITextField
import com.bg.collectionsstore.ui.theme.Blue
import com.bg.collectionsstore.ui.theme.CollectionsStoreTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun LoginView(
    navController: NavController? = null,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val loginState: LoginState by viewModel.usersState.collectAsState(LoginState())
    val keyboardController = LocalSoftwareKeyboardController.current
    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(loginState.warning, loginState.isLoggedIn) {
        if (!loginState.warning.isNullOrEmpty()) {
            CoroutineScope(Dispatchers.Main).launch {
                snackbarHostState.showSnackbar(
                    message = loginState.warning!!,
                    duration = SnackbarDuration.Short,
                )
            }
        }
        if (loginState.isLoggedIn) {
            navController?.navigate("HomeView")
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
                        /*navigationIcon = {
                            IconButton(onClick = { navController?.navigateUp() }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        },*/
                        title = {
                            Text(
                                text = "Login",
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
                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = usernameState,
                            label = "Username",
                            placeHolder = "Username"
                        ) {
                            usernameState = it
                        }

                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = passwordState,
                            label = "Password",
                            placeHolder = "Password",
                            keyboardType = KeyboardType.Password
                        ) {
                            passwordState = it
                        }

                        ElevatedButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Blue),
                            onClick = {
                                keyboardController?.hide()
                                viewModel.login(usernameState, passwordState)
                            }
                        ) {
                            Text("Log In")
                        }
                    }
                }
            }
            LoadingIndicator(
                show = loginState.isLoading
            )
        }
    }
}