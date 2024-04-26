package com.bg.collectionsstore.ui.pos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bg.collectionsstore.model.InvoiceItemModel
import com.bg.collectionsstore.ui.common.SearchableDropdownMenu
import com.bg.collectionsstore.ui.theme.Blue
import com.bg.collectionsstore.utils.Utils

@Composable
fun InvoiceBodyDetails(
    navController: NavController? = null,
    modifier: Modifier = Modifier
) {
    val invoiceItems = listOf(
        InvoiceItemModel("Item", "Count", "Price", "Dis%", "Tax", "Tax1", "Tax2", "Amount"),
        InvoiceItemModel("Chicken", "1", "150.00", "0.0", "0.0", "0.0", "0.0", "150.00"),
        InvoiceItemModel("Salad", "1", "150.00", "0.0", "0.0", "0.0", "0.0", "150.00"),
        InvoiceItemModel("Champo", "1", "150.00", "0.0", "0.0", "0.0", "0.0", "150.00"),
        InvoiceItemModel("Prince", "1", "150.00", "0.0", "0.0", "0.0", "0.0", "150.00"),
        InvoiceItemModel("Juice", "1", "150.00", "0.0", "0.0", "0.0", "0.0", "150.00"),
        InvoiceItemModel("Master chips", "1", "150.00", "0.0", "0.0", "0.0", "0.0", "150.00"),
        InvoiceItemModel("Mozarilla", "1", "150.00", "0.0", "0.0", "0.0", "0.0", "150.00"),
        InvoiceItemModel("Meat", "1", "150.00", "0.0", "0.0", "0.0", "0.0", "150.00"),
        InvoiceItemModel("Kabab", "1", "150.00", "0.0", "0.0", "0.0", "0.0", "150.00"),
    )

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues( 4.dp)
    ) {
        invoiceItems.forEach { invoiceItemModel ->
            item {
                InvoiceItem(invoiceItemModel)
            }
        }
    }
}
