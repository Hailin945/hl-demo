package com.hl.activemq.broker;

import org.apache.activemq.broker.BrokerService;

/**
 * ActiveMQ broker server
 *
 * @author Hailin
 * @date 2020/2/3
 */
public class BrokerTest {

    public static void main(String[] args) {
        try {
            BrokerService brokerService = new BrokerService();
            brokerService.setUseJmx(true);
            brokerService.addConnector("tcp://127.0.0.1:62616");
            brokerService.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
