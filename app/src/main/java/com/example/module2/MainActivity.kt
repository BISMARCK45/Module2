package com.example.module2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module2.ui.theme.Module2Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2Theme {
                WaterTracker()
            }

        }
    }
}

data class Contact(
    val firstName: String,
    val lastName: String,
    val phone: String,
    val email: String,
    val city: String,
)

private val CONTACTS_LIST = listOf<Contact>(
    Contact(
        firstName = "Анна",
        lastName = "Смирнова",
        phone = "+7 916 123 45 67",
        email = "anna.smirnova@mail.ru",
        city = "Санкт-Петербург"
    ),
    Contact(
        firstName = "Борис",
        lastName = "Иванов",
        phone = "+7 925 987 65 43",
        email = "boris.ivanov@gmail.com",
        city = "Казань"
    ),
    Contact(
        firstName = "Виктор",
        lastName = "Петров",
        phone = "+7 903 555 12 34",
        email = "victor.petrov@yandex.ru",
        city = "Новосибирск"
    ),
)

@Composable
fun Hello(name: String?) {
    val displayName = name ?: "Имя не задано"

    Text(text = "Привет, $displayName!")
}


@Preview(
    device = "spec:orientation=portrait,width=411dp,height=891dp,dpi=420",
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun HelloPreviewPortrait() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Hello(name = null)
    }
}

@Preview(
    device = "spec:orientation=landscape,width=891dp,height=411dp,dpi=420",
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun HelloPreviewLandscape() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Hello(name = null)
    }
}

@Preview(
    device = "id:wearos_small_round",
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun HelloPreviewRound() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Hello(name = null)
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun Task3TextPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {

        Text(
            text = stringResource(R.string.task_3_text),
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(R.string.task_3_text),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        Text(
            modifier = Modifier.background(color = Color.Green),
            text = stringResource(R.string.task_3_text),
            style = TextStyle(
                textIndent = TextIndent(
                    firstLine = 48.sp,
                ),
            ),
            textDecoration = TextDecoration.Underline,
            fontSize = 24.sp,
            color = Color.Black,
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun ButtonTask4Preview(
    modifier: Modifier = Modifier,
) {
    Button(

        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black,
        ),
        onClick = {},
    ) {
        Text (
            text = "Нажми на меня"
        )
    }
}

@Preview (
    showBackground = true,
)
@Composable
fun Task5(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
                .width(68.dp)
                .clip(CircleShape)
                .background(Color.Magenta),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "ДТ",
                color = Color.White
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun Task6First(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = null
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun Task6Second(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.circle),
            colorFilter = ColorFilter.tint(Color(0xFF9C27B0)),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Purple circle"
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun Task7(
    modifier: Modifier = Modifier,
    contacts: List<Contact> = CONTACTS_LIST,
) {
    val mainContact = contacts[0]

    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = "Имя: ${mainContact.firstName}")
                Text(text = "Фамилия: ${mainContact.lastName}")
                Text(text = "Телефон: ${mainContact.phone}")
                Text(text = "Email: ${mainContact.email}")
                Text(text = "Город: ${mainContact.city}")
            }
        }

        for (contact in contacts) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .background(Color.LightGray)
                        .padding(12.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Имя: ${contact.firstName}",
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "Фамилия: ${contact.lastName}",
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "Телефон: ${contact.phone}",
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "Email: ${contact.email}",
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "Город: ${contact.city}",
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.LightGray),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(5f),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Имя: ${mainContact.firstName}",
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "Фамилия: ${mainContact.lastName}",
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "Телефон: ${mainContact.phone}",
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "Email: ${mainContact.email}",
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "Город: ${mainContact.city}",
                        textAlign = TextAlign.Center,
                    )
                }
                Image(
                    modifier = Modifier.weight(1f),
                    painter = painterResource(R.drawable.circle),
                    contentDescription = "Contact avatar"
                )
            }
        }
    }
}

private const val CUP_ML = 250
private const val DAILY_GOAL_ML = 1500

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun WaterTracker() {
    var waterAmount by remember { mutableStateOf(0) }
    var streakDays by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Счётчик воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1976D2),
        )


        Text(
            text = "Выпито: $waterAmount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0288D1),
        )

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "Серия дней: $streakDays",
            fontSize = 48.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF388E3C),
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { waterAmount += CUP_ML },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1976D2),
                contentColor = Color.White,
            ),
        ) {
            Text(
                text = "+$CUP_ML мл",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (waterAmount >= DAILY_GOAL_ML) {
                    streakDays += 1
                } else {
                    streakDays = 0
                }
                waterAmount = 0
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF388E3C),
                contentColor = Color.White,
            ),
        ) {
            Text(
                text = "Закончить день",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}