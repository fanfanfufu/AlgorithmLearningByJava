package com.fuqi.year2022.month05;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.regex.Pattern;

/**
 * @author FuQi
 * @date 2022/5/25 21:47
 * @description
 */
public class Solution00468 {

    String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern pattenIPv4 =
            Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

    String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    Pattern pattenIPv6 =
            Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            return (pattenIPv4.matcher(queryIP).matches()) ? "IPv4" : "Neither";
        }
        else if (queryIP.contains(":")) {
            return (pattenIPv6.matcher(queryIP).matches()) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    public String validIPAddress2(String queryIP) {
        try {
            return (InetAddress.getByName(queryIP) instanceof Inet6Address) ? "IPv6" : "IPv4";
        } catch (Exception e) {
            return "Neither";
        }
    }
}
