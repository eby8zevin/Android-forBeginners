package com.ahmadabuhasan.dicoding.data

import com.ahmadabuhasan.dicoding.R
import com.ahmadabuhasan.dicoding.model.Language

object LanguagesData {

    private val languageNames = arrayOf(
        "JavaScript",
        "Python",
        "Go",
        "Java",
        "Kotlin",
        "PHP",
        "C#",
        "Swift",
        "R",
        "Ruby",
        "C",
        "C++",
        "Matlab",
        "TypeScript",
        "Scala"
    )

    private val languageDetails = arrayOf(
        "JavaScript adalah bahasa pemrograman tingkat tinggi yang merupakan salah satu teknologi inti dari World Wide Web. Ini digunakan sebagai bahasa pemrograman sisi klien oleh 97,8 persen dari semua situs web. JavaScript pada awalnya hanya digunakan untuk mengembangkan browser web, tetapi sekarang digunakan untuk penerapan situs web sisi server dan juga aplikasi browser non-web.",
        "Python adalah salah satu bahasa pemrograman yang paling populer saat ini dan mudah dipelajari oleh pemula karena keterbacaannya. Ini adalah bahasa pemrograman sumber terbuka gratis dengan modul dukungan ekstensif dan pengembangan komunitas, integrasi yang mudah dengan layanan web, struktur data yang mudah digunakan, dan aplikasi desktop berbasis GUI. Ini adalah bahasa pemrograman populer untuk machine learning dan aplikasi deep learning.",
        "Go dikembangkan oleh Google pada tahun 2007 untuk API dan aplikasi web. Go baru-baru ini menjadi salah satu bahasa pemrograman yang tumbuh paling cepat karena kesederhanaannya, serta kemampuannya untuk menangani sistem multicore dan jaringan serta basis kode yang masif.",
        "Java adalah salah satu bahasa pemrograman yang paling populer digunakan saat ini.\n" +
                "\n" +
                "Dimiliki oleh Oracle Corporation, bahasa pemrograman tujuan umum dengan struktur berorientasi objek ini telah menjadi standar untuk aplikasi yang dapat digunakan terlepas dari platform (misalnya, Mac, Windows, Android, iOS, dll.) karena Write Once, Jalankan kemampuan di mana saja (WORA). Akibatnya, Java dikenal karena portabilitasnya di seluruh platform, dari pusat data mainframe hingga smartphone. Saat ini ada lebih dari 3 miliar perangkat yang menjalankan aplikasi yang dibangun dengan Java.",
        "Kotlin adalah bahasa pemrograman tujuan umum yang awalnya dikembangkan dan diresmikan sebagai Project Kotlin oleh JetBrains pada tahun 2011. Versi pertama secara resmi dirilis pada tahun 2016. Ini dapat dioperasikan dengan Java dan mendukung bahasa pemrograman fungsional.",
        "PHP adalah bahasa pemrograman open-source yang dibuat pada tahun 1990. Banyak pengembang web merasa penting untuk mempelajari PHP, karena bahasa ini digunakan untuk membangun lebih dari 80% situs web di Internet, termasuk situs terkenal seperti Facebook dan Yahoo.",
        "Dikembangkan oleh Microsoft, C# menjadi terkenal di tahun 2000-an karena mendukung konsep pemrograman berorientasi objek. Ini adalah salah satu bahasa pemrograman yang paling banyak digunakan untuk kerangka .NET. Anders Hejlsberg, pencipta C#, mengatakan bahasa ini lebih mirip C++ daripada Java.",
        "Bahasa pemrograman open-source yang mudah dipelajari, Swift mendukung hampir semua hal mulai dari bahasa pemrograman Objective-C. Swift membutuhkan lebih sedikit keterampilan pengkodean dibandingkan dengan bahasa pemrograman lain, dan dapat digunakan dengan IBM Swift Sandbox dan IBM Bluemix. Swift digunakan di aplikasi iOS populer seperti WordPress, Mozilla Firefox, SoundCloud, dan bahkan di game Flappy Bird.",
        "R adalah bahasa open-source yang pada dasarnya merupakan versi berbeda dari bahasa S. Sebagian besar kode yang ditulis pengembang untuk S berjalan di R tanpa modifikasi.",
        "Jika Anda ingin memulai dengan bahasa yang dikenal relatif mudah dipelajari, pertimbangkan Ruby. Dikembangkan pada 1990-an, ia dirancang untuk memiliki sintaks yang lebih ramah manusia sambil tetap fleksibel dari sudut pandang arsitektur berorientasi objek yang mendukung notasi pemrograman prosedural dan fungsional. Kerangka kerja aplikasi web yang diimplementasikan di Ruby adalah Ruby on Rails (“RoR”).",
        "C mungkin adalah bahasa pemrograman tertua dan populer dan merupakan akar dari bahasa pemrograman lain seperti C#, Java, dan JavaScript. C++ adalah versi C yang disempurnakan. Banyak pengembang saat ini mengabaikan pembelajaran C sendiri, sementara yang lain berpikir bahwa belajar C terlebih dahulu memberikan dasar yang berharga untuk pengembangan C++. Kedua bahasa tersebut banyak digunakan dalam ilmu komputer dan pemrograman.",
        "Pengembang C dan C++ dapat menggunakan kompiler untuk berbagai platform, membuat aplikasi yang dikembangkan dalam bahasa ini sebagian besar dapat dipindahkan. Baik C dan C++ dianggap sebagai bahasa berkinerja tinggi. Dengan demikian, mereka banyak digunakan dalam mengembangkan aplikasi di mana kinerja merupakan masalah kritis, seperti aplikasi klien/server, produk komersial seperti Firefox dan Adobe, dan video game.",
        "Matlab adalah bahasa pemrograman berpemilik yang dimiliki oleh MathWorks dan awalnya dirilis pada pertengahan 1980-an. Itu dibangun khusus untuk digunakan oleh para ilmuwan dan insinyur.",
        "TypeScript adalah pendatang baru dalam daftar bahasa pemrograman teratas, tetapi membuat kemajuan. Ini dikembangkan pada tahun 2012 oleh Microsoft dan merupakan versi JavaScript yang diketik yang sangat cocok untuk basis kode besar. TypeScript digunakan untuk membuat proyek berbasis JavaScript dengan mengetik di pengembangan sisi klien dan sisi server, berguna untuk menangkap kesalahan dan mencegah masalah sistemik.",
        "Scala adalah bahasa mesin virtual Java untuk keperluan umum dan aman yang menggabungkan bahasa pemrograman oop dan fungsional terbaik ke dalam satu bahasa tinggi khusus. Scala sangat ideal untuk mengurangi dan menghapus bug dalam aplikasi yang besar dan kompleks. Ini mendukung pemrograman berorientasi objek dan fungsional."
    )

    private val languageSkills = arrayOf(
        "HTML dan CSS untuk menentukan konten dan tata letak halaman web",
        "Pemecahan masalah, pemikiran abstrak",
        "Mudah dipelajari jika Anda sudah mengetahui setidaknya satu bahasa pemrograman lain; jika tidak, Anda hanya perlu kesabaran dan kemauan untuk belajar.",
        "Pemecahan masalah, pengetahuan tentang struktur berorientasi objek",
        "Pengalaman sebelumnya dengan bahasa pemrograman, khususnya Java",
        "Sederhana jika Anda memiliki latar belakang bahasa pemrograman, tetapi relatif mudah dipelajari untuk pendatang baru",
        "Pemahaman dasar tentang cara menulis kode",
        "Kesediaan untuk meluangkan waktu membaca tutorial (yang tersedia secara luas); tidak diperlukan pengalaman sebelumnya dengan bahasa pemrograman",
        "Lebih mudah jika Anda sudah mengetahui Javascript atau Python, tetapi disarankan untuk orang yang memiliki pemahaman matematika yang kuat",
        "Pemecahan masalah, pemikiran abstrak (kemampuan untuk memvisualisasikan apa yang ingin dilihat pengguna aplikasi)",
        "C – Digunakan untuk mempelajari dasar-dasar pemrograman pada level (hardware) terendah",
        "C++ - memungkinkan \"kontrol\" yang jauh lebih tinggi daripada bahasa lain",
        "Pengetahuan dasar tentang pemrograman direkomendasikan, tetapi tidak diperlukan",
        "Pengetahuan dasar tentang JavaScript diperlukan",
        "Pengetahuan dasar Java, C, C++, atau Python direkomendasikan, tetapi tidak diperlukan"
    )

    private val languageLinks = arrayOf(
        "https://www.javascript.com/",
        "https://www.python.org/",
        "https://go.dev/",
        "https://www.java.com/en/",
        "https://kotlinlang.org/",
        "https://www.php.net/",
        "https://www.w3schools.com/cs/index.php",
        "https://www.swift.com/",
        "https://www.r-project.org/",
        "https://www.ruby-lang.org/en/",
        "https://www.w3schools.com/c/",
        "https://www.w3schools.com/cpp/",
        "https://www.mathworks.com/",
        "https://www.typescriptlang.org/",
        "https://www.scala-lang.org/"
    )

    private val languageImages = intArrayOf(
        R.drawable.icon_javascript,
        R.drawable.icon_python,
        R.drawable.icon_go,
        R.drawable.icon_java,
        R.drawable.icon_kotlin,
        R.drawable.icon_php,
        R.drawable.icon_csharp,
        R.drawable.icon_swift,
        R.drawable.icon_r,
        R.drawable.icon_ruby,
        R.drawable.icon_c,
        R.drawable.icon_cplusplus,
        R.drawable.icon_matlab,
        R.drawable.icon_typescript,
        R.drawable.icon_scala
    )

    val listData: ArrayList<Language>
        get() {
            val list = arrayListOf<Language>()
            for (position in languageNames.indices) {
                val language = Language()
                language.name = languageNames[position]
                language.detail = languageDetails[position]
                language.skill = languageSkills[position]
                language.link = languageLinks[position]
                language.image = languageImages[position]
                list.add(language)
            }
            return list
        }
}