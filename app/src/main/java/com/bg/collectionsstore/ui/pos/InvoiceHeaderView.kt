package com.bg.collectionsstore.ui.pos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bg.collectionsstore.ui.common.SearchableDropdownMenu
import com.bg.collectionsstore.ui.theme.Blue
import com.bg.collectionsstore.utils.Utils

@Composable
fun InvoiceHeaderDetails(
    navController: NavController? = null,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        horizontalArrangement = Arrangement.Absolute.Right
    ) {
        ElevatedButton(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(3.dp, 5.dp, 5.dp, 5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Blue),
            onClick = { }
        ) {
            Text("Edit")
        }

        ElevatedButton(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(3.dp, 5.dp, 5.dp, 5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Blue),
            onClick = { }
        ) {
            Text("Add Customer")
        }

        ElevatedButton(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(3.dp, 5.dp, 5.dp, 5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Blue),
            onClick = { }
        ) {
            Text("Pay")
        }

        ElevatedButton(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(3.dp, 5.dp, 5.dp, 5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Blue),
            onClick = { navController?.navigateUp() }
        ) {
            Text("Back")
        }
    }
}
