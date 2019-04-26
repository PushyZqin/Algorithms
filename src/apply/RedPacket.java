package site.pushy.algorithms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Pushy
 * @since 2019/3/30 9:35
 */
public class RedPacket {

    /**
     * 将传入的总金额和分配红包的总人数将红包分配总人数的份数
     * @param totalMoney
     * @param totalPeopleNum
     */
    public List<Integer> divideRedPacket(Integer totalMoney, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        Integer restMoney = totalMoney;
        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random();

        for (int i = 0; i < totalPeopleNum - 1; i++) {
            // 通过二倍均值法计算出每个人的红包金额数，能保证分到金额的概率是相同的
            int amount = random.nextInt(restMoney / restPeopleNum * 2 - 1) + 1;
            restMoney -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restMoney);
        return amountList;
    }

    public static void main(String[] args) {
        RedPacket redPacket = new RedPacket();
        List<Integer> amountList = redPacket.divideRedPacket(1000, 5);
        for (Integer amount : amountList) {
            System.out.println(new BigDecimal(amount).divide(new BigDecimal(100)));
        }
    }

}
