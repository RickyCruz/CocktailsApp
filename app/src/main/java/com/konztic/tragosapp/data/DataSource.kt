package com.konztic.tragosapp.data

import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.vo.Resource

class DataSource {

    val generateDrinkList = Resource.Success(
        listOf<Drink>(
            Drink("https://www.google.com/imgres?imgurl=https%3A%2F%2Fhips.hearstapps.com%2Fhmg-prod.s3.amazonaws.com%2Fimages%2Fmarg-h-1526063646.jpg&imgrefurl=https%3A%2F%2Fwww.delish.com%2Fcooking%2Frecipe-ideas%2Fa20139300%2Fbest-classic-margarita-recipe%2F&tbnid=k2CLXstY1REHdM&vet=12ahUKEwjG2MeWxtzrAhWCx54KHbfyATAQMygAegUIARDyAQ..i&docid=T7E7mEBOaVNcNM&w=2500&h=1667&q=margarita&ved=2ahUKEwjG2MeWxtzrAhWCx54KHbfyATAQMygAegUIARDyAQ", "Margarita", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vitae dui ut est maximus vulputate. Nullam auctor suscipit ligula, id condimentum mi aliquam ut."),
            Drink("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dark-and-stormy-1594302243.png?crop=1xw:1xh;center,top&resize=768:*", "Dark and Stormy", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vitae dui ut est maximus vulputate. Nullam auctor suscipit ligula, id condimentum mi aliquam ut."),
            Drink("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/french-75-1594302212.png?crop=1xw:1xh;center,top&resize=768:*", "French 75", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vitae dui ut est maximus vulputate. Nullam auctor suscipit ligula, id condimentum mi aliquam ut."),
            Drink("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/boulevardier-1594302158.png?crop=1xw:1xh;center,top&resize=768:*", "Boulevardier", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vitae dui ut est maximus vulputate. Nullam auctor suscipit ligula, id condimentum mi aliquam ut."),
            Drink("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/bloody-mary-1594302099.png?crop=1xw:1xh;center,top&resize=768:*", "Bloody Mary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vitae dui ut est maximus vulputate. Nullam auctor suscipit ligula, id condimentum mi aliquam ut.")
        )
    )
}