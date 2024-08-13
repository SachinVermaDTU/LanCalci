package com.example.calci

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.calci.ui.theme.CalciTheme
import com.example.calci.ui.theme.MediumGray
import com.example.calci.ui.theme.Orange

@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalciTheme {
                val viewModel: CalculatorViewModel = viewModel()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Calculator") },
                            actions = {
                                LanguageSelectionMenu(viewModel)
                            }
                        )
                    },
                    content = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.DarkGray)
                                .padding(16.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.BottomCenter),
                                verticalArrangement = Arrangement.spacedBy(buttonSpacing),
                            ) {
                                Text(
                                    text = getNumeralRepresentation( state.numbers1 ,state.numeralSystem) + (state.operation?.symbols ?: "") + getNumeralRepresentation( state.numbers2 ,state.numeralSystem),
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 32.dp),
                                    fontWeight = FontWeight.Light,
                                    fontSize = 80.sp,
                                    color = Color.White,
                                    maxLines = 2
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                                ) {
                                    CalculatorButton(
                                        symbol = "AC",
                                        color = LightGray,
                                        modifier = Modifier
                                            .aspectRatio(2f)
                                            .weight(2f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Clear)
                                    }
                                    CalculatorButton(
                                        symbol = "Del",
                                        color = LightGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Delete)
                                    }
                                    CalculatorButton(
                                        symbol = "/",
                                        color = Orange,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                                    }
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                                ) {
                                    CalculatorButton(
                                        symbol = getNumeralRepresentation( "7" ,state.numeralSystem),
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Numbers(7))
                                    }
                                    CalculatorButton(
                                        symbol = getNumeralRepresentation( "8" ,state.numeralSystem),
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Numbers(8))
                                    }
                                    CalculatorButton(
                                        symbol = getNumeralRepresentation( "9" ,state.numeralSystem),
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Numbers(9))
                                    }
                                    CalculatorButton(
                                        symbol = "x",
                                        color = Orange,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                                    }
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                                ) {
                                    CalculatorButton(
                                        symbol = getNumeralRepresentation( "4" ,state.numeralSystem),
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Numbers(4))
                                    }
                                    CalculatorButton(
                                        symbol = getNumeralRepresentation( "5" ,state.numeralSystem),
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Numbers(5))
                                    }
                                    CalculatorButton(
                                        symbol = getNumeralRepresentation( "6" ,state.numeralSystem),
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Numbers(6))
                                    }
                                    CalculatorButton(
                                        symbol = "-",
                                        color = Orange,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                                    }
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                                ) {
                                    CalculatorButton(
                                        symbol = getNumeralRepresentation( "1" ,state.numeralSystem),
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Numbers(1))
                                    }
                                    CalculatorButton(
                                        symbol = getNumeralRepresentation( "2" ,state.numeralSystem),
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Numbers(2))
                                    }
                                    CalculatorButton(
                                        symbol = getNumeralRepresentation( "3" ,state.numeralSystem),
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Numbers(3))
                                    }
                                    CalculatorButton(
                                        symbol = "+",
                                        color = Orange,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                                    }
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                                ) {
                                    CalculatorButton(
                                        symbol =getNumeralRepresentation( "0" ,state.numeralSystem),
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(2f)
                                            .weight(2f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Numbers(0))
                                    }
                                    CalculatorButton(
                                        symbol = ".",
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Decimal)
                                    }
                                    CalculatorButton(
                                        symbol = "=",
                                        color = Orange,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalculatorAction.Calculate)
                                    }
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun LanguageSelectionMenu(viewModel: CalculatorViewModel) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(Icons.Default.MoreVert, contentDescription = "Menu")
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem( {
            Text("English")
        },onClick = {
            viewModel.onAction(CalculatorAction.ChangeNumeralSystem(NumeralSystem.English))
            expanded = false
        })
        DropdownMenuItem( {
            Text("Gujarati")
        },onClick = {
            viewModel.onAction(CalculatorAction.ChangeNumeralSystem(NumeralSystem.Gujarati))
            expanded = false
        })
        DropdownMenuItem({
            Text("Kannada")
        },onClick = {
            viewModel.onAction(CalculatorAction.ChangeNumeralSystem(NumeralSystem.Kannada))
            expanded = false
        })
        DropdownMenuItem( {
            Text("Devanagari")
        },onClick = {
            viewModel.onAction(CalculatorAction.ChangeNumeralSystem(NumeralSystem.Devanagari))
            expanded = false
        })
        DropdownMenuItem( {
            Text("Malayalam")
        },onClick = {
            viewModel.onAction(CalculatorAction.ChangeNumeralSystem(NumeralSystem.Malayalam))
            expanded = false
        })
        DropdownMenuItem({
            Text("Telugu")
        },onClick = {
            viewModel.onAction(CalculatorAction.ChangeNumeralSystem(NumeralSystem.Telugu))
            expanded = false
        })
        DropdownMenuItem({
            Text("Urdu")
        },onClick = {
            viewModel.onAction(CalculatorAction.ChangeNumeralSystem(NumeralSystem.Urdu))
            expanded = false
        })
    }
}
