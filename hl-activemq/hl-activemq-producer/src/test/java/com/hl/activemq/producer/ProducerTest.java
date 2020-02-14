package com.hl.activemq.producer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * 消息生产者
 *
 * @author Hailin
 * @date 2020/2/2
 */
public class ProducerTest {

    @Test
    public void QueueTest() {
        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;
        try {
            // 1、创建ConnectionFactory，用于连接broker
            String brokerUrl = "tcp://127.0.0.1:61616";
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
            // 2、通过连接工厂创建连接
            connection = connectionFactory.createConnection();
            // 3、启动连接
            connection.start();
            // 4、通过连接获取session会话
            // 第一个参数：是否启用ActiveMQ事务，如果第一个参数设置为true，则第二个参数无效
            // 第二个参数：应答模式，AUTO_ACKNOWLEDGE自动应答
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // 5、通过session创建destination，两种目的地Queue和Topic
            // 参数：消息队列的名称，在后台管理系统中可以看到
            Queue queue = session.createQueue("test_queue");
            // 6、通过session创建MessageProducer
            producer = session.createProducer(queue);
            // 7、通过session创建Message
            TextMessage textMessage = session.createTextMessage("this is a queue message");
            // 8、通过producer发送消息
            producer.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (producer != null) {
                    producer.close();
                }
                if (session != null) {
                    session.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void topicTest() {
        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;
        try {
            String brokerUrl = "tcp://127.0.0.1:61616";
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("test_topic");
            producer = session.createProducer(topic);
            TextMessage textMessage = session.createTextMessage("this is a topic message");
            producer.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (producer != null) {
                    producer.close();
                }
                if (session != null) {
                    session.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
