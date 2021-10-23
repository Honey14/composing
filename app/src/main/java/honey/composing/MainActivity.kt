package honey.composing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import honey.composing.ui.theme.ComposingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposingTheme {
                ListOfMenuItems(foodItems = MenuCard.listOfFoodItems)
            }
        }
    }
}

data class FoodItems(val resourceId: Int, val foodName: String)

@Preview
@Composable
fun PreviewListOfFood() {
    ComposingTheme {
        ListOfMenuItems(foodItems = MenuCard.listOfFoodItems)
    }
}

@Composable
private fun Menu(foodItem: FoodItems) {
    Row(modifier = Modifier.padding(all = 6.dp)) {
        Image(
            painter = painterResource(foodItem.resourceId),
            contentDescription = "Egg Sandwich",
            modifier = Modifier
                .size(89.dp)
                .clip(CircleShape)
                .border(1.5.dp, Color.LightGray, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = foodItem.foodName,
            color = Color.Black,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(all = 4.dp)
        )
    }
}

@Composable
fun ListOfMenuItems(foodItems: List<FoodItems>) {
    LazyColumn {
        items(foodItems) { foodItem ->
            Menu(foodItem)
        }
    }
}
