package com.bg.collectionsstore.ui.pos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bg.collectionsstore.model.InvoiceItemModel

@Composable
fun InvoiceItem(item: InvoiceItemModel) {
    Row(
        modifier = Modifier.padding(1.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val height = 50.dp
        val modifier = Modifier
            .height(height)
            .weight(0.125f)/*.background(color = Color.Red)*/
        Text(text = item.name, modifier = modifier, textAlign = TextAlign.Center)
        lineDivider()
        Text(text = item.count, modifier = modifier, textAlign = TextAlign.Center)
        lineDivider()
        Text(text = item.price, modifier = modifier, textAlign = TextAlign.Center)
        Text(text = item.discount, modifier = modifier, textAlign = TextAlign.Center)
        Text(text = item.tax, modifier = modifier, textAlign = TextAlign.Center)
        Text(text = item.tax1, modifier = modifier, textAlign = TextAlign.Center)
        Text(text = item.tax2, modifier = modifier, textAlign = TextAlign.Center)
        Text(text = item.amount, modifier = modifier, textAlign = TextAlign.Center)
    }
}

@Composable
fun lineDivider(
    thickness: Dp = 1.dp,
    color: Color = Color.Black
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(thickness)
            .background(color)
    )
}