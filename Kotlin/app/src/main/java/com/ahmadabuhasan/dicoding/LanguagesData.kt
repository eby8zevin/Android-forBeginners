package com.ahmadabuhasan.dicoding

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
        "JavaScript is a high-level programming language that is one of the core technologies of the World Wide Web. It is used as a client-side programming language by 97.8 percent of all websites. JavaScript was originally used only to develop web browsers, but they are now used for server-side website deployments and non-web browser applications as well.\n" +
                "Javascript was created in 1995 and was initially known as LiveScript. However, Java was a very popular language at that time, so it was advertised as a “younger brother” of Java. As it evolved over time, JavaScript became a fully independent language. Nowadays, JavaScript is often confused with Java, and although there are some similarities between them, the two languages are distinct.\n" +
                "Javascript is the most popular programming language in the world and is in high demand among various organizations. The average Java developer earns around \$112,152 each year.",
        "Python is one of the most popular programming languages today and is easy for beginners to learn because of its readability. It is a free, open-source programming language with extensive support modules and community development, easy integration with web services, user-friendly data structures, and GUI-based desktop applications. It is a popular programming language for machine learning and deep learning applications.\n" +
                "Python is used to develop 2D imaging and 3D animation packages like Blender, Inkscape, and Autodesk. It has also been used to create popular video games, including Civilization IV, Vegas Trike, and Toontown. Python is used for scientific and computational applications like FreeCAD and Abacus and by popular websites like YouTube, Quora, Pinterest, and Instagram. Python developers earn average annual salaries of about \$109,092.",
        "Go was developed by Google in 2007 for APIs and web applications. Go has recently become one of the fastest-growing programming languages due to its simplicity, as well as its ability to handle multicore and networked systems and massive codebases.\n" +
                "Go, also known as Golang, was created to meet the needs of programmers working on large projects. It has gained popularity among many large IT companies thanks to its simple and modern structure and syntax familiarity. Companies using Go as their programming language include Google, Uber, Twitch, Dropbox, among many others. Go is also gaining in popularity among data scientists because of its agility and performance.\n" +
                "Go developers can earn an average annual salary of \$141,654, and hitting up to \$261,000.",
        "Java is one of the most popular programming languages used today. \n" +
                "Owned by Oracle Corporation, this general-purpose programming language with its object-oriented structure has become a standard for applications that can be used regardless of platform (e.g., Mac, Windows, Android, iOS, etc.) because of its Write Once, Run Anywhere (WORA) capabilities. As a result, Java is recognized for its portability across platforms, from mainframe data centers to smartphones. Today there are more than 3 billion devices running applications built with Java.\n" +
                "Java is widely used in web and application development as well as big data. Java is also used on the backend of several popular websites, including Google, Amazon, Twitter, and YouTube. It is also extensively used in hundreds of applications. New Java frameworks like Spring, Struts, and Hibernate are also very popular. With millions of Java developers worldwide, there are hundreds of ways to learn Java. Also, Java programmers have an extensive online community and support each other to solve problems.\n" +
                "Java is a more complex language to learn, but experienced developers with Java coding skills are in high demand. The average Java developer earns around \$109,225 each year.",
        "Kotlin is a general-purpose programming language originally developed and unveiled as Project Kotlin by JetBrains in 2011. The first version was officially released in 2016. It is interoperable with Java and supports functional programming languages.\n" +
                "Kotlin is used extensively for Android apps, web application, desktop application, and server-side application development. Kotlin was built to be better than Java, and people who use this language are convinced. Most of the Google applications are based on Kotlin. Some companies using Kotlin as their programming language include Coursera, Pinterest, PostMates among many others.\n" +
                "Kotlin developers earn an average of \$136,000 a year, with the potential to earn up to \$171,500.",
        "PHP is an open-source programming language created in 1990. Many web developers find it essential to learn PHP, as this language is used to build more than 80% of websites on the Internet, including notable sites like Facebook and Yahoo.\n" +
                "Programmers mainly use PHP mainly to write server-side scripts. But developers can also use this language to write command-line scripts, and programmers with high-level PHP coding skills can also use it to develop desktop applications. \n" +
                "PHP is considered a relatively easy language to learn for beginning developers. PHP professionals have access to several dedicated online communities, making it easy to get support and answers to questions.\n" +
                "On average, PHP programmers earn average annual salaries of about \$107,409.",
        "Developed by Microsoft, C# rose to fame in the 2000s for supporting the concepts of object-oriented programming. It is one of the most used programming languages for the .NET framework. Anders Hejlsberg, the creator of C#, says the language is more like C++ than Java.\n" +
                "C# is best suited for applications on Windows, Android, and iOS, as it takes the help of the integrated development environment product, Microsoft Visual C++. C# is used on the back end of several popular websites like Bing, Dell, Visual Studio, and MarketWatch. C# developers earn around \$111,760 per year.",
        "A few years ago, Swift made the top 10 in the monthly TIOBE Index ranking of popular programming languages. Apple developed Swift in 2014 for Linux and Mac applications. \n" +
                "An open-source programming language that is easy to learn, Swift supports almost everything from the programming language Objective-C. Swift requires fewer coding skills compared with other programming languages, and it can be used with IBM Swift Sandbox and IBM Bluemix. Swift is used in popular iOS apps like WordPress, Mozilla Firefox, SoundCloud, and even in the game Flappy Bird. Professionals who develop iOS applications take home average annual salaries of around \$106,652.",
        "R is an open-source language that is essentially a different version of the S language. Much of the code that developers write for S runs on R without modification.\n" +
                "Applications built in R are used for processing statistics, including linear and nonlinear modeling, calculation, testing, visualization, and analysis. Applications coded using R can interface with a number of databases and process both structured and unstructured data.\n" +
                "R has a moderate learning curve and is not as easy for beginners to pick up as some other languages in this article. However, like other open-source programming languages, R boasts an active online community of developers, which is always a plus when learning new coding skills.\n" +
                "On average, R developers earn average annual salaries of about \$90,940.",
        "If you want to start with a language that is known for being relatively simple to learn, consider Ruby. Developed in the 1990s, it was designed to have a more human-friendly syntax while still being flexible from the standpoint of its object-oriented architecture that supports procedural and functional programming notation. A web-application framework that is implemented in Ruby is Ruby on Rails (“RoR”). Ruby developers tout it for being an easy language to write in and also for the relatively short learning time required. These attributes have led to a large community of Ruby developers and a growing interest in the language among beginning developers. The average salary for a Ruby developer is around \$121,000 per year.",
        "C is probably the oldest and popular programming language and is the root of other programming languages such as C#, Java, and JavaScript. C++ is an enhanced version of C. Many developers today skip learning C on its own, while others think learning C first provides a valuable foundation for C++ development. Both languages are widely used in computer science and programming. ",
        "C and C++ developers can make use of compilers for a wide variety of platforms, making applications developed in these languages largely transportable. Both C and C++ are considered high-performance languages. As such, they are widely used in developing applications where performance is a critical issue, such as client/server applications, commercial products like Firefox and Adobe, and video games. C and C++ developers earn an average of \$118,366 each year.",
        "Matlab is a proprietary programming language owned by MathWorks and originally released in the mid-1980s. It is built specifically for use by scientists and engineers.\n" +
                "Programmers use Matlab to build machine learning and deep learning applications. Matlab-based programs enable users to analyze data, create algorithms, process images, and verify research.\n" +
                "Generally, Matlab is easier to learn than other programming languages on our list. MathWorks’ website has an extensive section dedicated to answering questions about Matlab.\n" +
                "The average Matlab developer takes home an average salary of \$100,760 each year.",
        "TypeScript is a newcomer to top programming language lists, but it’s making headway. It was developed in 2012 by Microsoft and is a typed version of JavaScript that is well suited for large code bases. TypeScript is used to create JavaScript-based projects with typing in both client-side and server-side development, making useful for catching errors and preventing systemic issues.\n" +
                "TypeScript was named “most adopted tech” in the 2021 State of JavaScript Survey. TypeScript developers typically earn an annual average of \$75,199.",
        "Scala is a general-purpose, type-safe Java virtual machine language that combines the best oop and functional programming languages into one special high language. Scala is ideal for reducing and removing bugs in large, complex applications. It supports both object-oriented and functional programming.\n" +
                "Programmers can use Scala for any task that they normally would use Java for. Scala is a complex language, but that complexity gives it a lot of flexibility. Companies that use Scala include Netflix, Twitter, and the New York Times.\n" +
                "Scala developers earn a yearly average of \$127,005."
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
                language.image = languageImages[position]
                list.add(language)
            }
            return list
        }
}