package honey.composing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import honey.composing.ui.theme.ComposingTheme
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

data class FoodItems(val resourceId: Int, val foodName: String)

@Composable
private fun foodItem() {
    Row(modifier = Modifier.padding(all = 6.dp)) {
        Image(
            painter = painterResource(R.drawable.eggsand),
            contentDescription = "Egg Sandwich",
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
        )
        Text(text = "Egg sandwich")
        Spacer(modifier = Modifier.width(8.dp))
    }
}
