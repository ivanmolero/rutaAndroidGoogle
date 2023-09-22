package com.imolerodev.a03courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridCells.Fixed
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imolerodev.a03courses.data.DataSource
import com.imolerodev.a03courses.model.Topic
import com.imolerodev.a03courses.ui.theme.A03CoursesTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A03CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesApp()
                }
            }
        }
    }
}

@Composable
fun CoursesApp() {
    CourseList(courseList = DataSource.topics)
}

@Composable
fun CourseItem(topic: Topic, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .height(68.dp)
            .background(
                color = Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Image(
            painter = painterResource(id = topic.imageResourceId),
            contentDescription = stringResource(id = topic.stringResourceCourseNameId),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(68.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        bottomStart = 10.dp
                    )
                )
            )
        Column(
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    end = 16.dp,
                    start = 16.dp
                )
        ) {
            Text(
                text = LocalContext.current.getString(topic.stringResourceCourseNameId),
                style = MaterialTheme.typography.bodyMedium,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(
                        top = 8.dp
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_grain_24),
                    contentDescription = null,
                )
                Text(
                    text = topic.size.toString(),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                        .padding(
                            start = 8.dp
                        )
                )
            }
        }
    }
}

@Composable
fun CourseList(courseList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(
                courseList.size
            ) {
                index ->
                CourseItem(topic = courseList[index], Modifier)
            }
        }
    )
}
@Preview
@Composable
fun CourseItemPreview() {
    CourseItem(topic = Topic(R.string.photography, 321, R.drawable.photography))
}