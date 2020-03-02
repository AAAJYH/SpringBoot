package com.jyh.斗地主;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Comparator;

/**
 * @author jyh
 * @date 2019/12/3
 * @description
 */

@Data
@AllArgsConstructor
public class Card{

    private String card;

    private Integer brandValue;

    @Override
    public String toString() {
        return card ;
    }

}
