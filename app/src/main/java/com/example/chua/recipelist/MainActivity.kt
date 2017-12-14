package com.example.chua.recipelist

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private var mRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findView()

        mRecyclerView!!.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val recipe = ArrayList<Recipe>()

        recipe.add(Recipe(
                R.drawable.lemon_sandwiches,
                "Kale/Lemon Sandwiches",
                "This sandwich is stunningly delicious and tastes as good as it is healthy.",
                "1/2 cup unsalted butter, softened.\n" +
                        "1/3 cup granulated sugar.\n" +
                        "1/2 cup confectioner sugar.\n" +
                        "1 large egg, plus one egg yolk.\n" +
                        "1 tablespoon lemon zest.\n" +
                        "1/2 teaspoon lemon oil (or 1 teaspoon of lemon extract)\n" +
                        "1 1/2 cup all-purpose flour, plus 2 tablespoons.\n" +
                        "3 tablespoons cornstarch.",
                "1. Preheat oven to 350 degrees. In a large bowl using an electric mixer on high speed, beat butter, confectioners' sugar, lemon zest, and salt until combined. With mixer on low, add flour (dough will still be stiff); finish mixing with a wooden spoon.\n" +
                        "2. Turn dough out onto a piece of plastic wrap, pat into a disk about 1/2 inch thick. Wrap, and chill until firm, about 1 hour (and up to 3 days).\n" +
                        "3. Unwrap dough; place on a lightly floured piece of parchment or waxed paper. With a lightly floured rolling pin, roll dough about 1/8 inch thick (if dough cracks, let it warm up slightly).\n" +
                        "4. Cut out cookies with a 1 1/2-inch round cutter (reroll scraps once, chilling of too soft). Place 1 inch apart on two baking sheets; sprinkle with granulated sugar. Bake until barely beginning to brown, 15 to 20 minutes; transfer to wire racks to cool completely.\n" +
                        "5. Form sandwiches: Place about 1 teaspoon Creamy Lemon Filling between two cookies, sugared sides facing out; squeeze gently."))
        recipe.add(Recipe(
                R.drawable.mango_lime,
                "Mango-Lime",
                "Everyone loves this, so double or even triple the recipe!",
                "3 cups chopped ripe mango (about 3 mangoes)\n" +
                           "1 cup water\n" +
                           "Juice of 2 limes (about 1/4 cup)\n" +
                           "2 tablespoons sugar",
                "1. Place chopped mango in the bowl of a food processor fitted with the metal blade, and process until smooth. Transfer to a medium bowl. Add the water, lime juice, and sugar, and stir to dissolve.\n" +
                        "2. Pour mixture into a 9-by-5-inch deep-sided metal pan, and place in the freezer until nearly set, about 3 hours, whisking mixture every hour. Remove from freezer, and scrape surface with the tines of a fork until it is the texture of shaved ice. Return to freezer until ready to serve. Granita can be stored in an airtight container in the freezer up to 2 weeks."))
        recipe.add(Recipe(
                R.drawable.dinuguan,
                "Dinuguan",
                "This soup is so good Essy and I ate it ALL the first time I made it.",
                "10 ounces pig's blood\n" +
                        "1 cup vinegar\n" +
                        "1 tablespoon oil\n" +
                        "1 onion, peeled and chopped\n" +
                        "4 cloves garlic, peeled and minced\n" +
                        "1 small knob ginger (about 1 teaspoon), peeled and minced\n" +
                        "2 pounds pork belly, cut into ½-inch strips\n" +
                        "1 tablespoon fish sauce\n" +
                        "1 cup water\n" +
                        "1 tablespoon brown sugar\n" +
                        "2 finger chilies\n" +
                        "salt and pepper to taste",
                "1. Heat the oil in pan and sauté garlic and onions.\n" +
                        "2. Add the mashed blood and allow to simmer.\n" +
                        "3. Add the pork stock and boil.\n" +
                        "4. Add vinegar. ...\n" +
                        "5. Once boiling, season with sugar, salt, and pepper. ...\n" +
                        "6. Turn off the fire and toss in fired pork belly and chicharon.\n" +
                        "7. Garnish with green chili and serve immediately."))
        recipe.add(Recipe(
                R.drawable.lime_mouse,
                "Lime Mousse",
                "This is FABULOUS alone, topped with fruit of any kind or as a frosting on cake.",
                "6 tablespoons unsalted butter, room temperature\n" +
                        "1 1/3 cups sugar\n" +
                        "2 large eggs, plus 2 egg yolks\n" +
                        "1/2 cup fresh lemon juice\n" +
                        "2 tablespoons fresh lime juice\n" +
                        "1 teaspoon grated lemon zest, plus more for garnish\n" +
                        "1 1/2 cups heavy cream",
                "1. Make lemon curd: In a medium saucepan, whisk together butter, 1 cup sugar, eggs, yolks, and lemon and lime juices (mixture may appear curdled). Place over low heat; cook, stirring, until smooth, 4 to 5 minutes. Raise heat to medium; cook, stirring constantly, until thick enough to coat back of spoon, 4 to 8 minutes (do not boil).\n" +
                        "2. Remove pan from heat; stir in lemon zest. Transfer mixture to a bowl; cover with plastic wrap, and chill at least 1 hour.\n" +
                        "3. In a mixing bowl, beat cream and remaining 1/3 cup sugar to soft peaks. Whisk lemon curd to loosen, then gently fold in whipped cream. Spoon into 6 glasses. Cover; chill at least 2 hours and up to 3 days. Just before serving, garnish with zest."))
        recipe.add(Recipe(
                R.drawable.broiled_tilapia,
                "Broiled Tilapia Parmesan",
                "Flavorful recipe for this farm raised fish that is easy and done in minutes!",
                "1/2 cup Parmesan cheese 1/8 cup butter, softened\n" +
                        " 3 tablespoons light mayonnaise\n" +
                        "2 tablespoons fresh lemon juice\n" +
                        "1/4 teaspoon dried basil\n"+
                        "1/4 teaspoon ground black pepper\n"+
                        "1/8 teaspoon onion powder\n"+
                        "1/8 teaspoon celery salt\n"+
                        "2 pounds tilapia fillets",
                "1. Preheat oven broiler. Grease broiling pan or line with aluminum foil.\n" +
                        "2. Mix Parmesan cheese, butter, mayonnaise, and lemon juice together in a small bowl. Season with dried basil, pepper, onion powder, and celery salt. Mix well and set aside. Arrange fillets in a single layer on prepared pan.\n" +
                        "3. Broil a few inches from the heat for 2 to 3 minutes. Flip fillets over and broil for 2 or 3 minutes more. Remove fillets from oven and cover with Parmesan mixture on top side. Broil until fish flakes easily with a fork, about 2 minutes."))

        val adapter = CustomAdapter(recipe)

        mRecyclerView!!.adapter = adapter

        mRecyclerView!!.addItemDecoration(DividerItemDecoration(recipeRecycler.getContext(), LinearLayoutManager.VERTICAL))
    }

    public fun findView() {
        mRecyclerView = findViewById<RecyclerView>(R.id.recipeRecycler) as RecyclerView
    }

}
