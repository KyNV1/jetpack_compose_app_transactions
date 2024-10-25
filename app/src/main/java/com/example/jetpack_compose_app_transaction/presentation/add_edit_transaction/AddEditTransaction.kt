package com.example.jetpack_compose_app_transaction.presentation.add_edit_transaction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.jetpack_compose_app_transaction.presentation.common.transactionTypes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddEditTransaction(
    viewModel: AddEditTransactionViewModel = hiltViewModel(),
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                navHostController.navigateUp()
            }) {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
            }
            Text("Transaction")
            Spacer(modifier = Modifier.width(36.dp))
        }
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFD16C97))
                    .padding(24.dp, 32.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = viewModel.title.value.text,
                    onValueChange = {
                        viewModel.onEvent(AddEditTransactionEvent.EnteredTitle(it))
                    },
                    modifier = Modifier.width(280.dp),
                    placeholder = {
                        Text(text = viewModel.title.value.hint, modifier = Modifier.alpha(0.5f))
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedLabelColor = Color.Transparent,
                        backgroundColor = Color.White
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = viewModel.amount.value.text,
                    onValueChange = {
                        viewModel.onEvent(AddEditTransactionEvent.EnteredAmount(it))
                    },
                    modifier = Modifier.width(280.dp),
                    placeholder = {
                        Text(text = viewModel.amount.value.hint, modifier = Modifier.alpha(0.5f))
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedLabelColor = Color.Transparent,
                        backgroundColor = Color.White
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Decimal
                    ),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))
                ExposedDropdownMenuBox(
                    expanded = viewModel.transactionType.value.isExpensed,
                    onExpandedChange = {
                        viewModel.onEvent(AddEditTransactionEvent.OnExpandedChange)
                    },
                    modifier = Modifier.width(280.dp)
                ) {
                    TextField(
                        value = viewModel.transactionType.value.selectedOption,
                        onValueChange = { },
                        readOnly = true,
                        placeholder = {
                            Text(
                                text = viewModel.transactionType.value.hint,
                                modifier = Modifier.alpha(0.7f)
                            )
                        },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = viewModel.transactionType.value.isExpensed
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            cursorColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedLabelColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(16.dp),
                    )
                    // Nội dung của menu thả xuống
                    ExposedDropdownMenu(
                        expanded = viewModel.transactionType.value.isExpensed,
                        onDismissRequest = {
                            viewModel.onEvent(AddEditTransactionEvent.OnDismissRequest)
                        }
                    ) {
                        transactionTypes.forEach { option ->
                            DropdownMenuItem(onClick = {
                                viewModel.onEvent(
                                    AddEditTransactionEvent.ChangeSelectedOption(
                                        option
                                    )
                                )
                                viewModel.onEvent(AddEditTransactionEvent.OnDismissRequest)
                            }) {
                                Text(text = option)
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = viewModel.tags.value.text, onValueChange = {
                        viewModel.onEvent(AddEditTransactionEvent.EnterTags(it))
                    },
                    placeholder = {
                        Text(text = viewModel.tags.value.hint, modifier = Modifier.alpha(0.5f))
                    },
                    modifier = Modifier.width(280.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedLabelColor = Color.Transparent,
                        backgroundColor = Color.White
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = viewModel.note.value.text,
                    onValueChange = {
                        viewModel.onEvent(AddEditTransactionEvent.EnterNote(it))
                    },
                    modifier = Modifier.width(280.dp),
                    placeholder = {
                        Text(text = viewModel.note.value.hint, modifier = Modifier.alpha(0.5f))
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedLabelColor = Color.Transparent,
                        backgroundColor = Color.White
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        viewModel.onEvent(
                            AddEditTransactionEvent.SaveEditTransaction(
                                context = context,
                                navHostController = navHostController
                            )
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        backgroundColor = Color(0xFF243D25)
                    )
                ) {
                    Text(text = "SAVE")
                }
            }
        }
    }
}
