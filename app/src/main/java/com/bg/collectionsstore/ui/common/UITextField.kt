package com.bg.collectionsstore.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun UITextField(
    modifier: Modifier = Modifier,
    defaultValue: String = "",
    label: String? = null,
    placeHolder: String? = null,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    autoCorrect: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    maxLines: Int = 1,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {

        OutlinedTextField(
            value = defaultValue,
            onValueChange = {
                onValueChange(it)
            },
            label = { label?.let { Text(text = label) }.run { null } },
            placeholder = { placeHolder?.let { Text(text = placeHolder) }.run { null } },
            modifier = Modifier.fillMaxSize(),
            keyboardOptions = KeyboardOptions(
                capitalization = capitalization,
                autoCorrect = autoCorrect,
                keyboardType = keyboardType,
            ),
            maxLines = maxLines,
            singleLine = maxLines == 1,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
        )
    }
}