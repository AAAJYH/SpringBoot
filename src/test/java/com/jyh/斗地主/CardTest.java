package com.jyh.斗地主;

import java.util.List;
import java.util.Map;

/**
 * @author jyh
 * @date 2019/12/3
 * @description
 */

public class CardTest {

    public static void main(String[] args) {
        CardService cardService = new CardService();

        System.out.println("---开始洗牌---");
        List<Card> cardList = cardService.createCard();
        System.out.println(cardList);

        System.out.println("---开始发牌---");
        Map<String, List<Card>> gameMap = cardService.deal(cardList);
        System.out.println(gameMap);

        System.out.println("---地主牌---");
        System.out.println(cardService.getLandlordBrand()[0].getCard() + "," + cardService.getLandlordBrand()[1].getCard()+ "," + cardService.getLandlordBrand()[2].getCard());

    }

}
