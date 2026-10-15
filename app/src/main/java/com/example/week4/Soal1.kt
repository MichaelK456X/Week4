package com.example.week4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.border

data class Mobil(
    val id: Int,
    val nama: String,
    val jenis: String,
    val tahun: String,
    val km: String,
    val harga: String,
    val lokasi: String,
    val deskripsi: String,
    val gambar: Int,
    val kategori: String
)

@Composable
fun Soal1() {
    val daftarMobil = remember {
        mutableStateListOf(
            Mobil(
                1,
                " Daihatsu Ayla Pro Max",
                "Auto",
                "2025",
                "2,500 km",
                "Rp 200.000.000",
                "Jakarta",
                "Daihatsu All New Ayla 2025 hadir sebagai pilihan utama mobil perkotaan (city car) di kelas LCGC yang menawarkan kombinasi sempurna antara efisiensi, kepraktisan, dan kenyamanan sehari-hari. Mobil ini mengadopsi platform modern DNGA (Daihatsu New Global Architecture) dengan desain eksterior yang lebih segar, sporty, dan dinamis.\nUntuk performa, Ayla 2025 dibekali dua pilihan mesin, yaitu 1.0L dan 1.2L Dual VVT-i yang responsif serta sangat irit bahan bakar. Pilihan transmisinya tersedia dalam manual dan otomatis CVT yang halus. Masuk ke bagian interior, kabin berkapasitas 5 penumpang ini terasa lebih modern dengan material dasbor solid, AC digital, serta head unit layar sentuh yang mendukung Android Auto dan Apple CarPlay pada varian tertinggi.\nFitur keselamatannya pun semakin ditingkatkan dengan adanya Dual SRS Airbag, ABS, EBD, hingga Vehicle Stability Control (VSC). Dengan harga yang sangat kompetitif, Ayla 2025 sangat ideal bagi pengemudi pemula maupun keluarga muda.",
                R.drawable.ayla,
                "Petrol"
            ),
            Mobil(
                2,
                "Honda CRV",
                "Auto",
                "2018",
                "18,300 km",
                "Rp 270.000.000",
                "Jambi",
                "Honda CR-V 2018 merupakan salah satu model SUV medium paling populer yang menawarkan kombinasi sempurna antara kenyamanan keluarga, kemewahan, dan performa tangguh. Mobil besutan Honda ini hadir dalam tiga varian utama, yaitu tipe 2.0L naturally aspirated serta tipe 1.5L Turbo dan 1.5L Turbo Prestige yang lebih bertenaga.\nDi sektor dapur pacu, varian tertinggi mengandalkan mesin 1.5L VTEC Turbo dengan Earth Dreams Technology yang mampu menghasilkan tenaga responsif hingga 190 PS. Performa ini dipadukan dengan transmisi CVT yang halus dan efisien dalam konsumsi bahan bakar.\nDari segi desain, eksteriornya tampil gagah dengan lampu depan LED runcing berkonsep Solid Wing Face dan pelek sporty 18 inci. Bagian interiornya menyuguhkan kabin luas berkapasitas 7 penumpang, material soft touch premium, serta panel instrumen digital. Tipe Prestige semakin mewah berkat fitur Panoramic Power Sunroof, panel kayu, dan fitur keselamatan modern seperti Vehicle Stability Assist. Desainnya yang timeless membuat SUV ini tetap berkelas dan diminati hingga saat ini",
                R.drawable.crv,
                "PETROL"
            ),
            Mobil(
                3,
                "Honda HRV",
                "Auto",
                "2022",
                "25,500 km",
                "Rp 350.000.000",
                "Surabaya",
                "Honda HR-V 2021 hadir sebagai salah satu SUV kompak terpopuler di Indonesia yang memadukan kenyamanan mobil sedan dengan ketangguhan sebuah SUV. Dari sisi eksterior, mobil ini menonjolkan kesan sporty dan modern melalui garis bodi yang tegas serta desain handle pintu belakang unik yang terintegrasi pada pilar C untuk menciptakan siluet menyerupai mobil coupe.\nMasuk ke bagian interior, kabin Honda HR-V menyajikan ruang yang lapang dan material premium untuk kenyamanan berkendara di perkotaan maupun jarak jauh. Di pasar Indonesia, kendaraan ini umumnya dipasarkan dalam dua pilihan dapur pacu, yakni mesin 1.5L i-VTEC yang efisien serta varian 1.8L i-VTEC (pada tipe Prestige) bagi pengendara yang menginginkan performa lebih bertenaga. Seluruh tenaga tersebut disalurkan melalui transmisi CVT yang halus. Fitur keselamatan standar seperti Vehicle Stability Assist (VSA) dan Hill Start Assist (HSA) juga telah disematkan untuk menjamin stabilitas berkendara.",
                R.drawable.hrv,
                "PETROL"
            ),
            Mobil(
                4,
                "Jaecoo J5",
                "Auto",
                "2026",
                "1,000 km",
                "Rp 280.000.000",
                "Solo",
                "Jaecoo J5 2026 hadir sebagai SUV listrik modern 5-seater yang memadukan ketangguhan berkendara dengan efisiensi tinggi. Mengusung baterai berkapasitas 60,9 kWh, mobil listrik urban ini mampu menghasilkan tenaga impresif hingga 207 hp (155 kW) dan torsi puncak sebesar 340 Nm. Dengan sekali pengisian daya penuh, kendaraan ini dapat menjelajah sejauh 461 km.\nDari sisi eksterior, Jaecoo J5 menampilkan postur kokoh dengan ground clearance 200 mm, velg R18 two-tone, serta lampu berteknologi LED. Bagian interiornya menyuguhkan kemewahan minimalis berkat material soft touch, layar sentuh vertikal berukuran 13,2 inci yang mendukung konektivitas Android Auto dan Apple CarPlay, serta kelapangan ruang bagasi utama hingga 480 Liter. Untuk aspek keselamatan, varian tertingginya telah dilengkapi sistem 17 fitur ADAS dan kamera 360 derajat. Di pasar Indonesia, Jaecoo J5 dipasarkan dalam rentang harga kompetitif berkisar antara Rp 279,9 Juta hingga Rp 319,9 Juta.",
                R.drawable.j5,
                "EV"
            ),
            Mobil(
                5,
                "MG 4",
                "Auto",
                "2026",
                "3,200 km",
                "Rp 350.000.000",
                "Semarang",
                "MG 4 EV merupakan mobil listrik berjenis hatchback crossover yang memadukan desain eksterior sporty dan futuristik. Dirancang oleh SAIC Motor, kendaraan ramah lingkungan ini tampil mencolok dengan garis bodi tajam, lampu depan full LED, serta spoiler belakang bergaya minimalis modern.\nDibangun di atas platform Nebula Pure, MG 4 EV mengadopsi sistem penggerak roda belakang (RWD). Varian standarnya dibekali baterai berkapasitas 51 kWh yang mampu menyemburkan tenaga hingga 170 PS dan torsi maksimal 250 Nm. Dengan spesifikasi tersebut, mobil ini memiliki jarak tempuh hingga 425 km dalam sekali pengisian daya. G 4 EV merupakan mobil listrik berjenis hatchback crossover yang memadukan desain eksterior sporty dan futuristik. Dirancang oleh SAIC Motor, kendaraan ramah lingkungan ini tampil mencolok dengan garis bodi tajam, lampu depan full LED, serta spoiler belakang",
                R.drawable.mg4,
                "EV"
            ),
            Mobil(
                6,
                "Innova Reborn Hybrid",
                "Auto",
                "2022",
                "13,650 km",
                "Rp 320.000.000",
                "Jombang",
                "Toyota Kijang Innova Reborn merupakan Medium MPV legendaris yang menjadi mobil keluarga favorit di Indonesia. Kendaraan ini menawarkan kabin luas yang mampu menampung hingga 7 penumpang dengan tingkat kenyamanan tinggi, didukung ruang kaki yang lega serta kapasitas bagasi yang sangat lapang.\n Toyota Kijang Innova Reborn merupakan Medium MPV legendaris yang menjadi mobil keluarga favorit di Indonesia. Kendaraan ini menawarkan kabin luas yang mampu menampung hingga 7 penumpang dengan tingkat kenyamanan tinggi, didukung ruang kaki yang lega serta kapasitas bagasi yang sangat lapang.Secara performa, Innova Reborn menyediakan dua pilihan mesin tangguh. Varian bensin menggunakan mesin berkapasitas 2.000 cc yang halus, sementara varian diesel mengandalkan mesin 2.400 cc VNT yang bertenaga besar, irit bahan bakar, dan terkenal bandel untuk perjalanan jauh. Kedua opsi tersebut dipadukan dengan transmisi manual 5-percepatan atau otomatis 6-percepatan.",
                R.drawable.reborn,
                "HYBRID"
            ),
            Mobil(
                7,
                "Cherry Tigo",
                "Auto",
                "2024",
                "5,000 km",
                "Rp 220.000.000",
                "Semarang",
                "Chery Tiggo adalah lini sport utility vehicle (SUV) modern besutan produsen otomotif global, Chery. Kendaraan ini dirancang secara presisi untuk memadukan desain futuristik, performa tangguh, dan teknologi canggih. Tampilan eksteriornya menonjolkan kesan berkelas lewat fascia depan berornamen diamond grille mewah serta sistem pencahayaan full LED yang tajam.\nSecara global, keluarga Chery Tiggo (termasuk Tiggo Cross) telah mencatat sejarah dengan ekspor dan penjualan masing-masing model yang melampaui 1 juta unit di pasar internasional.Sektor performa lini Chery Tiggo hadir dalam berbagai varian dapur pacu bertenaga, mulai dari mesin 1.500 cc konvensional, varian mesin turbo, hingga opsi teknologi modern Chery Super Hybrid (CSH) yang efisien dan ramah lingkungan.",
                R.drawable.tiggo,
                "EV"
            ),
            Mobil(
                8,
                "Daihatsi Xenia ",
                "Auto",
                "2021",
                "10,500 km",
                "Rp 180.000.000",
                "Surabaya",
                "Daihatsu Xenia adalah mobil keluarga legendaris di Indonesia yang masuk dalam kategori Low MPV 7 penumpang. Dikembangkan sebagai \"Sahabat Keluarga\", kendaraan ini dirancang untuk menawarkan kenyamanan, kepraktisan, dan efisiensi bahan bakar yang tinggi dalam mendukung mobilitas harian. Daihatsu Xenia adalah mobil keluarga jenis MPV (Multi Purpose Vehicle) berkapasitas 7 penumpang yang diproduksi sejak 2004 di Indonesia. Mobil ini terkenal irit bahan bakar, tangguh, memiliki kabin lapang, serta menggunakan sistem penggerak roda depan dan platform DNGA pada generasi terbarunya. Daihatsu Xenia adalah mobil keluarga jenis Multi Purpose Vehicle (MPV) 7-penumpang yang diproduksi oleh Astra Daihatsu Motor sejak 2004. Mobil ini terkenal irit bahan bakar, memiliki kabin luas, harga terjangkau, serta menggunakan sistem penggerak roda depan (FWD) dan mesin 1.3L hingga 1.5L Dual VVT-i.",
                R.drawable.xenia,
                "PETROL"
            ),
            Mobil(
                9,
                "Toyota Yaris",
                "Manual",
                "2014",
                "34,000 km",
                "Rp 140.000.000",
                "Mojokerto",
                "Toyota Yaris adalah mobil hatchback perkotaan populer dengan desain sporty, stylish, dan dinamis. Kendaraan kompak ini dibekali mesin In-line 4 silinder 1.500 cc berteknologi Dual VVT-i yang responsif dan efisien, sehingga lincah untuk bermanuver di area perkotaan yang padat. Toyota Yaris adalah mobil jenis hatchback kompak buatan Toyota yang dirancang untuk perkotaan. Pertama kali rilis tahun 1999, mobil ini terkenal lincah, irit bahan bakar, dan berdesain sporty. Di Indonesia, Yaris dibekali mesin 1.496 cc Dual VVT-i yang bertenaga serta fitur keselamatan modern. Toyota Yaris adalah mobil jenis hatchback 5-penumpang produksi Toyota. Mobil ini memiliki desain sporty, ukuran kompak, mesin bensin 1.496 cc yang bertenaga dan irit bahan bakar, serta lincah untuk bermanuver di jalanan perkotaan yang padat.. Toyota Yaris adalah mobil jenis hatchback 5-penumpang produksi Toyota. Mobil ini memiliki desain sporty, ukuran kompak, mesin bensin 1.496 cc yang bertenaga dan irit bahan bakar, serta lincah untuk bermanuver di jalanan perkotaan yang padat.",
                R.drawable.yaris,
                "PETROL"
            ),
            Mobil(
                10,
                "Toyota Yaris Cross Hybrid",
                "Auto",
                "2018",
                "25,000 km",
                "Rp 260.000.000",
                "Surabaya",
                "Toyota Yaris Cross adalah SUV kompak 5-penumpang yang menggabungkan desain gagah, kabin lapang, dan fitur modern. Mobil ini adalah hybrid yang irit bahan bakar. Toyota Yaris Cross Hybrid adalah mobil SUV compact 5-penumpang yang menggabungkan mesin bensin 1.500 cc dengan motor listrik dan transmisi CVT. Mobil ini menawarkan konsumsi bahan bakar yang sangat irit, emisi rendah, kabin modern, serta fitur keselamatan lengkap khas Toyota Indonesia. Toyota Yaris Cross Hybrid adalah mobil SUV compact 5-penumpang yang menggabungkan mesin bensin 1.500 cc dengan motor listrik dan transmisi CVT. Mobil ini menawarkan konsumsi bahan bakar yang sangat irit, emisi rendah, kabin modern, serta fitur keselamatan lengkap khas Toyota Indonesia. Toyota Yaris Cross Hybrid adalah mobil SUV compact 5-penumpang yang menggabungkan mesin bensin 1.500 cc dengan motor listrik dan transmisi CVT. Mobil ini menawarkan konsumsi bahan bakar yang sangat irit, emisi rendah, kabin modern, serta fitur keselamatan lengkap khas Toyota Indonesia.",
                R.drawable.yariscross,
                "HYBRID"
            )
        )
    };
    var selectedCarId by remember { mutableStateOf<Int?>(null) };
    val favourite = remember { mutableStateMapOf<Int, Boolean>() };
    val mobil = daftarMobil.find { it.id == selectedCarId };
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
    ) {
        if (mobil == null) LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                Column(modifier = Modifier.padding(top = 18.dp)) {
                    Box(
                        modifier = Modifier
                            .width(30.dp)
                            .height(6.dp)
                            .background(Color(0xFFFF6B54), RoundedCornerShape(2.dp))
                    );
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 13.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                "On Sale",
                                fontSize = 23.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1A1D26)
                            ); Text("Find your perfect ride", fontSize = 15.sp, color = Color.Gray)
                        }; Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFECEB)),
                        contentPadding = PaddingValues(horizontal = 13.dp, vertical = 5.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Icon(
                            Icons.Filled.Favorite,
                            null,
                            tint = Color(0xFFFF6B54),
                            modifier = Modifier.size(14.dp)
                        ); Text(
                        " ${favourite.values.count { it }} saved",
                        color = Color(0xFFFF6B54),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                    }
                    }
                }
            }; items(daftarMobil) { item ->
            CardMobilItem(
                item,
                favourite[item.id] ?: false,
                { favourite[item.id] = !(favourite[item.id] ?: false) },
                { selectedCarId = item.id })
        }; item { Spacer(modifier = Modifier.height(15.dp)) }
        } else HalamanDetailMobil(
            mobil,
            favourite[mobil.id] ?: false,
            { favourite[mobil.id] = !(favourite[mobil.id] ?: false) },
            { selectedCarId = null })
    }
}

@Composable
fun CardMobilItem(mobil: Mobil, isFavourite: Boolean, onFav: () -> Unit, onClick: () -> Unit) =
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(modifier = Modifier.padding(13.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(88.dp)) {
                Image(
                    painter = painterResource(mobil.gambar),
                    null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(14.dp)),
                    contentScale = ContentScale.Crop
                ); LabelKategori(
                mobil.kategori,
                Modifier
                    .align(Alignment.BottomStart)
                    .padding(5.dp)
            )
            }; Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 13.dp)
        ) {
            Text(
                mobil.nama,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color(0xFF1A1D26)
            ); Box(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .background(Color(0xFFF3F4F6), RoundedCornerShape(5.dp))
                .padding(horizontal = 6.dp, vertical = 3.dp)
        ) {
            Text(
                mobil.jenis,
                fontSize = 11.sp,
                color = Color.Gray
            )
        }; Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "● ",
                fontSize = 13.sp,
                color = Color(0xFFFF6B54)
            ); Text(
            text = "${mobil.tahun}",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        ); Text(text = mobil.km, fontSize = 12.sp, color = Color.Gray)
        }
        }; IconButton(onClick = onFav) {
            Icon(
                if (isFavourite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                null,
                tint = if (isFavourite) Color(0xFFFF6B54) else Color(0xFFD1D5DB)
            )
        }
        }
    }

@Composable
fun HalamanDetailMobil(mobil: Mobil, isFavourite: Boolean, onFav: () -> Unit, onBack: () -> Unit) =
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 80.dp)
        ) {
            Box {
                Image(
                    painter = painterResource(mobil.gambar),
                    null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                ); IconButton(
                onClick = onBack,
                modifier = Modifier
                    .padding(15.dp)
                    .background(Color.White, RoundedCornerShape(18.dp))
                    .size(35.dp)
            ) {
                Icon(
                    Icons.Filled.ArrowBack,
                    null,
                    tint = Color.Black,
                    modifier = Modifier.size(20.dp)
                )
            }; LabelKategori(
                mobil.kategori,
                Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp),
                true
            )
            }; Column(
            modifier = Modifier
                .offset(y = (-17).dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 23.dp, topEnd = 23.dp))
                .background(Color.White)
                .padding(15.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        mobil.nama,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A1D26)
                    ); Row(
                    modifier = Modifier.padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "● ",
                        fontSize = 13.sp,
                        color = Color(0xFFFF6B54)
                    ); Text(text = mobil.lokasi, fontSize = 13.sp)
                }
                }; IconButton(onClick = onFav) {
                Icon(
                    if (isFavourite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    null,
                    tint = if (isFavourite) Color(0xFFFF6B54) else Color(0xFFD1D5DB),
                    modifier = Modifier.size(28.dp)
                )
            }
            }; Box(
            modifier = Modifier
                .background(Color(0xFFFFECEB), RoundedCornerShape(6.dp))
                .padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
            Text(
                mobil.harga,
                color = Color(0xFFFF6B54),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }; Text(
            "Spesifikasi",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            modifier = Modifier.padding(top = 22.dp, bottom = 7.dp)
        ); Row(horizontalArrangement = Arrangement.spacedBy(13.dp)) {
            InfoBox(
                "Tahun",
                mobil.tahun,
                Modifier
                    .weight(1f)
                    .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(6.dp))
            ); InfoBox(
            "Jarak Tempuh",
            mobil.km,
            Modifier
                .weight(1f)
                .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(6.dp))
        )
        }; Spacer(modifier = Modifier.height(12.dp)); Row(
            horizontalArrangement = Arrangement.spacedBy(
                12.dp
            )
        ) {
            InfoBox(
                "Transmisi",
                mobil.jenis,
                Modifier
                    .weight(1f)
                    .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(6.dp))
            ); InfoBox(
            "Jenis Bahan Bakar",
            mobil.kategori,
            Modifier
                .weight(1f)
                .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(6.dp))
        )
        }; Text(
            "Tentang mobil ini",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            modifier = Modifier.padding(top = 24.dp)
        ); Text(
            mobil.deskripsi,
            fontSize = 14.sp,
            color = Color(0xFF4B5563),
            modifier = Modifier.padding(top = 6.dp)
        )
        }
        }; Surface(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth(),
        color = Color.White
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = onFav,
                modifier = Modifier
                    .background(Color(0xFFFFFFFF), RoundedCornerShape(8.dp))
                    .size(48.dp)
                    .border(
                        width = 1.5.dp,
                        color = if (isFavourite) Color(0xFFFF6B54) else Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Icon(
                    if (isFavourite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    null,
                    tint = if (isFavourite) Color(0xFFFF6B54) else Color.Gray
                )
            }; Button(
            onClick = {},
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6B54)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                "Contact Seller",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
        }
    }
    }

@Composable
fun LabelKategori(kategori: String, modifier: Modifier = Modifier, isDetail: Boolean = false) {
    val (bg, teks) = when (kategori) {
        "EV" -> Color(0xFFF1EEFF) to Color(0xFF6B4EFF); "HYBRID" -> Color(0xFFE6F9F5) to Color(
            0xFF1ABC9C
        )

        else -> Color(0xFFFFF2E6) to Color(0xFFE67E22)
    }; Box(
        modifier = modifier
            .background(bg, RoundedCornerShape(4.dp))
            .padding(
                horizontal = if (isDetail) 10.dp else 6.dp,
                vertical = if (isDetail) 4.dp else 2.dp
            )
    ) {
        Text(
            kategori,
            fontSize = if (isDetail) 11.sp else 9.sp,
            fontWeight = FontWeight.Bold,
            color = teks
        )
    }
}

@Composable
fun InfoBox(label: String, value: String, modifier: Modifier = Modifier) =
    Box(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(7.dp))
            .padding(12.dp)
    ) {
        Column {
            Text(label, fontSize = 11.sp, color = Color.Gray); Text(
            value,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A1D26),
            fontSize = 14.sp
        )
        }
    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal1Preview() {
    Soal1()
}