package com.bg.collectionsstore.ui.pos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bg.collectionsstore.ui.common.SearchableDropdownMenu
import com.bg.collectionsstore.ui.theme.Blue
import com.bg.collectionsstore.utils.Utils

@Composable
fun InvoiceFooterDetails(
    navController: NavController? = null,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.wrapContentWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(.6f)
                .wrapContentHeight()
                .padding(5.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.wrapContentWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {
                Text(text = "Tax:")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "0")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "USD")
            }

            Row(
                modifier = Modifier.wrapContentWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {
                Text(text = "Tax2:")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "0")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "USD")
            }

            Row(
                modifier = Modifier.wrapContentWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {
                Text(text = "Total:")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "150.00")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "USD")
            }

            Row(
                modifier = Modifier.wrapContentWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {
                Text(text = "Total:")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "15,000.00")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "USD")
            }

            ElevatedButton(
                modifier = Modifier
                    .width(150.dp)
                    .height(70.dp)
                    .padding(10.dp, 15.dp, 10.dp, 5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Blue),
                onClick = { }
            ) {
                Text("Pay")
            }

            ElevatedButton(
                modifier = Modifier
                    .width(150.dp)
                    .height(70.dp)
                    .padding(10.dp, 5.dp, 10.dp, 5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Blue),
                onClick = { navController?.navigateUp() }
            ) {
                Text("Back")
            }
        }
        Column(
            modifier = Modifier
                .weight(.4f)
                .wrapContentHeight()
                .padding(5.dp),
            horizontalAlignment = Alignment.End
        ) {
            Row(
                modifier = Modifier.wrapContentWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {
                Text(text = "Tax2:")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "0")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "USD")
            }

            Row(
                modifier = Modifier.wrapContentWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {
                Text(text = "Total Tax:")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "0")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "USD")
            }

            Row(
                modifier = Modifier.wrapContentWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {
                Text(text = "Table Number:")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "3")
            }

            Row(
                modifier = Modifier.wrapContentWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {
                Text(text = "Client:")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Cash")
            }

            SearchableDropdownMenu(
                items = Utils.listOfItems.toMutableList(),
                modifier = Modifier
                    .width(300.dp)
                    .height(70.dp)
                    .padding(10.dp, 15.dp, 10.dp, 5.dp),
                label = "Search Items",
            ) { item ->
            }

            SearchableDropdownMenu(
                items = Utils.categories.toMutableList(),
                modifier = Modifier
                    .width(300.dp)
                    .height(70.dp)
                    .padding(10.dp, 15.dp, 10.dp, 5.dp),
                label = "Customer Search",
            ) { item ->
            }
        }
    }
}
