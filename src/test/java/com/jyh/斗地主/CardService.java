package com.jyh.斗地主;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jyh
 * @date 2019/12/3
 * @description
 */

public class CardService {

    /**
     * 地主牌
     */
    private Card[] landlordBrand;

    private final String[] flowerColors = {"♠", "♥","♣", "♦"};
    private Map<String, Integer> brands;
    {
        brands = new HashMap<>();
        brands.put("2", 15);
        brands.put("A", 14);
        brands.put("K", 13);
        brands.put("Q", 12);
        brands.put("J", 11);
        brands.put("10", 10);
        brands.put("9", 9);
        brands.put("8", 8);
        brands.put("7", 7);
        brands.put("6", 6);
        brands.put("5", 5);
        brands.put("4", 4);
        brands.put("3", 3);
    }

    /**
     * 创建牌
     * @return 集合
     */
    public List<Card> createCard() {
        List<Card> cardList = new ArrayList<>();
        Card bigCard = new Card("大王", 17);
        Card smallCard = new Card("小王", 16);
        cardList.add(bigCard);
        cardList.add(smallCard);

        for (String key : brands.keySet()) {
            for (String flowerColor : flowerColors) {
                cardList.add(new Card(flowerColor + key, brands.get(key)));
            }
        }

        return cardList;
    }

    /**
     * 发牌
     * @param cardList 牌集合
     * @return
     */
    public Map<String, List<Card>> deal(List<Card> cardList) {
        //打乱顺序
        Collections.shuffle(cardList);
        Collections.shuffle(cardList);

        //地主牌
        landlordBrand = new Card[]{cardList.get(51), cardList.get(52), cardList.get(53)};

        Map<String, List<Card>> resultMap = new HashMap<>();

        List<Card> gameOne = new ArrayList<>();
        List<Card> gameTwo = new ArrayList<>();
        List<Card> gameThree = new ArrayList<>();

        int count = 1;
        for(Card card : cardList) {
            if (count < 52) {
                if (count % 3 == 1) {
                    gameOne.add(card);
                }else if (count % 3 == 2) {
                    gameTwo.add(card);
                }else if (count % 3 == 0) {
                    gameThree.add(card);
                }
            }
            ++count;
        };

        //倒序发牌
        gameOne.sort((a, b) -> -(a.getBrandValue() - b.getBrandValue()));
        gameTwo.sort((a, b) -> -(a.getBrandValue() - b.getBrandValue()));
        gameThree.sort((a, b) -> -(a.getBrandValue() - b.getBrandValue()));

        resultMap.put("玩家一", gameOne);
        resultMap.put("玩家二", gameTwo);
        resultMap.put("玩家三", gameThree);
        return resultMap;
    }

    /**
     * 获取地主牌
     * @return
     */
    public Card[] getLandlordBrand() {
        return this.landlordBrand;
    }

}
