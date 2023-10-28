package com.ahmadabuhasan.myrecyclerview;

import java.util.ArrayList;

public class CoinData {

    private static String[] coinNames = {
            "Bitcoin",
            "Ethereum",
            "Litecoin",
            "Dash",
            "Dogecoin",
            "Ripple",
            "Ethereum Classic",
            "Monero",
            "Waves",
            "ZCash",
    };

    private static String[] coinDetails = {
            "Bitcoin is the world’s most-traded cryptocurrency which represents a massive share of the cryptocurrency market. It was the first cryptocurrency that was introduced to the public and has therefore the most developed infrastructure. It is often considered to be a trendsetter in the cryptocurrency world. Bitcoin essentially created an alternative asset class and can be used in portfolio hedging strategies especially during the turbulent markets.",
            "Ethereum is a platform for creating decentralized applications based on the blockchain and smart contract technology. A smart contract automatically enforces the terms of the agreement based on a given algorithm. The cryptocurrency is listed under the symbol ETH and is used to pay for various fees and costs on the Ethereum network.",
            "Litecoin is a fork of bitcoin. It’s a spin-off with several technical improvements such as faster payment facilitation compared to bitcoin. Litecoin is one of the first altcoins (alternative coins) that was used to substitute bitcoin. There is a significant price correlation between the 2 cryptocurrencies.",
            "Dash is a cryptocurrency that was originally named XCoin in January 2014. It was renamed to Darkcoin a little later but eventually, the project got the name Dash. This digital currency should not be confused with dashcoin. The ticker symbol of this cryptocurrency is DASH which matches its name while dashcoin's ticker symbol is DSH.",
            "Dogecoin (DOGE) is based on the popular \"doge\" Internet meme and features a Shiba Inu on its logo. The open-source digital currency was created by Billy Markus from Portland, Oregon and Jackson Palmer from Sydney, Australia, and was forked from Litecoin in December 2013. Dogecoin's creators envisaged it as a fun, light-hearted cryptocurrency that would have greater appeal beyond the core Bitcoin audience, since it was based on a dog meme. Tesla CEO Elon Musk posted several tweets on social media that Dogecoin is his favorite coin.",
            "The Ripple project combines a remittance network and currency exchange. The project is based on a system that allows all kinds of financial operations. It can be viewed as a decentralized exchange office that uses a consensus process. Trusted networks and gateways allow the system to handle the exchange of almost any asset and eliminate the need of conversion.",
            "Ethereum classic (ETC) is the initial version of ethereum. The cryptocurrency was created and supported by enthusiasts after the fork of the main version. The error in smart contracts that were created for Ethereum DAO (decentralized crowdfunding platform) led to the loss of about 60 million US dollars. In this version the cryptocurrency has followed its initial philosophy which is based on the logic that there will be no external interference into smart contracts and the way they function. This project is not supported by the main team of developers.",
            "Monero is the most popular digital currency of darknet and ensures a high level of anonymity with regards to transactions. It uses obfuscation techniques based on the algorithm that adds codes to each transaction. This technology makes it impossible to prove the involvement of a certain user even when the information is being intercepted and decoded. The downside of this technology is an increased complexity with regards to mining and computing power.",
            "Waves Platform’s mission lies in creating an ecosystem that aims to accelerate the shift from centralized to decentralized systems and an emphasis on the individual’s control of their own funds and assets, personal data, and privacy. Waves Platform describes itself as an open network for Web 3.0 applications and custom decentralized solutions, with a range of purpose-designed tools for making the process of developing and running dApps easy and accessible. Launched in 2016, Waves has since released several blockchain-based solutions. Waves’ technology is designed to address the needs of developers and companies that want to leverage the properties of blockchain systems – including their security, auditability, verifiability and the trustless execution of transactions and business logic.",
            "ZCash is a new cryptocurrency that is based on the idea of complete anonymity with regards to transaction details. It is based on a zero-knowledge protocol which is used to validate the transactions. The algorithm ensures that one party can prove to another party that the statement is true without transmitting information about the proof itself."
    };

    private static int[] coinImages = {
            R.drawable.btc,
            R.drawable.eth,
            R.drawable.ltc,
            R.drawable.dash,
            R.drawable.doge,
            R.drawable.xrp,
            R.drawable.etc,
            R.drawable.xmr,
            R.drawable.waves,
            R.drawable.zec
    };

    static ArrayList<CoinActivity> getListData() {
        ArrayList<CoinActivity> list = new ArrayList<>();
        for (int position = 0; position < coinNames.length; position++) {
            CoinActivity coin = new CoinActivity();
            coin.setName(coinNames[position]);
            coin.setDetail(coinDetails[position]);
            coin.setPhoto(coinImages[position]);
            list.add(coin);
        }
        return list;
    }
}
