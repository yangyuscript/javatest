package com.lin.ai.schedule;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 10:09 2020/4/27
 */
public class CommonUtils
{
    public static String getIP()
    {
        String ip = null;
        try
        {
            ip = InetAddress.getLocalHost().getHostAddress();
        }
        catch (Throwable ex)
        {
            ip = "127.0.0.1";
        }
        return ip;
    }

    public static String getHostName()
    {
        String hostname = null;
        try
        {
            hostname = InetAddress.getLocalHost().getCanonicalHostName();
        }
        catch (Throwable ex)
        {
            hostname = "Unrecognized";
        }
        return hostname;
    }

    public static String getPID()
    {
        String pid = null;
        try
        {
            pid = ManagementFactory.getRuntimeMXBean().getName();
        }
        catch (Throwable ex)
        {
            pid = "-1";
        }
        return pid;
    }

    public static String getServerName()
    {
        String serverName = System.getProperty("appframe.client.app.name");
        if (isBlank(serverName)) {
            serverName = System.getProperty("appframe.server.name");
        }
        if (isBlank(serverName)) {
            serverName = "DEFAULT_SERVER_" + System.currentTimeMillis();
        }
        return serverName;
    }

    public static boolean isBlank(String s)
    {
        return (s == null) || (s == "") || (s.trim().equals(""));
    }

    public static String getExceptionMesssage(Throwable ex, int length)
    {
        Throwable t = ex;
        int i = 0;
        while ((t.getCause() != null) && (i < 3))
        {
            t = t.getCause();
            i++;
        }
        return StringUtils.substring(ExceptionUtils.getRootCauseMessage(ex), 0, length);
    }

    public static String translateCron(String cron)
    {
        if (StringUtils.isBlank(cron)) {
            return null;
        }
        cron = StringUtils.replace(cron, "-1", "*").trim();
        cron = "0 " + cron;

        String[] tmp = StringUtils.split(cron, " ");
        if (tmp[5].equalsIgnoreCase("*")) {
            tmp[5] = "?";
        }
        cron = StringUtils.join(tmp, " ");
        return cron;
    }

    public static void main(String[] args) {
        System.out.println(getIP());
        System.out.println(getHostName());
        System.out.println(getPID());
        System.out.println(getServerName());
    }
}
