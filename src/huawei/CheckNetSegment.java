package huawei;

public class CheckNetSegment {

    /**
     * @param mask 子网掩码
     * @param ip1  IP地址1
     * @param ip2  IP地址2
     * @return IP1与IP2 属于同一个子网返回0，不属于同一个子网返回2，地址不合法返回1
     */
    public int checkNetSegment(String mask, String ip1, String ip2) {
        mask = getMask(mask);
        boolean isValid = checkValid(mask) && checkValid(ip1) && checkValid(ip2);
        if (!isValid) {
            return 1;
        } else {
            String[] maskSeg = mask.split("\\.");
            String[] ip1Seg = ip1.split("\\.");
            String[] ip2Seg = ip2.split("\\.");
            for (int i = 0; i < 4; i++) {
                if ((Integer.parseInt(maskSeg[i]) & Integer.parseInt(ip1Seg[i]))
                        != (Integer.parseInt(maskSeg[i]) & Integer.parseInt(ip2Seg[i]))) {
                    return 2;
                }
            }
            return 0;
        }
    }

    // 检测是否合法
    private boolean checkValid(String ip) {

        if (ip.contains(".")) {
            String[] segment = ip.split("\\.");
            if (segment.length != 4) {
                return false;
            } else {
                for (int i = 0; i < 4; i++) {
                    if (Integer.parseInt(segment[i]) > 255 || Integer.parseInt(segment[i]) < 0) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    // 子网掩码补0
    private String getMask(String mask) {
        String[] maskSeg = mask.split("\\.");
        StringBuilder sb = new StringBuilder();
        int length = maskSeg.length;
        if (length == 4) {
            return mask;
        } else {
            sb.append(mask);
            for (int i = 0; i < 4 - length; i++) {
                sb.append(".0");
            }
        }
        return sb.toString();
    }
}
