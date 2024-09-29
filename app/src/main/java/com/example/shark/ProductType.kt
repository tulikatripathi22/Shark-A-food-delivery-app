package com.example.shark

sealed class ProductType(val route: String) {
    object ChineseBowl : ProductType("chineseBowl")
    object PeriPeriFries : ProductType("periPeriFries")
    object VegBurger : ProductType("vegBurger")
    object DosaCombo : ProductType("dosaCombo")
    object HakkaNoodles : ProductType("hakkaNoodles")
    object PremiumThali : ProductType("premiumThali")
    object PotatoSamosa : ProductType("potatoSamosa")
    object SpringRoll : ProductType("springRoll")
    object Thali : ProductType("thali")
    object ThukpaSoup : ProductType("thukpaSoup")


    // Add more product types as needed
    object NoProduct : ProductType("noProduct")
}