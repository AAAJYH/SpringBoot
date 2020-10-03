package com.jyh.algorithm;

import com.jyh.base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author jyh
 * @version 1.0
 * @date 2020/6/1
 */
public class Array extends BaseTest {

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    @Test
    public void one() {
        int a[] = {1, 1, 1, 2, 3, 4, 4, 5, 5, 5, 6};

        int length = removeDuplicates(a);

        Assert.assertTrue(true);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return i + 1;
    }

}
