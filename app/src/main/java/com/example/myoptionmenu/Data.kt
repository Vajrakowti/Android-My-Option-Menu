package com.example.myoptionmenu

data class Dish(

    val name : String,
    val price : Int,
    val image : Int
)

val dishList = listOf<Dish>(

    Dish("Apple",1,R.drawable.ic_launcher_background),
    Dish("Orange",2,R.drawable.ic_launcher_background),
    Dish("Mango",3,R.drawable.ic_launcher_background),
    Dish("Grape",4,R.drawable.ic_launcher_background),
    Dish("Pomegranate",5,R.drawable.ic_launcher_background),
    Dish("Papaya",6,R.drawable.ic_launcher_background),
    Dish("Avocado",7,R.drawable.ic_launcher_background),
    Dish("Musk Melon",8,R.drawable.ic_launcher_background),
    Dish("Water Melon",9,R.drawable.ic_launcher_background),
    Dish("Kiwi",10,R.drawable.ic_launcher_background),
    Dish("Banana",11,R.drawable.ic_launcher_background),
    Dish("Lemon",12,R.drawable.ic_launcher_background),
    Dish("Pineapple",13,R.drawable.ic_launcher_background),
    Dish("Blueberry",14,R.drawable.ic_launcher_background),
    Dish("Strawberry",15,R.drawable.ic_launcher_background),
    Dish("Pear",16,R.drawable.ic_launcher_background),
    Dish("Guava",17,R.drawable.ic_launcher_background),
    Dish("Cherry",25,R.drawable.ic_launcher_background)

)
