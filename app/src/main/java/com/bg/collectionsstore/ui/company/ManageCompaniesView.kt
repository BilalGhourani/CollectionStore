package com.bg.collectionsstore.ui.company

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
import com.bg.collectionsstore.data.Company.Company
import com.bg.collectionsstore.data.Currency.Currency
import com.bg.collectionsstore.ui.common.LoadingIndicator
import com.bg.collectionsstore.ui.common.SearchableDropdownMenu
import com.bg.collectionsstore.ui.common.UITextField
import com.bg.collectionsstore.ui.theme.Blue
import com.bg.collectionsstore.ui.theme.CollectionsStoreTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageCompaniesView(
    navController: NavController? = null,
    modifier: Modifier = Modifier,
    viewModel: ManageCompaniesViewModel = hiltViewModel()
) {
    val manageCompaniesState: ManageCompaniesState by viewModel.manageCompaniesState.collectAsState(
        ManageCompaniesState()
    )
    val phoneFocusRequester = remember { FocusRequester() }
    val addressFocusRequester = remember { FocusRequester() }
    val taxRegNoFocusRequester = remember { FocusRequester() }
    val taxFocusRequester = remember { FocusRequester() }
    val emailFocusRequester = remember { FocusRequester() }
    val webFocusRequester = remember { FocusRequester() }
    val logoFocusRequester = remember { FocusRequester() }
    val tax1FocusRequester = remember { FocusRequester() }
    val tax1RegNoFocusRequester = remember { FocusRequester() }
    val tax2FocusRequester = remember { FocusRequester() }
    val tax2RegNoFocusRequester = remember { FocusRequester() }
    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(manageCompaniesState.warning) {
        if (!manageCompaniesState.warning.isNullOrEmpty()) {
            CoroutineScope(Dispatchers.Main).launch {
                snackbarHostState.showSnackbar(
                    message = manageCompaniesState.warning!!,
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
                                text = "Manage Companies",
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
                var phoneState by remember { mutableStateOf("") }
                var addressState by remember { mutableStateOf("") }
                var taxRegnoState by remember { mutableStateOf("") }
                var taxState by remember { mutableStateOf(0.0) }
                var curCodeTaxState by remember { mutableStateOf("") }
                var emailState by remember { mutableStateOf("") }
                var webState by remember { mutableStateOf("") }
                var logoState by remember { mutableStateOf("") }
                var ssState by remember { mutableStateOf(false) }
                var tax1State by remember { mutableStateOf(0.0) }
                var tax1RegnoState by remember { mutableStateOf("") }
                var tax2State by remember { mutableStateOf(0.0) }
                var tax2RegnoState by remember { mutableStateOf("") }
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
                            items = manageCompaniesState.companies.toMutableList(),
                            modifier = Modifier.padding(10.dp),
                            label = nameState.ifEmpty { "Select Company" },
                        ) { company ->
                            company as Company
                            manageCompaniesState.selectedCompany = company
                            nameState = company.companyName ?: ""
                            phoneState = company.companyPhone ?: ""
                            addressState = company.companyAddress ?: ""
                            taxRegnoState = company.companyTaxRegno ?: ""
                            taxState = company.companyTax ?: 0.0
                            curCodeTaxState = company.companyCurCodeTax ?: ""
                            emailState = company.companyEmail ?: ""
                            webState = company.companyWeb ?: ""
                            logoState = company.companyLogo ?: ""
                            ssState = company.companySS
                            tax1RegnoState = company.companyTax1Regno ?: ""
                            tax1State = company.companyTax1 ?: 0.0
                            tax2RegnoState = company.companyTax2Regno ?: ""
                            tax2State = company.companyTax2 ?: 0.0
                        }

                        //name
                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = nameState,
                            label = "Name",
                            placeHolder = "Enter Name",
                            onAction = { phoneFocusRequester.requestFocus() }
                        ) {
                            nameState = it
                            manageCompaniesState.selectedCompany.companyName = it
                        }

                        //phone
                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = nameState,
                            label = "Phone",
                            placeHolder = "Enter Phone",
                            onAction = { addressFocusRequester.requestFocus() }
                        ) {
                            phoneState = it
                            manageCompaniesState.selectedCompany.companyPhone = it
                        }

                        //address
                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = nameState,
                            label = "Address",
                            maxLines = 3,
                            placeHolder = "Enter address",
                            onAction = { taxRegNoFocusRequester.requestFocus() }
                        ) {
                            addressState = it
                            manageCompaniesState.selectedCompany.companyAddress = it
                        }

                        //tax reg no
                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = nameState,
                            label = "Tax Reg. No",
                            placeHolder = "Enter Tax Reg. No",
                            onAction = { taxFocusRequester.requestFocus() }
                        ) {
                            taxRegnoState = it
                            manageCompaniesState.selectedCompany.companyTaxRegno = it
                        }

                        //tax
                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = nameState,
                            label = "Tax",
                            keyboardType = KeyboardType.Decimal,
                            placeHolder = "Enter Tax",
                            onAction = { tax1RegNoFocusRequester.requestFocus() }
                        ) {
                            val tax = it.toDouble()
                            taxState = tax
                            manageCompaniesState.selectedCompany.companyTax = tax
                        }

                        SearchableDropdownMenu(
                            items = manageCompaniesState.currencies.toMutableList(),
                            modifier = Modifier.padding(10.dp),
                            label = "Select Tax Currency",
                            selectedId = curCodeTaxState
                        ) { currency ->
                            currency as Currency
                            curCodeTaxState = currency.currencyId
                            manageCompaniesState.selectedCompany.companyCurCodeTax =
                                currency.currencyId
                        }

                        //tax1 reg no
                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = nameState,
                            label = "Tax1 Reg. No",
                            placeHolder = "Enter Tax1 Reg. No",
                            onAction = { tax1FocusRequester.requestFocus() }
                        ) {
                            tax1RegnoState = it
                            manageCompaniesState.selectedCompany.companyTax1Regno = it
                        }

                        //tax1
                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = nameState,
                            label = "Tax1",
                            keyboardType = KeyboardType.Decimal,
                            placeHolder = "Enter Tax1",
                            onAction = { tax2RegNoFocusRequester.requestFocus() }
                        ) {
                            val tax1 = it.toDouble()
                            tax1State = tax1
                            manageCompaniesState.selectedCompany.companyTax1 = tax1
                        }

                        //tax2 reg no
                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = nameState,
                            label = "Tax2 Reg. No",
                            placeHolder = "Enter Tax2 Reg. No",
                            onAction = { tax2FocusRequester.requestFocus() }
                        ) {
                            tax2RegnoState = it
                            manageCompaniesState.selectedCompany.companyTax2Regno = it
                        }

                        //tax2
                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = nameState,
                            label = "Tax2",
                            keyboardType = KeyboardType.Decimal,
                            placeHolder = "Enter Tax2",
                            onAction = { emailFocusRequester.requestFocus() }
                        ) {
                            val tax2 = it.toDouble()
                            tax2State = tax2
                            manageCompaniesState.selectedCompany.companyTax2 = tax2
                        }

                        //email
                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = nameState,
                            label = "Email Address",
                            placeHolder = "Enter Email Address",
                            onAction = { webFocusRequester.requestFocus() }
                        ) {
                            emailState = it
                            manageCompaniesState.selectedCompany.companyEmail = it
                        }

                        //web
                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = nameState,
                            label = "Website",
                            placeHolder = "Enter Website",
                            onAction = { logoFocusRequester.requestFocus() }
                        ) {
                            webState = it
                            manageCompaniesState.selectedCompany.companyWeb = it
                        }

                        //web
                        UITextField(
                            modifier = Modifier.padding(10.dp),
                            defaultValue = nameState,
                            label = "Logo",
                            placeHolder = "Enter Logo",
                            imeAction = ImeAction.Done
                        ) {
                            logoState = it
                            manageCompaniesState.selectedCompany.companyLogo = it
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
                                onClick = { viewModel.saveCompany() }
                            ) {
                                Text("Save")
                            }

                            ElevatedButton(
                                modifier = Modifier
                                    .weight(.33f)
                                    .padding(3.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Blue),
                                onClick = { viewModel.deleteSelectedCompany() }
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
            show = manageCompaniesState.isLoading
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ManageCompaniesViewPreview() {
    CollectionsStoreTheme {
        ManageCompaniesView()
    }
}