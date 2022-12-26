package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Portfolio()
            }
        }
    }
}

@Composable
fun Portfolio() {
    val isOpen = remember {
        mutableStateOf(false)
    }
    Surface(
        elevation = 8.dp, 
        shape = RoundedCornerShape(12.dp), 
        color = MaterialTheme.colors.onBackground, 
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)){
        

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(id = R.drawable.account),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "JetPackCompose", style = TextStyle(color = Color.Cyan, fontStyle = FontStyle.Italic), modifier = Modifier.height(30.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Android Compose Learning", style = MaterialTheme.typography.overline, modifier = Modifier.height(30.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.padding(2.dp)){
                Image(painter = painterResource(id = R.drawable.icons_instagram), contentDescription = null,
                    Modifier
                        .padding(horizontal = 2.dp))
                Text(text = "monty628", style = MaterialTheme.typography.caption, modifier = Modifier
                    .padding(horizontal = 2.dp))
            }
            Row(modifier = Modifier.padding(2.dp) ) {
                Image(painter = painterResource(id = R.drawable.github_mark), contentDescription = null,
                    Modifier
                        .padding(horizontal = 2.dp)
                        .height(15.dp))
                Text(text = "/Shivam240920", style = MaterialTheme.typography.caption, modifier = Modifier
                    .padding(horizontal = 2.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { isOpen.value = !isOpen.value }) {
                Text(text = "My Projects")
            }
            if(isOpen.value == true) {
                LazyColumn {
                    items(getList()) {
                        ProjectItem(it)
                    }
                }
            }
        }
    }
}

@Composable
fun ProjectItem(project: Project) {
    Row(modifier = Modifier.padding(8.dp)) {
       Image(painter = painterResource(id = R.drawable.pngwing), contentDescription = null,
       modifier = Modifier
           .size(40.dp)
           .clip(CircleShape))
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = project.name)
            Text(text = project.desc, style = MaterialTheme.typography.body1)
        }

    }
}


fun getList():List<Project>{
    return listOf(
        Project("Dice Roller","First project"),
        Project("GeoAlarm","Mini project"),
        Project("Miscellaneous","For learning purpose")
    )
}

data class Project(
    val name:String,
    val desc:String
)