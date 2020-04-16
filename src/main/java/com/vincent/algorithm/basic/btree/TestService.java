package com.vincent.algorithm.basic.btree;

/**
 * Created by chenjun on 2020-04-15 21:09
 */
class BitMapIpList implements IpService{
    private IpSet ipSet = null;

    public static void main(String[] args) {
        BitMapIpList bitMapIpList = new BitMapIpList();
        System.out.println(bitMapIpList.ipToLong("192.168.1.1"));
    }
    public BitMapIpList() {
        ipSet = new IpSet();
        ipSet.set(ipToLong("192.168.1.1")); // 1100 0000 . 1010 1000 . 0000 0001 . 0000 0001
    }

    @Override
    public boolean isInList(String ip) {
        return ipSet.get(ipToLong(ip));
    }

    /**
     * 将字符串形式的ip地址转换为整数
     * 由于int会出现负数，所以返回long
     * @param ip
     * @return
     */
    public long ipToLong(String ip) {
        long ret = 0;
        String[] ipStrArr = ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            ret <<= 8;
            ret += Long.valueOf(ipStrArr[i]);
        }
        return ret;
    }

    private class IpSet {
        /**
         * 一共有2^32个ip地址，即需要2^32个bit来保存，
         * 那么我们一共需要(2^32)/64 == 2^26个long来保存。
         */
        private long[] words;

        public IpSet() {
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
}
