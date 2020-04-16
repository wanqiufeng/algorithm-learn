package com.vincent.algorithm.basic.btree;

/**支付宝面试题
 * Created by chenjun on 2020-04-15 21:25
 */
public class IpServiceImpl implements IpService{
    private IpPool ipPool;

    @Override
    public boolean isInList(String ip) {
        return ipPool.get(ipToLong(ip));
    }

    private IpServiceImpl() {
        ipPool = new IpPool();
        ipPool.set(ipToLong("192.168.1.1"));
    }


    public long ipToLong(String ip) {
        long ret = 0;
        String[] ipStrArr = ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            ret <<= 8;
            ret += Long.valueOf(ipStrArr[i]);
        }
        return ret;
    }



    public class IpPool {
        private volatile long[] words;

        public IpPool() {
            words = new long[1 << 26];
        }

        public void set(long bitIndex) {
            int arrIndex = (int)(bitIndex >> 6);
            words[arrIndex] |= (1L << bitIndex);
        }

        public boolean get(long bitIndex) {
            int arrIndex = (int)(bitIndex >> 6);
            return (words[arrIndex] & (1L << bitIndex)) != 0;
        }
    }

    public static void main(String[] args) {
        IpServiceImpl ipService = new IpServiceImpl();
        boolean inListFlag1 = ipService.isInList("192.168.1.1");
        boolean inListFLag2 = ipService.isInList("192.168.1.2");
        boolean inListFLag3 = ipService.isInList("192.168.3.2");
        System.out.println(inListFlag1);
        System.out.println(inListFLag2);


        System.out.println(1L<<3);
    }
}
