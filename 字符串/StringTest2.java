package 字符串;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StringTest2 {
    

    public static void main(String[] args) throws Exception {
        StringTest2 test = new StringTest2();

        System.out.println("ans:"+ test.validIPAddress("192.0.0.1"));
    }

    public String validIPAddress(String queryIP) {
        boolean mayBeIpV4 = validIP4Address(queryIP);
        boolean mayBeIpV6 = validIP6Address(queryIP);

        return mayBeIpV4 ? "IPv4" : (mayBeIpV6 ? "IPv6" : "Neither");
    }

    public boolean validIP4Address(String queryIP) {
        if(queryIP == null || queryIP.isEmpty()){
            return false;
        }

        if(queryIP.endsWith(".")){
            queryIP = queryIP.substring(queryIP.length() - 1, queryIP.length());
        }
        String[] ips = queryIP.split("\\.");
        if(ips.length != 4){
            return false;
        }
        for(String ip : ips){
            int ipLength = ip.length();
            if(ipLength >3 || ipLength == 0){
                return false;
            }
            if(ip.length()!=1 && (ip.charAt(0) - '0'<=0 || ip.charAt(0) - '0' > 9)){
                return false;
            }

            String validIp = "";
            for(int i = 0; i<ipLength; i++){
                if(ip.charAt(i) - '0' < 0 || ip.charAt(i) - '0' >9){
                    return false;
                }
                validIp += ip.charAt(i);
            }
            if(Integer.valueOf(validIp) >255 || Integer.valueOf(validIp)<0){
                return false;
            }

        }
        return true;
    }

    public boolean validIP6Address(String queryIP) {
        if(queryIP == null || queryIP.isEmpty()){
            return false;
        }

        if(queryIP.endsWith(":")){
            queryIP = queryIP.substring(queryIP.length() - 1, queryIP.length());
        }
        String[] ips = queryIP.split(":");
        if(ips.length != 8){
            return false;
        }
        for(String ip : ips){
            int ipLength = ip.length();
            if(ipLength > 4 || ipLength == 0){
                return false;
            }

            for(int i = 0; i<ipLength; i++){
                if(!isValidAscii(ip.charAt(i))){
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isValidAscii(char c){
        return Character.isDigit(c) || (Character.toLowerCase(c) >= 'a' && Character.toLowerCase(c) <= 'f') || (Character.toUpperCase(c) >= 'A' && Character.toUpperCase(c) <= 'F');
    }
}


