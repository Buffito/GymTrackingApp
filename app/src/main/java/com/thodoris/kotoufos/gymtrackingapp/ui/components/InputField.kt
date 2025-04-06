package com.thodoris.kotoufos.gymtrackingapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp

@Composable
fun InputField(
    label: String,
    value: String,
    keyboardType: KeyboardType = KeyboardType.Number,
    maxLines: Int = 1,
    height: Dp = Dp.Unspecified,
    onValueChange: (String) -> Unit
) {
    val filteredValue = if (keyboardType == KeyboardType.Number) {
        value.filter { it.isDigit() || it == '.' || it == ',' }
            .let {
                if (it.count { char -> char == '.' || char == ',' } > 1) it.dropLast(1) else it
            }
    } else value

    OutlinedTextField(
        value = filteredValue,
        onValueChange = { newValue ->
            val sanitized = if (keyboardType == KeyboardType.Number) {
                newValue.filter { it.isDigit() || it == '.' || it == ',' }
                    .let {
                        if (it.count { char -> char == '.' || char == ',' } > 1) it.dropLast(1) else it
                    }
            } else newValue
            onValueChange(sanitized)
        },
        modifier = Modifier
            .fillMaxWidth()
            .then(if (height != Dp.Unspecified) Modifier.height(height) else Modifier),
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        maxLines = maxLines
    )
}
