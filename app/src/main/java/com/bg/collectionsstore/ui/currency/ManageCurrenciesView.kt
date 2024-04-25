package com.bg.collectionsstore.ui.currency

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bg.collectionsstore.data.Currency.Currency
import com.bg.collectionsstore.ui.common.LoadingIndicator
import com.bg.collectionsstore.ui.common.SearchableDropdownMenu
import com.bg.collectionsstore.ui.common.UITextField
import com.bg.collectionsstore.ui.theme.Blue
import com.bg.collectionsstore.ui.theme.CollectionsStoreTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageCurrenciesView(
    navController: NavController? = null,
    modifier: Modifier = Modifier,
    viewModel: ManageCurrenciesViewModel = hiltViewModel()
) {
    val manageFamiliesState: ManageCurrenciesState by viewModel.manageCurrenciesState.collectAsState(
        ManageCurrenciesState()
    )
    val curName1FocusRequester = remember { FocusRequester() }
    val curCode2FocusRequester = remember { FocusRequester() }
    val curName2FocusRequester = remember { FocusRequester() }
    val rateFocusRequester = remember { FocusRequester() }
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
                                text = "Manage Currencies",
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
                var curCode1State by remember { mutableStateOf("") }
                var curName1State by remember { mutableStateOf("") }
                var curCode2State by remember { mutableStateOf("") }
                var curName2State by remember { mutableStateOf("") }
                var rateState by remember { mutableDoubleStateOf(0.0) }
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
                            items = manageFamiliesState.currencies.toMutableList(),
                            modifier = Modifier.padding(10.dp),
                            label =
                            curName1State.ifEmpty { "Select Currency" },
                        ) { currency ->
                            currency as Currency
                            manageFamiliesState.selectedCurrency = currency
                            curCode1State = currency.currencyCode1 ?: ""
                            curName1State = currency.currencyName1 ?: ""
                            curCode2State = currency.currencyCode2 ?: ""
                            curName2State = currency.currencyName2 ?: ""
                            rateState = currency.currencyRate ?: 0.0
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(10.dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            UITextField(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(.3f),
                                defaultValue = curCode1State,
                                label = "Cur1 Code",
                                placeHolder = "Cur1 Code",
                                onAction = { curName1FocusRequester.requestFocus() }
                            ) { curCode1 ->
                                curCode1State = curCode1
                                manageFamiliesState.selectedCurrency.currencyCode1 = curCode1
                            }

                            UITextField(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(.6f),
                                defaultValue = curCode1State,
                                label = "Cur1 Name",
                                placeHolder = "Cur1 Name",
                                focusRequester = curName1FocusRequester,
                                onAction = { curCode2FocusRequester.requestFocus() }
                            ) { curName1 ->
                                curName1State = curName1
                                manageFamiliesState.selectedCurrency.currencyName1 = curName1
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(10.dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            UITextField(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(.3f),
                                defaultValue = curCode2State,
                                label = "Cur2 Code",
                                placeHolder = "Cur2 Code",
                                focusRequester = curCode2FocusRequester,
                                onAction = { curName2FocusRequester.requestFocus() }
                            ) { curCode2 ->
                                curCode2State = curCode2
                                manageFamiliesState.selectedCurrency.currencyCode2 = curCode2
                            }

                            UITextField(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(.6f),
                                defaultValue = curCode2State,
                                label = "Cur2 Name",
                                placeHolder = "Cur2 Name",
                                focusRequester = curName2FocusRequester,
                                onAction = { rateFocusRequester.requestFocus() }
                            ) { curName2 ->
                                curName2State = curName2
                                manageFamiliesState.selectedCurrency.currencyName2 = curName2
                            }
                        }

                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = rateState.toString(),
                            keyboardType = KeyboardType.Decimal,
                            label = "Rate",
                            placeHolder = "Enter Rate",
                            focusRequester = rateFocusRequester,
                            imeAction = ImeAction.Done
                        ) { rateStr ->
                            val rate = rateStr.toDouble()
                            rateState = rate
                            manageFamiliesState.selectedCurrency.currencyRate = rate
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
                                onClick = { viewModel.saveCurrency() }
                            ) {
                                Text("Save")
                            }

                            ElevatedButton(
                                modifier = Modifier
                                    .weight(.33f)
                                    .padding(3.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Blue),
                                onClick = { viewModel.deleteSelectedCurrency() }
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
            show = manageFamiliesState.isLoading
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ManageCurrenciesViewPreview() {
    CollectionsStoreTheme {
        ManageCurrenciesView()
    }
}