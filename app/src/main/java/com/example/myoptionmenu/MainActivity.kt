package com.example.myoptionmenu

import android.content.ClipData.Item
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myoptionmenu.ui.theme.MyOptionMenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
              OptionMenuScreen()
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionMenuScreen()
{
    var displayMenu by remember { mutableStateOf(false) }

    var updatedDishList by remember {
        mutableStateOf(listOf<Dish>())
    }

    fun sortDishListAsc(items : List<Dish>) : List<Dish>
    {
        return items.sortedBy { it.name }
    }

    fun sortDishListDesc(items : List<Dish>) : List<Dish>
    {
        return items.sortedByDescending{ it.name }
    }

    fun sortDishListByPriceAsc(items : List<Dish>) : List<Dish>
    {
        return items.sortedBy{ it.price }
    }

    fun sortDishListByPriceDesc(items : List<Dish>) : List<Dish>
    {
        return items.sortedByDescending{ it.price }
    }

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        
        TopAppBar(title = { Text(text = "My Option Menu", color = Color.Black)},
            modifier = Modifier.background(Color.Blue),
            actions = {

                IconButton(onClick = { Toast.makeText(context,"Favourite Button clicked!",Toast.LENGTH_SHORT).show()}) {
                    Icon(imageVector = Icons.Default.Favorite,contentDescription = "")
                }

                IconButton(onClick = { displayMenu = !displayMenu}) {
                    Icon(imageVector = Icons.Default.MoreVert,contentDescription = "")
                }

                DropdownMenu(expanded = displayMenu, onDismissRequest = { displayMenu = false}) {

                    DropdownMenuItem(text = { Text(text = "Filter")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Sort : A - Z")}, onClick = { updatedDishList = sortDishListAsc(
                        dishList) })
                    DropdownMenuItem(text = { Text(text = "Sort : Z - A")}, onClick = { updatedDishList = sortDishListDesc(
                        dishList)})
                    DropdownMenuItem(text = { Text(text = "Sort by Price : Lower to Higher")}, onClick = { updatedDishList = sortDishListByPriceAsc(
                        dishList) })
                    DropdownMenuItem(text = { Text(text = "Sort by Price : Higher to Lower")}, onClick = { updatedDishList = sortDishListByPriceDesc(
                        dishList) })

                }
            }
        )
        
        LazyColumn()
        {
            items(updatedDishList){
                item -> DishScreen(item)
            }
        }
    }
    
}

@Composable
fun DishScreen(item : Dish)
{
    Card{
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
            ){
            Column {
                Text(text = item.name, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(5.dp))
                Text(text = "$ "+item.price, fontSize = 18.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(start = 5.dp))
            }

            Image(painter = painterResource(id = item.image), contentDescription = "", modifier = Modifier.requiredSize(60.dp,60.dp))
        }
        
    }
    Divider(modifier = Modifier.padding(start = 8.dp, end = 8.dp), color = Color.Black, thickness = 2.dp)
}

