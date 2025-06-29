package me.harish.grossoryapp.ui

import androidx.compose.runtime.getValue
import me.harish.grossoryapp.R

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.harish.grossoryapp.data.DataSource

@Composable
fun StartScreen(
    flashViewModel: FlashViewModel,
    onCategoryClicked : (Int) -> Unit
) {
    val context = LocalContext.current
    val flashUiState by flashViewModel.uiState.collectAsState()
    val categories = DataSource.loadCategories()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        item(
            span ={ GridItemSpan(2)}
        ){
            Column {
                Image(painter = painterResource(id = R.drawable.orange_fruit), contentDescription = "offer")
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(108, 194, 111, 255)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp),
                ){
                    Text(
                        text = "Shop by Category",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
            }
        }
        items(categories.size) { index ->
            CategoryCard(
                context = context,
                stringResourceId = categories[index].stringResourceId,
                imageResourceId = categories[index].imageResourceId,
                flashViewModel = flashViewModel,
                onCategoryClicked = onCategoryClicked
            )

        }
    }
}

    @Composable
    fun CategoryCard(
        context:Context,
        stringResourceId : Int,
        imageResourceId : Int,
        flashViewModel: FlashViewModel,
        onCategoryClicked: (Int) -> Unit
    ){
        val categoryName = stringResource(id = stringResourceId)
        Card (
            modifier = Modifier.clickable{
                flashViewModel.updateClickText(categoryName)
                Toast.makeText(context, "This card was clicked", Toast.LENGTH_SHORT).show()
                onCategoryClicked(stringResourceId)
            },
            colors = CardDefaults.cardColors(
                containerColor = Color(248,221,248)
            )
        ){
            Column(
                modifier = Modifier.padding(5.dp).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = stringResourceId),
                    fontSize = 24.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
            }
            Image(
                painter = painterResource(id = imageResourceId),
                contentDescription = "Fresh Fruits",
                modifier = Modifier.size(150.dp)
            )
    }
}
