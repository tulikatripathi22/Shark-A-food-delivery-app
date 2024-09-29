package com.example.shark.screen



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.lazy.grid.items
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shark.ProductType
import com.example.shark.R
import com.example.shark.Screen

@Composable
fun DashboardScreen(navController: NavController) {
    val searchState= remember { mutableStateOf(" ") }
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(2.0f)     // layers of paper on a desk. A higher zIndex means the element is placed on top, covering those below it
            ){
                Text(text = "An experience to savor,\na craving fulfilled",
                textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 48.dp, bottom = 24.dp)

                )
                Row(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(48.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(48.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically

                ){

                    BasicTextField(
                        value = searchState.value,
                        onValueChange = { searchState.value = it },
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(5f)
                            .wrapContentHeight()
                            .padding(start = 16.dp),
                        singleLine = true,
                        decorationBox = { innerTextField->
                            if(searchState.value.isEmpty()){
                                Text(
                                    text ="Search",
                                    color = Color.DarkGray,
                                    modifier = Modifier
                                        .weight(5f)
                                        .wrapContentHeight()
                                    )
                            }else{
                                innerTextField()

                            }
                        }

                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 6.dp)
                            .size(38.dp)
                            .background(
                                Color(android.graphics.Color.parseColor("#509790")),
                                RoundedCornerShape(19.dp)
                            )
                            .padding(8.dp),
                        colorFilter = ColorFilter.tint(Color.White)
                    )

                }

            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .weight(1f)
                    .offset(y = (-24).dp)
                    .zIndex(1f)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(android.graphics.Color.parseColor("#87CEEB")),
                                Color(android.graphics.Color.parseColor("#ADD8E6"))

                            )
                        )
                    )
                    .padding(start = 16.dp)

            ) {

                item {
                    ProductView(
                        image = R.drawable.list_item_1,
                        name = "Peri Peri Fries",
                        price = 55.99f,
                        modifier = Modifier.padding(end = 16.dp, top = 40.dp),
                        navController = navController,
                        productType = ProductType.PeriPeriFries
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.list_item_2,
                        name = "Veg Burger",
                        price = 78.99f,
                        modifier = Modifier.padding(end = 16.dp, top = 40.dp),
                        navController = navController,
                        productType = ProductType.VegBurger
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.list_item_3,
                        name = "Chinese Bowl",
                        price = 75.99f,
                        modifier = Modifier.padding(end = 16.dp, top = 40.dp)
                            .clickable { navController.navigate(Screen.Product.createRoute("Chinese Bowl")) },        //click
                        navController = navController,
                        productType = ProductType.ChineseBowl
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.list_item_4,
                        name = "Dosa Combo",
                        price = 89.99f,
                        modifier = Modifier.padding(end = 16.dp, top = 40.dp),
                        navController = navController,
                        productType = ProductType.DosaCombo
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.list_item_5,
                        name = "Potato Samosa",
                        price = 25.99f,
                        modifier = Modifier.padding(end = 16.dp, top = 40.dp),
                        navController = navController,
                        productType = ProductType.PotatoSamosa
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.list_item_6,
                        name = "Veg Thali",
                        price = 88.99f,
                        modifier = Modifier.padding(end = 16.dp, top = 40.dp),
                        navController = navController,
                        productType = ProductType.Thali
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.list_item_7,
                        name = "Premium Thali",
                        price = 99.9f,
                        modifier = Modifier.padding(end = 16.dp, top = 40.dp),
                        navController = navController,
                        productType = ProductType.PremiumThali
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.list_item_8,
                        name = "Hakka Noodles",
                        price = 75.99f,
                        modifier = Modifier.padding(end = 16.dp, top = 40.dp),
                        navController = navController,
                        productType = ProductType.HakkaNoodles
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.list_item_9,
                        name = "Spring Roll",
                        price = 55.99f,
                        modifier = Modifier.padding(end = 16.dp, top = 40.dp),
                        navController = navController,
                        productType = ProductType.SpringRoll
                    )
                }
                item {
                    ProductView(
                        image = R.drawable.list_item_10,
                        name = "Thukpa Soup",
                        price = 88.99f,
                        modifier = Modifier.padding(end = 16.dp, top = 40.dp),
                        navController = navController,
                        productType = ProductType.ThukpaSoup
                    )
                }
                }
        }


        Column(                                         //icon for bottom bar
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 16.dp, topEnd = 16.dp
                    )
                )
                .padding(top = 8.dp, end = 8.dp)
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp).clickable {
                        navController.navigate(Screen.Account.route)

                    },
                    tint = Color(android.graphics.Color.parseColor("#509790"))
                )
                androidx.compose.material3.Icon(
                    imageVector = Icons.Outlined.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color(android.graphics.Color.parseColor("#509790"))
                )

                androidx.compose.material3.Icon(
                    imageVector = Icons.Outlined.Call,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color(android.graphics.Color.parseColor("#509790"))

                )
                androidx.compose.material3.Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color(android.graphics.Color.parseColor("#509790"))

                )
                androidx.compose.material3.Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color(android.graphics.Color.parseColor("#509790"))

                )


            }


        }
    }

}

@Composable
fun ProductView(
    image: Int,
    name: String,
    price: Float,
    modifier: Modifier,
    navController: NavController,
    productType: ProductType
){
    ElevatedCard(
        modifier= modifier
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null
            ) {
                navController.navigate( Screen. Product. route + "/${productType.route}" )
            }
            .fillMaxWidth()
            .aspectRatio(0.7f),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        shape = RoundedCornerShape(
            topStart = 112.dp,
            topEnd = 112.dp,
            bottomStart = 8.dp,
            bottomEnd = 8.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(painter = painterResource(id = image),
                contentDescription = null,
                modifier= Modifier
                    .padding(8.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 112.dp,
                            topEnd = 112.dp
                        )
                    )
                    .fillMaxWidth()
                    .aspectRatio(0.9f)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = name,
                modifier=Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
            Text(
                text = "$$price",
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, bottom = 8.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
        
    }

}




@Preview
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(navController = rememberNavController())

}



