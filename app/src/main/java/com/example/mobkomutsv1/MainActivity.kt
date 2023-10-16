package com.example.mobkomutsv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobkomutsv1.ui.theme.MobkomUTSV1Theme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobkomUTSV1Theme {
                CourseList(courses)
            }
        }
    }
}

// Daftar mata kuliah Anda
val courses = listOf(
    Course("Kalkulus 1", 3, R.drawable.mata_kuliah2),
    Course("Fisika Dasar", 3, R.drawable.mata_kuliah2),
    Course("Kimia Dasar", 3, R.drawable.mata_kuliah2),
    Course("Pemrograman Dasar", 3, R.drawable.mata_kuliah2),
    Course("Aljabar Linear", 3, R.drawable.mata_kuliah2),
    Course("Pendidikan Kewarganegaraan", 2, R.drawable.mata_kuliah2),
    Course("Bahasa Inggris", 2, R.drawable.mata_kuliah2),
    Course("Pengantar Ilmu Komputer", 3, R.drawable.mata_kuliah2),
    Course("Pengantar Manajemen", 3, R.drawable.mata_kuliah2),
    Course("Statistika", 3, R.drawable.mata_kuliah2)
)

@Composable
fun CourseItem(course: Course) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(

        ){
            Box(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = course.imageResource),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(shape = CircleShape)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = course.name,
                    style = TextStyle(fontSize = 18.sp)
                )
                Text(
                    text = "SKS: ${course.sks}",
                    style = TextStyle(fontSize = 14.sp)
                )
            }
        }
    }
}

@Composable
fun CourseList(courses: List<Course>) {
    LazyColumn(
        content = {
            items(
                items = courses,
                itemContent = { course ->
                    CourseItem(course = course)
                }
            )
        },
        contentPadding = PaddingValues(16.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MobkomUTSV1Theme {
        CourseList(courses)
    }
}
