package honey.composing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

data class FoodItems(val resourceId: Int, val foodName: String)

@Composable
private fun Menu(foodItem: FoodItems) {
    Row(modifier = Modifier.padding(all = 6.dp)) {
        Image(
            painter = painterResource(foodItem.resourceId),
            contentDescription = "Egg Sandwich",
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
        )
        Text(text = foodItem.foodName)
        Spacer(modifier = Modifier.width(8.dp))
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
