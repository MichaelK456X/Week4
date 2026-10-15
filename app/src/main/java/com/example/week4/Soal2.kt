package com.example.week4

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Hero(
    val id: Int, val name: String, val type: String, val role: String,
    val level: Int, val cp: Int, val hp: Int, val maxHp: Int,
    val mp: Int, val maxMp: Int, val attack: Int, val defense: Int,
    val critical: String, val speed: Int, val skill: String, val description: String,
    val fotoRes: Int
)

@Composable
fun Soal2() {
    val HeroList = remember {
        listOf(
            Hero(
                1,
                "Burlock",
                "Impact Breaker",
                "Berserker",
                40,
                3800,
                1500,
                2700,
                600,
                800,
                380,
                540,
                "22%",
                105,
                "Feel My Wrath",
                "Calls down an imperial hammer and stuns all enemies nearby.",
                R.drawable.berserker
            ),
            Hero(
                2,
                "Yelena",
                "Thunderess",
                "Archmage",
                50,
                5120,
                400,
                600,
                3000,
                3000,
                550,
                180,
                "30%",
                95,
                "Meteor Shower",
                "Summons falling rocks from the sky creating a crazy waves of destruction.",
                R.drawable.archmage
            ),
            Hero(
                3,
                "Jake",
                "Crusher",
                "Berserker",
                48,
                5350,
                500,
                950,
                410,
                600,
                490,
                210,
                "45%",
                130,
                "Demolisher",
                "Destroys all buildings and environment within its range.",
                R.drawable.berserker
            ),
            Hero(
                4,
                "Brave",
                "Iron Wall",
                "Paladin",
                44,
                4800,
                2500,
                2500,
                300,
                600,
                250,
                800,
                "5%",
                75,
                "Fortress",
                "Deny all incoming attack in a straight direction.",
                R.drawable.paladin
            ),
            Hero(
                5,
                "Garrick",
                "Black Skull",
                "Berserker",
                45,
                4900,
                1720,
                2000,
                300,
                500,
                410,
                600,
                "15%",
                90,
                "Bloodlust",
                "Enters Skull Mode and become 10% stronger by each enemy defeat.",
                R.drawable.berserker
            ),
            Hero(
                6,
                "Theresa",
                "Ice Queen",
                "Archmage",
                49,
                5480,
                1100,
                1200,
                2100,
                2400,
                210,
                320,
                "15%",
                115,
                "Divine Protection",
                "Reduce all of squad damage taken by 30%.",
                R.drawable.archmage
            ),
            Hero(
                7,
                "Arthur",
                "Holy Knight",
                "Paladin",
                50,
                5500,
                2100,
                2200,
                800,
                800,
                300,
                700,
                "10%",
                85,
                "Grand Shield",
                "Gains a shield everytime an enemy is defeated.",
                R.drawable.paladin
            ),
            Hero(
                8,
                "Lyra",
                "Grim Reaper",
                "Rogue",
                45,
                4850,
                760,
                950,
                590,
                700,
                430,
                230,
                "35%",
                128,
                "Ghost Slash",
                "Haunts all enemies caught by the slash.",
                R.drawable.rogue
            ),
            Hero(
                9,
                "Galacta",
                "Sun Guardian",
                "Paladin",
                47,
                5200,
                1910,
                2100,
                690,
                900,
                320,
                650,
                "12%",
                90,
                "Solar Flare",
                "Blinds enemies reducing their precision and vision.",
                R.drawable.paladin
            ),
            Hero(
                10,
                "Valerie",
                "Priest",
                "Cleric",
                48,
                5050,
                1200,
                1300,
                2500,
                2500,
                150,
                400,
                "8%",
                110,
                "Holy Sanctuary",
                "Continuously heals all squad members inside the area.",
                R.drawable.cleric
            ),
            Hero(
                11,
                "Elden",
                "Sage",
                "Cleric",
                46,
                4950,
                1060,
                1200,
                2300,
                2400,
                180,
                380,
                "10%",
                108,
                "Revival",
                "Brings back a fallen hero with 30% of their max health.",
                R.drawable.cleric
            ),
            Hero(
                12,
                "Trebor",
                "Demon Hunter",
                "Rogue",
                49,
                5400,
                840,
                1000,
                600,
                700,
                510,
                240,
                "50%",
                135,
                "Weakness",
                "Becomes faster and deals more damage to demon enemies.",
                R.drawable.rogue
            ),
            Hero(
                13,
                "Karis",
                "Dread Hands",
                "Rogue",
                47,
                5100,
                980,
                1050,
                550,
                600,
                470,
                250,
                "40%",
                140,
                "Dual Slash",
                "Strikes the target twice rapidly with quick succession.",
                R.drawable.rogue
            ),
            Hero(
                14,
                "Bishop",
                "Bounty Hunter",
                "Rogue",
                43,
                4600,
                920,
                1000,
                370,
                500,
                450,
                220,
                "38%",
                125,
                "Marked",
                "Increases gold and item drop rates from fallen enemies.",
                R.drawable.rogue
            )
        )
    }

    var selectedFilter by remember { mutableStateOf("All (14)") }
    var heroCard by remember { mutableStateOf<Int?>(null) }
    val filters = listOf(
        "All (14)",
        "Berserker (3)",
        "Archmage (2)",
        "Paladin (3)",
        "Cleric (2)",
        "Rogue (4)"
    )

    Scaffold(containerColor = Color(0xFF0F0E17)) { p ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(p)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            "Party Roster",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            "Guild Vanguard • 14 Heroes Available",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF25211E))
                            .padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.Star,
                            null,
                            tint = Color(0xFFFFB900),
                            modifier = Modifier.size(12.dp)
                        )
                        Text(
                            " Expedition",
                            color = Color(0xFFFFB900),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF1E1625))
                        .border(1.dp, Color(0xFF38234A), RoundedCornerShape(8.dp))
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(Modifier
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(Color.Green))
                            Text(
                                " EXPEDITION SQUAD (3/4)",
                                fontSize = 11.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(Modifier.height(8.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            HeroList.take(3).forEach { squadHero ->
                                Image(
                                    painter = painterResource(id = squadHero.fotoRes),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(42.dp)
                                        .clip(RoundedCornerShape(6.dp)),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Box(
                                Modifier
                                    .size(42.dp)
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0xFF2A2435))
                                    .border(1.dp, Color(0xFF443953), RoundedCornerShape(6.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("+", color = Color.Gray, fontSize = 16.sp)
                            }
                        }
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Default.Close,
                                null,
                                tint = Color(0xFFFFB900),
                                modifier = Modifier.size(12.dp)
                            )
                            Text(
                                " 14750 CP",
                                color = Color(0xFFFFB900),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(Modifier.height(8.dp))
                        Box(
                            Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color(0xFFFFB900))
                                .clickable {}
                                .padding(horizontal = 16.dp, vertical = 6.dp)
                        ) {
                            Text(
                                "Deploy",
                                color = Color.Black,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF161522))
                        .border(1.dp, Color(0xFF2D2B44), RoundedCornerShape(8.dp))
                        .padding(horizontal = 12.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Search,
                        null,
                        tint = Color.Gray,
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        " Search by Hero Name, Class, or Rarity",
                        color = Color.Gray,
                        fontSize = 13.sp
                    )
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .horizontalScroll(rememberScrollState())
                            .padding(end = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        filters.forEach { filter ->
                            val isSel = selectedFilter == filter
                            Box(
                                Modifier
                                    .clip(CircleShape)
                                    .background(if (isSel) Color(0xFFFFB900) else Color(0xFF161522))
                                    .border(
                                        1.dp,
                                        if (isSel) Color(0xFFFFB900) else Color(0xFF32304D),
                                        CircleShape
                                    )
                                    .clickable { selectedFilter = filter }
                                    .padding(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    filter,
                                    color = if (isSel) Color.Black else Color.LightGray,
                                    fontSize = 11.sp
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color(0xFF161522))
                            .border(1.dp, Color(0xFF32304D), CircleShape)
                            .padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Sort: Power ",
                            color = Color(0xFFFFB900),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            val filteredList = if (selectedFilter.startsWith("All")) HeroList else HeroList.filter {
                selectedFilter.contains(it.role)
            }
            items(filteredList) { hero ->
                val isExp = heroCard == hero.id
                HeroCard(hero, isExp) { heroCard = if (isExp) null else hero.id }
            }
            item { Spacer(Modifier.height(16.dp)) }
        }
    }
}

@Composable
fun HeroCard(hero: Hero, isExp: Boolean, onClick: () -> Unit) {
    val arrowRotate by animateFloatAsState(if (isExp) 180f else 0f, label = "")

    val (roleColor, roleBgColor) = when (hero.role) {
        "Berserker" -> Color(0xFFF97316) to Color(0xFF331708)
        "Archmage" -> Color(0xFF06B6D4) to Color(0xFF0B2B36)
        "Paladin" -> Color(0xFFEAB308) to Color(0xFF2C2208)
        "Cleric" -> Color(0xFF22C55E) to Color(0xFF0A2E1A)
        "Rogue" -> Color(0xFFD946EF) to Color(0xFF2C0E38)
        else -> Color(0xFF60A5FA) to Color(0xFF162B3D)
    }

    Column(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF161522))
            .border(
                1.dp,
                if (isExp) Color(0xFFFFB900) else Color(0xFF252336),
                RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(12.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Box(
                    Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFF3D161A))
                        .border(1.dp, Color(0xFFEF4444), RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        "MYTHIC",
                        color = Color(0xFFEF4444),
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(roleBgColor)
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        hero.type,
                        color = roleColor,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Text(
                "⚔ ${hero.cp} CP",
                color = Color(0xFFFFB900),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Box(
                Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .border(2.dp, roleColor, RoundedCornerShape(10.dp))
            ) {
                Image(
                    painter = painterResource(id = hero.fotoRes),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    Modifier
                        .align(Alignment.BottomEnd)
                        .clip(RoundedCornerShape(topStart = 6.dp, bottomEnd = 8.dp))
                        .background(Color(0xFF1A1926))
                        .padding(horizontal = 5.dp, vertical = 2.dp)
                ) {
                    Text(
                        "Lvl ${hero.level}",
                        color = Color.White,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        hero.name,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        Icons.Default.ArrowDropDown,
                        null,
                        tint = Color.Gray,
                        modifier = Modifier.rotate(arrowRotate)
                    )
                }
                Spacer(Modifier.height(4.dp))
                StatBar("HP", hero.hp, hero.maxHp, Color(0xFFFF4D4D), Color(0xFF2A1C20))
                Spacer(Modifier.height(4.dp))
                StatBar("MP", hero.mp, hero.maxMp, Color(0xFF3B82F6), Color(0xFF14223A))
            }
        }
        AnimatedVisibility(visible = isExp) {
            Column {
                Spacer(Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    val stats = listOf(
                        "ATK" to hero.attack.toString(),
                        "DEF" to hero.defense.toString(),
                        "CRIT" to hero.critical,
                        "SPD" to hero.speed.toString()
                    )
                    stats.forEach { (lbl, valStr) ->
                        Box(
                            Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color(0xFF0F0E17))
                                .padding(vertical = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(lbl, color = Color.Gray, fontSize = 9.sp)
                                Text(
                                    valStr,
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
                Spacer(Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.Star,
                        null,
                        tint = Color(0xFFFFB900),
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        " ${hero.skill}",
                        color = Color(0xFFFFB900),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(Modifier.height(2.dp))
                Text(
                    hero.description,
                    color = Color.LightGray,
                    fontSize = 11.sp,
                    lineHeight = 14.sp
                )
                Spacer(Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Box(
                        Modifier
                            .weight(1f)
                            .height(32.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF1A3A2A))
                            .clickable {},
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Heal (+250 HP)",
                            color = Color(0xFF4ADE80),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Box(
                        Modifier
                            .weight(1f)
                            .height(32.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF2C2418))
                            .border(1.dp, Color(0xFFFFB900), RoundedCornerShape(6.dp))
                            .clickable {},
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Add to Squad",
                            color = Color(0xFFFFB900),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StatBar(label: String, curValue: Int, maxValue: Int, color: Color, trackColor: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(label, color = Color.White, fontSize = 9.sp, modifier = Modifier.width(20.dp))
        Box(Modifier
            .weight(1f)
            .height(6.dp)
            .clip(CircleShape)
            .background(trackColor)) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(curValue.toFloat() / maxValue.toFloat())
                    .clip(CircleShape)
                    .background(color)
            )
        }
        Text(" $curValue / $maxValue", color = Color.White, fontSize = 9.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun Soal2Preview() {
    Soal2()
}