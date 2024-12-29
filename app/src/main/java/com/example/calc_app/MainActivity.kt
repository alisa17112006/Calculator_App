package com.example.calc_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calc_app.ui.theme.Calc_AppTheme
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calc_AppTheme {
                CalculatorApp()
            }
        }
    }
}

@Composable
fun CalculatorApp() {
    var input by remember { mutableStateOf("") } // Строка для отображения ввода пользователя
    var result by remember { mutableStateOf("") } // Результат вычислений

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFF202124)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Экран ввода/результатов
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFF303134))
                    .padding(16.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = input,
                        fontSize = 32.sp,
                        color = Color.White,
                        maxLines = 7
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = result,
                        fontSize = 24.sp,
                        color = Color.Gray,
                        maxLines = Int.MAX_VALUE,
                        overflow = TextOverflow.Visible
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp) // Высота кнопки
                    .background(Color(0xFF8AB4F8), RoundedCornerShape(8.dp))
                    .clickable {
                        result = calculateResult(input) // Выполнение вычисления
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "=",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }

            // Кнопки калькулятора
            val buttons = listOf(

                listOf("sin", "cos", "tan", "cot"),
                listOf("7", "8", "9", "/"),
                listOf("4", "5", "6", "*"),
                listOf("1", "2", "3", "-"),
                listOf("C", "0", ".", "+")
            )

            buttons.forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    row.forEach { label ->
                        CalculatorButton(
                            label = label,
                            modifier = Modifier.weight(1f),
                            onClick = {
                                when (label) {
                                    "C" -> {
                                        input = ""
                                        result = ""
                                    }
                                    "=" -> {
                                        result = calculateResult(input)
                                    }
                                    else -> {
                                        input += label
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(
    label: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .aspectRatio(1f) // Кнопки квадратные
            .background(
                color = if (label in listOf("C", "=", "+", "-", "*", "/")) Color(0xFF8AB4F8) else Color(0xFF3C4043),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onClick() }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

// Функция для вычислений с использованием exp4j
fun calculateResult(expression: String): String {
    return try {
        // Проверка деления на 0
        if (expression.contains("/ 0")) {
            return "Ошибка"
        }

        val sanitizedExpression = expression
            .replace("sin", "sinr") // Временные метки для замены
            .replace("cos", "cosr")
            .replace("tan", "tanr")
            .replace("cot", "cotr")

        val expressionBuilder = ExpressionBuilder(sanitizedExpression)
            .function(object : net.objecthunter.exp4j.function.Function("sinr", 1) {
                override fun apply(vararg args: Double): Double {
                    return Math.sin(Math.toRadians(args[0]))
                }
            })
            .function(object : net.objecthunter.exp4j.function.Function("cosr", 1) {
                override fun apply(vararg args: Double): Double {
                    return Math.cos(Math.toRadians(args[0]))
                }
            })
            .function(object : net.objecthunter.exp4j.function.Function("tanr", 1) {
                override fun apply(vararg args: Double): Double {
                    return Math.tan(Math.toRadians(args[0]))
                }
            })
            .function(object : net.objecthunter.exp4j.function.Function("cotr", 1) {
                override fun apply(vararg args: Double): Double {
                    val tanValue = Math.tan(Math.toRadians(args[0]))
                    return if (tanValue == 0.0) Double.POSITIVE_INFINITY else 1 / tanValue
                }
            })
            .build()

        val result = expressionBuilder.evaluate()
        result.toString()
    } catch (e: ArithmeticException) {
        "Ошибка"
    } catch (e: Exception) {
        "Ошибка"
    }
}

